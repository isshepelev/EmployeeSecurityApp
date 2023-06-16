package ru.isshepelev.ebatproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin")
public class AdminEmployeeController {
    final EmployeeService service;

    public AdminEmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String saveEmployeePage(Employee employee){
        return "admin-employee-create";
    }

    @PostMapping("/createEmployee")
    public String saveEmployee(Employee employee){
        service.save(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/employee")
    public String allEmployee(Model model){
        List<Employee> employees = service.allEmployee();
        model.addAttribute("employees", employees);
        return "admin-employee-list";
    }

    @GetMapping("/employee/{id}")
    public String info(@PathVariable("id") Long id, Model model){
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "admin-employee-info";
    }

    @GetMapping("/employee/{id}/edit")
    public String updateForm(@PathVariable("id") Long id, Model model){
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "admin-employee-update";
    }

    @PostMapping("/employees/{id}/editEmployee")
    public String update(Employee employee){
        service.save(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/employee/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/admin/employee";
    }

}
