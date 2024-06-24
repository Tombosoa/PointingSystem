package com.salary.calendar.month;

import com.salary.calendar.day.Holiday;
import com.salary.calendar.day.NormalDay;
import com.salary.calendar.day.Sunday;
import lombok.*;

import java.util.List;
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Month {
    private List<NormalDay> normalDays;
    private List<Sunday> sundays;
    private List<Holiday> holidays;

    public Month(List<NormalDay> normalDays, List<Sunday> sundays) {
        this.normalDays = normalDays;
        this.sundays = sundays;
    }
}
