package ru.lernup.transaction.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "book_house")

public class BookHouse {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Book book;


    @Column(name = "quantity")
    private int quantity;
}
