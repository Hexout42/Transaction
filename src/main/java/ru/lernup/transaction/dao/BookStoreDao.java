package ru.lernup.transaction.dao;

import ru.lernup.transaction.dao.entity.Book;
import ru.lernup.transaction.dao.entity.BookStore;
import ru.lernup.transaction.dao.entity.Employee;
import ru.lernup.transaction.dao.entity.OrderConsumer;

import java.util.List;

public interface BookStoreDao {
    List<Book> getAllBook();
    List<OrderConsumer> getAllOrderByIDStore(Long id);
    List<Employee> getAllEmployeeByIDStore(Long id);
    List<BookStore> getAllBookStore();
    BookStore getStoreById(Long id);
    BookStore getStoreByName(String name);
    void save(BookStore bookStore);
}
