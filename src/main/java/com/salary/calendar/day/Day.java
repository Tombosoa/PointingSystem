package com.salary.calendar.day;

import com.salary.calendar.hours.NightHour;
import lombok.*;

import java.util.Date;
@EqualsAndHashCode
@Setter
@Getter
@ToString
@AllArgsConstructor
public sealed class Day permits NormalDay, Sunday, Holiday {
    private Date date ;
    private NightHour nightHour;

    public Day(Date date) {
        this.date = date;
    }
}
