package ru.lernup.transaction.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "book_store")
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_store")
    private String name;
    @OneToMany(mappedBy = "idStore",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
            @Fetch(FetchMode.SUBSELECT)
   private List<Book> bookList;
    @OneToMany(mappedBy = "idStore",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
   private List<Employee> employees;
    @OneToMany(mappedBy = "idStore",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<OrderConsumer> orders;

    @Override
    public String toString() {
        return name + " all book " + bookList + " employes " + employees + " orders " + orders;
    }
}
