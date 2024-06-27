package com.pointingSystem.salary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Salary {
    private double grossSalary;

    public double getNetSalary(){
        return grossSalary * 0.8;
    }
}
