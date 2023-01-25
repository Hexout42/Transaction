package ru.lernup.transaction.dao.data;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import ru.lernup.transaction.dao.AuthorDao;
import ru.lernup.transaction.dao.entity.Author;
import ru.lernup.transaction.dao.entity.Book;
import ru.lernup.transaction.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
@Component
public class SpringDataAuthor implements AuthorDao {
    private final AuthorRepository authorRepository;



    public SpringDataAuthor(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Author> getAll() {
        Iterable<Author> authors = authorRepository.findAll();
        List<Author> allAuthor = new ArrayList<>();
        authors.forEach(allAuthor::add);
        return allAuthor;
    }

    @Override
    public void save(Author author) {
      authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
    public List<Book> getBooks(Long id){
       return authorRepository.findById(id).orElseThrow(EntityNotFoundException::new).getBooks();
    }

    @Override
    public Author getByName(String name) {
        return authorRepository.findAuthorByAllNameAuthor(name);
    }


}
