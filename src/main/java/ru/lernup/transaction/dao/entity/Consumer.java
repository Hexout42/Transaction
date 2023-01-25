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
@Table


public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "all_name_consumer")
    private String allNameConsumer;

    @Column(name = "birth_date")
    private String birthDate;
    @OneToMany(mappedBy = "consumer", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<OrderConsumer> orderConsumer;

    @Override
    public String toString() {
        return allNameConsumer + " " + birthDate + orderConsumer;
    }
}
