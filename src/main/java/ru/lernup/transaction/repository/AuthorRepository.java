package ru.lernup.transaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.transaction.dao.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
    Author findAuthorByAllNameAuthor(String name);


}
