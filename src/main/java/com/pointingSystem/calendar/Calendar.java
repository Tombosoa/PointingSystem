package com.pointingSystem.calendar;

import com.pointingSystem.calendar.day.Day;
import com.pointingSystem.calendar.hour.Hour;
import com.pointingSystem.enums.DayType;
import com.pointingSystem.enums.HourType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;

public class Calendar {
    private final List<Day> days;
    private final Hour defaultDayHour;
    private final Hour defaultNightHour;
    private final boolean includeWeekends;

    public Calendar(Hour defaultDayHour, Hour defaultNightHour, boolean includeWeekends) {
        this.days = new ArrayList<>();
        this.defaultDayHour = defaultDayHour;
        this.defaultNightHour = defaultNightHour;
        this.includeWeekends = includeWeekends;
    }

    public void addCustomDays(List<Day> customDays) {
        this.days.addAll(customDays);
    }

    public List<Day> getDatesBetween(LocalDate startDate, LocalDate endDate){
        List<Day> dates = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (currentDate.isBefore(endDate) || currentDate.equals(endDate)){
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

            if (!includeWeekends && (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY)) {
                currentDate = currentDate.plusDays(1);
                continue;
            }

            Day day = new Day();
            day.setDate(currentDate);
            boolean customDayFound = false;
            for (Day customDay : this.days) {
                if (customDay.getDate().equals(currentDate)) {
                    day.setDayHour(customDay.getDayHour());
                    day.setNightHour(customDay.getNightHour());
                    day.setDayType(customDay.getDayType());
                    customDayFound = true;
                    break;
                }
            }
            if (!customDayFound) {
                day.setDayHour(defaultDayHour);
                day.setNightHour(defaultNightHour);
                day.setDayType(DayType.normal);
            }
            dates.add(day);
            currentDate = currentDate.plusDays(1);
        }
        return dates;
    }

    public List<Day> getDatesInMonth(int year, int month){
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);

        return getDatesBetween(startDate, endDate);
    }

    public List<Day> displayWeek(int weekNumber, int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1).withDayOfYear(1)
                .with(DayOfWeek.MONDAY);
        startDate = startDate.plusWeeks(weekNumber - 1);
        LocalDate endDate = startDate.plusDays(6);

        return getDatesBetween(startDate, endDate);
    }

    public int totalAdditionalHour(List<Day> days){
        int additionalDayHour = days.stream()
                .filter(d->d.getDayHour().getType() == HourType.additional)
                .mapToInt(d->d.getDayHour().getValue())
                .sum();
        int additionalNightHour = days.stream()
                .filter(d->d.getNightHour().getType() == HourType.additional)
                .mapToInt(d->d.getNightHour().getValue())
                .sum();

        return additionalDayHour + additionalNightHour;
    }

    public int totalIncreasedHour(List<Day> days){
        int increasedDayHour = days.stream()
                .filter(d->d.getDayHour().getType() == HourType.increased)
                .mapToInt(Day::totalHour)
                .sum();
        int increasedNightHour = days.stream()
                .filter(d->d.getNightHour().getType() == HourType.increased)
                .mapToInt(Day::totalHour)
                .sum();

        return  increasedNightHour + increasedDayHour;
    }

}