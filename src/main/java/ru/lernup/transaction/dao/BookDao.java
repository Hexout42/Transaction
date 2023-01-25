package ru.lernup.transaction.dao;

import ru.lernup.transaction.dao.entity.Book;

import java.util.List;

public interface BookDao {
    Book getById(long id);
    List<Book> getAll();
    void save(Book book);
    void deleteByID(long id);
    Integer getQuantity(long id);
    Book findBookByNameBook(String name);

}
