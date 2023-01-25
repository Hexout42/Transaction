package ru.lernup.transaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.transaction.dao.entity.BookStore;
@Repository
public interface BookStoreRepository extends CrudRepository<BookStore, Long> {
    BookStore findBookStoreByName(String name);
}