package com.pointingSystem.employee;

import com.pointingSystem.enums.EmployeeType;
import com.pointingSystem.salary.Salary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String firstname;
    private String lastname;
    private EmployeeType type;
    private Salary salary;
}
