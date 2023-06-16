package ru.isshepelev.ebatproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.ebatproject.model.Employee;
import ru.isshepelev.ebatproject.service.EmployeeService;

import java.util.List;

@Controller
public class UserEmployeeController {
    final EmployeeService service;

    public UserEmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee")
    public String allEmployee(Model model){
        List<Employee> employees = service.allEmployee();
        model.addAttribute("employees", employees);
        return "user-employee-list";
    }

    @GetMapping("/employee/{id}")
    public String info(@PathVariable("id") Long id, Model model){
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "user-employee-info";
    }
}
