package ru.lernup.transaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.transaction.dao.entity.OrderConsumer;
@Repository
public interface OrderRepository extends CrudRepository<OrderConsumer,Integer> {
}
