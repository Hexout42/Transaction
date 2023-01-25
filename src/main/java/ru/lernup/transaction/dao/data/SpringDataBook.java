package ru.lernup.transaction.dao.data;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import ru.lernup.transaction.dao.BookDao;
import ru.lernup.transaction.dao.entity.Book;
import ru.lernup.transaction.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
@Component
public class SpringDataBook implements BookDao {
    private final BookRepository bookRepository;

    public SpringDataBook(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getById(long id) {

        return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Book> getAll() {
        Iterable<Book> books = bookRepository.findAll();
        List<Book> allBook = new ArrayList<>();
        books.forEach(allBook::add);
        return allBook;
    }

    @Override
    public void save(Book book) {
     bookRepository.save(book);
    }

    @Override
    public void deleteByID(long id) {
     bookRepository.deleteById(id);
    }

    @Override
    public Integer getQuantity(long id) {
        return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new).getBookHouse().getQuantity();
    }

    @Override
    public Book findBookByNameBook(String name) {
        return bookRepository.findBookByNameBook(name);
    }
}
