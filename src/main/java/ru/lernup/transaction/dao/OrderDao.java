package ru.lernup.transaction.dao;

import ru.lernup.transaction.dao.entity.OrderConsumer;

import java.util.List;

public interface OrderDao {
    List<OrderConsumer> getAll();
    OrderConsumer getById(int id);
    void save(OrderConsumer orderConsumer);
    void  deleteByID(int id);
}
