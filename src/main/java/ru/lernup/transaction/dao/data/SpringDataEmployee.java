package ru.lernup.transaction.dao.data;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import ru.lernup.transaction.dao.EmployeeDao;
import ru.lernup.transaction.dao.entity.Employee;
import ru.lernup.transaction.repository.EmployeeRepository;

import java.util.List;
@Component
public class SpringDataEmployee implements EmployeeDao {
    private final EmployeeRepository employeeRepository;

    public SpringDataEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void deleteById(int id) {

    }
}
