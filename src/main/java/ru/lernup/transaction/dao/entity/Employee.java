package ru.lernup.transaction.dao.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Entity
@Table
@Getter
@Setter
public class Employee {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "name")
    private  String name;

    @Override
    public String toString() {
        return name;
    }
    @OneToMany(mappedBy = "idEmployee",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<DetailsOrder> detailsOrders;

    @ManyToOne
    @JoinColumn(name = "id_store")
    private BookStore idStore;
}
