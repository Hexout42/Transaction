package ru.lernup.transaction.dao;

import ru.lernup.transaction.dao.entity.Consumer;

import java.util.List;

public interface ConsumerDao {
    List<Consumer> getAll();
    Consumer getById(int id);
    void save(Consumer consumer);
    Consumer getByName(String name);
}
