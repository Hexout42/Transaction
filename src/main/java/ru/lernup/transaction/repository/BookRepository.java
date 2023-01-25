package ru.lernup.transaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.transaction.dao.entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
    Book findBookByNameBook(String name);
}
