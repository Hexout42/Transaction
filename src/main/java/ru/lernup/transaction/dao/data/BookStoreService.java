package ru.lernup.transaction.dao.data;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.lernup.transaction.dao.entity.*;
import ru.lernup.transaction.dao.exeption.NotHaveBookException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookStoreService {
    private final SpringDataAuthor author;
    private final SpringDataBook book;
    private final SpringDataEmployee employee;
    private final SpringDataOrder order;
    private final SpringDataConsumer consumer;
    private final SpringDataBookStore bookStore;

    public BookStoreService(SpringDataAuthor author, SpringDataBook book,
                            SpringDataEmployee employee, SpringDataOrder order,
                            SpringDataConsumer consumer,
                             SpringDataBookStore bookStore) {
        this.author = author;
        this.book = book;
        this.employee = employee;
        this.order = order;
        this.consumer = consumer;
        this.bookStore = bookStore;

    }
    public Author getAuthor(Long id){
        return author.getById(id);
    }

    public void insertConsumer(String name, String birthDate){
        Consumer consumer1 = new Consumer();
        consumer1.setAllNameConsumer(name);
        consumer1.setBirthDate(birthDate);
        consumer1.setOrderConsumer(new ArrayList<>());
        consumer.save(consumer1);
    }
    public void insertOrderToConsumer(String name,int cost,long idStore){
        OrderConsumer orderConsumer = new OrderConsumer();
        Consumer consumer1 = consumer.getByName(name);
        orderConsumer.setConsumer(consumer1);
        orderConsumer.setCost(cost);
        orderConsumer.setIdStore(bookStore.getStoreById(idStore));
        consumer1.getOrderConsumer().add(orderConsumer);
        order.save(orderConsumer);

    }
    public List<OrderConsumer> getAllOrderToConsumer(String name){
        return  consumer.getByName(name).getOrderConsumer();
    }
    public Consumer getConsumerByName(String name){
        return consumer.getByName(name);
    }
    public List<Book> getAllBookConsumer(String name){
        List<Book> books = new ArrayList<>();
        Consumer consumer1 = consumer.getByName(name);
        consumer1.getOrderConsumer().forEach(cons ->{
            cons.getDetailsOrders().forEach(detailsOrder -> {
                books.add(detailsOrder.getIdBook());
            });
        });

        return books;
    }
    public void insertDetailOrder(int idOrder,String name,int quantity,int idEmployee){
        OrderConsumer orderConsumer = order.getById(idOrder);
        order.deleteByID(orderConsumer.getId());
        DetailsOrder detailsOrder = new DetailsOrder();
        detailsOrder.setIdBook(book.findBookByNameBook(name));
        detailsOrder.setQuantity(quantity);
        detailsOrder.setIdOrder(orderConsumer);
        detailsOrder.setIdEmployee(employee.getById(idEmployee));
        orderConsumer.getDetailsOrders().add(detailsOrder);
        order.save(orderConsumer);
    }
    public void insertBook(String nameStore, String name, int age,int numOfPg,int price,String nameAuthor){
        Book book1 = new Book();
        book1.setNameBook(name);
        book1.setAgeBook(age);
        book1.setPriceBook(price);
        book1.setNumberOfPages(numOfPg);
        bookStore.getStoreByName(nameStore).getBookList().add(book1);
        book1.setIdStore(bookStore.getStoreByName(nameStore));
        author.getByName(nameAuthor).getBooks().add(book1);
        book1.setIdAuthor(author.getByName(nameAuthor));
        book.save(book1);
    }
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {RuntimeException.class})
    public void buyBook(String nameStore,String nameConsumer,String nameBook, int quantity){

try {

    BookStore bookStore1 = bookStore.getStoreByName(nameStore);
    Consumer consumer1 = consumer.getByName(nameConsumer);
    OrderConsumer orderConsumer = new OrderConsumer();
    orderConsumer.setConsumer(consumer1);
    orderConsumer.setIdStore(bookStore1);
    orderConsumer.setDetailsOrders(new ArrayList<DetailsOrder>());
    DetailsOrder detailsOrder = new DetailsOrder();
    detailsOrder.setQuantity(quantity);
    detailsOrder.setIdOrder(orderConsumer);
    detailsOrder.setIdBook(book.findBookByNameBook(nameBook));
    int i = detailsOrder.getIdBook().getBookHouse().getQuantity() - detailsOrder.getQuantity();
    if (i >= 0) {
        detailsOrder.getIdBook().getBookHouse().setQuantity(i);
        orderConsumer.getDetailsOrders().add(detailsOrder);
        consumer1.getOrderConsumer().add(orderConsumer);
        bookStore.save(bookStore1);
        consumer.save(consumer1);
    } else throw new NotHaveBookException(" данная книга была куплена другим пользователем");
} catch (NotHaveBookException e){
    System.out.println(e);
}
        }
    public List<Book> getAllBook(){
        return bookStore.getAllBook();
    }
}