package com.pointingSystem.salary;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Salary {
    private double grossSalary;

    public double getNetSalary(){
        return grossSalary * 0.8;
    }
}
