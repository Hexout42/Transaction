package ru.lernup.transaction.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "details_order")

public class DetailsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     @JoinColumn(name = "id_order")
     @ManyToOne
    private OrderConsumer idOrder;
   @ManyToOne
   @JoinColumn(name = "id_book")

    private Book idBook;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee idEmployee;

    @Override
    public String toString() {
        return "DetailsOrder{ name consumer" + idOrder.getConsumer().getAllNameConsumer() + " book " +
        idBook.getNameBook() +
                " quantity= " + quantity +
                '}';
    }
}
