package ru.lernup.transaction.dao;

import ru.lernup.transaction.dao.entity.Author;
import ru.lernup.transaction.dao.entity.Book;

import java.util.List;

public interface AuthorDao {
    Author getById(Long id);
    List<Author> getAll();
    void save(Author author);
    void deleteById(Long  id);
    List<Book> getBooks(Long id);
    Author getByName(String name);

}
