package ru.lernup.transaction.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "order_consumer")
@Setter
@Getter

public class OrderConsumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne()
    @JoinColumn(name = "id_consumer")
    private Consumer consumer;

    @Column(name = "cost")
    private int cost;
    @OneToMany(mappedBy = "idOrder", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<DetailsOrder> detailsOrders;
    @ManyToOne
    @JoinColumn(name = "id_store")
    private BookStore idStore;

    @Override
    public String toString() {
        return "I'm order by"+ consumer.getAllNameConsumer() + detailsOrders;

    }
}
