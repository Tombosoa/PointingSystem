package com.salary.calendar.day;

import com.salary.calendar.day.Day;
import com.salary.calendar.hours.ExtraHour;
import com.salary.calendar.hours.NightHour;
import lombok.Getter;

import java.util.Date;
@Getter
public final class Holiday extends Day {
    private ExtraHour extraHour;
    public Holiday(Date date , ExtraHour extraHour) {
        super(date);
        this.extraHour = extraHour;
    }

    public Holiday(Date date, NightHour nightHour, ExtraHour extraHour) {
        super(date, nightHour);
        this.extraHour = extraHour;
    }
}
