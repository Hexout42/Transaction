package ru.lernup.transaction.dao;

import ru.lernup.transaction.dao.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAll();
    Employee getById(int id);
    void save(Employee employee);
    void deleteById (int id);

}
