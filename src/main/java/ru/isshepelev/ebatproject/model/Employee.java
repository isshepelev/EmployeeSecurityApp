package ru.isshepelev.ebatproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "salary", nullable = false)
    private String salary;
    @Column(name = "position", nullable = false)
    private String position;


    @Column(name = "experience", nullable = false)
    private String experience;
    @Column(name = "age", nullable = false)
    private String age;
    @Column(name = "qualityOfWork", nullable = false)
    private String qualityOfWork;

}
