package com.pointingSystem.salary;

import com.pointingSystem.calendar.Calendar;
import com.pointingSystem.calendar.hour.Hour;
import com.pointingSystem.employee.Employee;
import com.pointingSystem.enums.EmployeeType;
import com.pointingSystem.enums.HourType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SalaryCalculatorTest {
    @Test
    public void salary_per_week(){
        Salary salary = new Salary(100000);
        Employee employee = new Employee("Rakoto", "rakoto", EmployeeType.normal, salary);

        Hour defaultDayHour = new Hour(HourType.normal, 8);
        Hour defaultNightHour = new Hour(HourType.normal, 0);

        Calendar calendar = new Calendar(defaultDayHour, defaultNightHour, false);

        LocalDate date = LocalDate.of(2024, 6, 12);

        int weekNumber = 2;
        double weeklySalary = SalaryCalculator.calculateWeeklySalary(employee, calendar, weekNumber, date.getYear());

        Assertions.assertEquals(salary.getGrossSalary(), weeklySalary);
    }


}
