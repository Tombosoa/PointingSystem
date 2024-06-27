package com.pointingSystem.salary;

import com.pointingSystem.calendar.Calendar;
import com.pointingSystem.calendar.day.Day;
import com.pointingSystem.employee.Employee;
import com.pointingSystem.enums.DayType;
import com.pointingSystem.enums.EmployeeType;

import java.time.LocalDate;
import java.util.List;

public class SalaryCalculator {

    public static double calculateSalaryBetweenDates(LocalDate startDate, LocalDate endDate, Calendar calendar, Employee employee, int normalDaysWork){
        List<Day> givenDays = calendar.getDatesBetween(startDate, endDate);
        double totalSalary = 0.0;

        boolean needsBonus = employee.getType()!= EmployeeType.superior;

        for (Day day : givenDays) {
            boolean isNormalDay = day.getDayType() == DayType.normal;
            boolean isWeekend = day.getDayType() == DayType.weekend;
            boolean isHoliday = day.getDayType() == DayType.holiday;
            boolean isNight = day.getNightHour().getValue() > 0;

            double dayValue = day.getDayHour().getValue();
            double nightValue = day.getNightHour().getValue();

            double salaryMultiplier = 1.0;
            if (needsBonus) {
                if (isNormalDay) {
                    salaryMultiplier = 1.0;
                } else if (isWeekend) {
                    salaryMultiplier = 1.3;
                } else if (isHoliday) {
                    salaryMultiplier = 1.5;
                }
            }

            if (isNight) {
                salaryMultiplier *= 1.3;
            }

            double normalWeeklySalary = employee.getSalary().getGrossSalary() / (normalDaysWork * (dayValue + nightValue));
            double daySalary = normalWeeklySalary * dayValue * salaryMultiplier;
            double nightSalary = normalWeeklySalary * nightValue * salaryMultiplier;

            totalSalary += daySalary + nightSalary;
        }
        return Math.round(totalSalary * 100.0) / 100.0;
    }

    public static int calculateTotalHour(LocalDate startDate, LocalDate endDate, Calendar calendar){
        List<Day> givenDays = calendar.getDatesBetween(startDate, endDate);
        return givenDays.stream()
                .mapToInt(Day::totalHour)
                .sum();
    }
}
