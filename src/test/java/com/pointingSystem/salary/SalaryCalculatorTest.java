package com.pointingSystem.salary;

import com.pointingSystem.calendar.Calendar;
import com.pointingSystem.calendar.day.Day;
import com.pointingSystem.calendar.hour.Hour;
import com.pointingSystem.employee.Employee;
import com.pointingSystem.enums.DayType;
import com.pointingSystem.enums.EmployeeType;
import com.pointingSystem.enums.HourType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SalaryCalculatorTest {

    @Test
    public void rakoto_guard_salary(){
        var salary = new Salary(100000);
        var employee = new Employee("Rakoto", "rakoto", EmployeeType.guard, salary);

        var defaultDayHour = new Hour(HourType.normal, 10);
        var defaultNightHour = new Hour(HourType.normal, 0);

        var calendar = new Calendar(defaultDayHour, defaultNightHour, true);

        var the_26_mai = LocalDate.of(2024, 5, 26);
        var the_06_july = LocalDate.of(2024, 7, 6);

        var totalSalary = SalaryCalculator.calculateSalaryBetweenDates(the_26_mai, the_06_july, calendar, employee, 7);

        Assertions.assertEquals(600000, totalSalary);
    }

    @Test
    public void rabe_guard_salary(){
        var salary = new Salary(100000);
        var employee = new Employee("Rabe", "rabe", EmployeeType.guard, salary);

        var defaultDayHour = new Hour(HourType.normal, 0);
        var defaultNightHour = new Hour(HourType.normal, 14);

        var calendar = new Calendar(defaultDayHour, defaultNightHour, true);

        var the_26_mai = LocalDate.of(2024, 5, 26);
        var the_06_july = LocalDate.of(2024, 7, 6);

        var totalSalary = SalaryCalculator.calculateSalaryBetweenDates(the_26_mai, the_06_july, calendar, employee, 7);

        Assertions.assertEquals(780000, totalSalary);
    }

    @Test
    public void rakoto_total_hours(){
        var salary = new Salary(100000);
        var employee = new Employee("Rakoto", "rakoto", EmployeeType.guard, salary);

        var defaultDayHour = new Hour(HourType.normal, 10);
        var defaultNightHour = new Hour(HourType.normal, 0);

        var calendar = new Calendar(defaultDayHour, defaultNightHour, true);

        var the_26_mai = LocalDate.of(2024, 5, 26);
        var the_06_july = LocalDate.of(2024, 7, 6);

        var totalHours = SalaryCalculator.calculateTotalHour(the_26_mai, the_06_july,calendar,employee);

        Assertions.assertEquals(420, totalHours);
    }

    @Test
    public void rabe_total_hours(){
        var salary = new Salary(100000);
        var employee = new Employee("Rabe", "rabe", EmployeeType.guard, salary);

        var defaultDayHour = new Hour(HourType.normal, 0);
        var defaultNightHour = new Hour(HourType.normal, 14);

        var calendar = new Calendar(defaultDayHour, defaultNightHour, true);

        var the_26_mai = LocalDate.of(2024, 5, 26);
        var the_06_july = LocalDate.of(2024, 7, 6);

        var totalHours = SalaryCalculator.calculateTotalHour(the_26_mai, the_06_july,calendar,employee);

        Assertions.assertEquals(588, totalHours);
    }

    @Test
    public void rakoto_guard_salary_with_custom_days(){
        var salary = new Salary(100000);
        var employee = new Employee("Rakoto", "rakoto", EmployeeType.guard, salary);

        List<Day> customDays = new ArrayList<>();
        var the_17_june = new Day(new Hour(HourType.normal, 10), new Hour(HourType.normal, 0), DayType.holiday, LocalDate.of(2024, 6, 17));
        var the_25_june = new Day(new Hour(HourType.normal, 10), new Hour(HourType.normal, 0), DayType.holiday, LocalDate.of(2024, 6, 25));
        var the_26_june = new Day(new Hour(HourType.normal, 10), new Hour(HourType.normal, 0), DayType.holiday, LocalDate.of(2024, 6, 26));

        customDays.add(the_17_june);
        customDays.add(the_25_june);
        customDays.add(the_26_june);

        var defaultDayHour = new Hour(HourType.normal, 10);
        var defaultNightHour = new Hour(HourType.normal, 0);

        var calendar = new Calendar(defaultDayHour, defaultNightHour, true);
        calendar.addCustomDays(customDays);

        var the_26_mai = LocalDate.of(2024, 5, 26);
        var the_06_july = LocalDate.of(2024, 7, 6);

        var totalSalary = SalaryCalculator.calculateSalaryBetweenDates(the_26_mai, the_06_july, calendar, employee, 7);

        Assertions.assertEquals(621428.57, totalSalary);
    }

    @Test
    public void rabe_guard_salary_with_custom_days(){
        var salary = new Salary(100000);
        var employee = new Employee("Rabe", "rabe", EmployeeType.guard, salary);

        List<Day> customDays = new ArrayList<>();
        var the_17_june = new Day(new Hour(HourType.normal, 0), new Hour(HourType.normal, 14), DayType.holiday, LocalDate.of(2024, 6, 17));
        var the_25_june = new Day(new Hour(HourType.normal, 0), new Hour(HourType.normal, 14), DayType.holiday, LocalDate.of(2024, 6, 25));
        var the_26_june = new Day(new Hour(HourType.normal, 0), new Hour(HourType.normal, 14), DayType.holiday, LocalDate.of(2024, 6, 26));

        customDays.add(the_17_june);
        customDays.add(the_25_june);
        customDays.add(the_26_june);

        var defaultDayHour = new Hour(HourType.normal, 0);
        var defaultNightHour = new Hour(HourType.normal, 14);

        var calendar = new Calendar(defaultDayHour, defaultNightHour, true);
        calendar.addCustomDays(customDays);

        var the_26_mai = LocalDate.of(2024, 5, 26);
        var the_06_july = LocalDate.of(2024, 7, 6);

        var totalSalary = SalaryCalculator.calculateSalaryBetweenDates(the_26_mai, the_06_july, calendar, employee, 7);

        Assertions.assertEquals(807857.14, totalSalary);
    }
}
