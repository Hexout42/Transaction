package ru.lernup.transaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.transaction.dao.entity.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}