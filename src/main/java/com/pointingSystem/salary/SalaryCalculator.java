package com.pointingSystem.salary;

import com.pointingSystem.calendar.Calendar;
import com.pointingSystem.calendar.day.Day;
import com.pointingSystem.employee.Employee;
import com.pointingSystem.enums.DayType;
import com.pointingSystem.enums.HourType;

import java.time.LocalDate;
import java.util.List;

public class SalaryCalculator {

    public double calculateMonthlySalary(Employee employee, Calendar calendar, LocalDate date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        List<Day> daysInMonth = calendar.getDatesInMonth(year, month);

        double totalSalary = 0.0;

        for (Day day : daysInMonth) {
            boolean isNormalDay = (day.getDayHour().getType() == HourType.normal) && day.getDayType() == DayType.normal;
            double dayValue = day.getDayHour().getValue();
            double nightValue = day.getNightHour().getValue();

            switch (employee.getType()) {
                case superior:
                    // todo
                    break;
                case normal:
                    if(isNormalDay){
                        double weeklySalary = employee.getSalary().getGrossSalary() / (daysInMonth.size() * (dayValue+nightValue));
                        double daySalary = dayValue * weeklySalary;
                        double nightSalary = nightValue * weeklySalary;

                        totalSalary += daySalary + nightSalary;
                    }
                    break;
                case guard:
                    double guardWeeklySalary = employee.getSalary().getGrossSalary() / (daysInMonth.size() * (dayValue+nightValue));
                    double guardDaySalary = dayValue * guardWeeklySalary;
                    double guardNightSalary = nightValue * guardWeeklySalary;

                    totalSalary += guardDaySalary + guardNightSalary;
                    break;
                case driver:
                    double driverWeeklySalary = employee.getSalary().getGrossSalary() / (daysInMonth.size() * (dayValue+nightValue));
                    double driverDaySalary = dayValue * driverWeeklySalary;
                    double driverNightSalary = nightValue * driverDaySalary;

                    totalSalary += driverDaySalary + driverNightSalary;
                    break;
                default:
                    break;
            }
        }

        return totalSalary;
    }

    public static double calculateWeeklySalary(Employee employee, Calendar calendar, int weekNumber, int year) {
        List<Day> daysInWeek = calendar.displayWeek(weekNumber, year);

        double totalSalary = 0.0;

        for (Day day : daysInWeek) {
            boolean isNormalDay = (day.getDayHour().getType() == HourType.normal) && day.getDayType() == DayType.normal;
            boolean isSundayAdditional = (day.getDayHour().getType() == HourType.additional) && day.getDayType() == DayType.normal;
            double dayValue = day.getDayHour().getValue();
            double nightValue = day.getNightHour().getValue();

            switch (employee.getType()) {
                case superior:
                    //todo
                    break;
                case normal:
                    if(isNormalDay){
                        double normalWeeklySalary = employee.getSalary().getGrossSalary() / (daysInWeek.size() * (dayValue+nightValue));
                        double daySalary = normalWeeklySalary * dayValue;
                        double nightSalary = normalWeeklySalary * nightValue;

                        totalSalary += daySalary + nightSalary;
                    }
                    break;
                case guard:
                    double guardWeeklySalary = employee.getSalary().getGrossSalary() / (daysInWeek.size() * (dayValue+nightValue));
                    double guardDaySalary = dayValue * guardWeeklySalary;
                    double guardNightSalary = nightValue * guardWeeklySalary;

                    totalSalary += guardDaySalary + guardNightSalary;
                    break;
                case driver:
                    double driverWeeklySalary = employee.getSalary().getGrossSalary() / (daysInWeek.size() * (dayValue+nightValue));
                    double driverDaySalary = dayValue * driverWeeklySalary;
                    double driverNightSalary = nightValue * driverDaySalary;

                    totalSalary += driverDaySalary + driverNightSalary;
                    break;
                default:
                    break;
            }
        }
        return totalSalary;
    }
}
