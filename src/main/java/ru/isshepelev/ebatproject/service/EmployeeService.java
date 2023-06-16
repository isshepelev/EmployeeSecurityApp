package ru.isshepelev.ebatproject.service;

import org.springframework.stereotype.Service;
import ru.isshepelev.ebatproject.model.Employee;
import ru.isshepelev.ebatproject.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    public List<Employee> allEmployee(){
        return repository.findAll();
    }


    public Employee save(Employee employee){
        return repository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return repository.findById(id).orElse(null);
    }

}
