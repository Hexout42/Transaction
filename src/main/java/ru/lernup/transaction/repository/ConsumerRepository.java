package ru.lernup.transaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.transaction.dao.entity.Consumer;
@Repository
public interface ConsumerRepository extends CrudRepository<Consumer, Integer> {
    Consumer findConsumerByAllNameConsumer(String name);
}