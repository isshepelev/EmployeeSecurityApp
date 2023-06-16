package ru.isshepelev.ebatproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.isshepelev.ebatproject.model.Employee;
import ru.isshepelev.ebatproject.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerEmployeeController {
    final EmployeeService service;

    public ManagerEmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String saveEmployeePage(Employee employee){
        return "manager-employee-create";
    }

    @PostMapping("/createEmployee")
    public String saveEmployee(Employee employee){
        service.save(employee);
        return "redirect:/manager/employee";
    }

    @GetMapping("/employee")
    public String allEmployee(Model model){
        List<Employee> employees = service.allEmployee();
        model.addAttribute("employees", employees);
        return "manager-employee-list";
    }

    @GetMapping("/employee/{id}")
    public String info(@PathVariable("id") Long id, Model model){
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "manager-employee-info";
    }

    @GetMapping("/employee/{id}/edit")
    public String updateForm(@PathVariable("id") Long id, Model model){
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "manager-employee-update";
    }

    @PostMapping("/employees/{id}/editEmployee")
    public String update(Employee employee){
        service.save(employee);
        return "redirect:/manager/employee";
    }
}
