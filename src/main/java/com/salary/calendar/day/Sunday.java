package com.salary.calendar.day;

import com.salary.calendar.day.Day;
import com.salary.calendar.hours.ExtraHour;
import com.salary.calendar.hours.NightHour;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@EqualsAndHashCode
@ToString
@Getter
@Setter
public final class Sunday extends Day {
    private ExtraHour extraHour;
    public Sunday(Date date , ExtraHour extraHour) {
        super(date);
        this.extraHour = extraHour;
    }

    public Sunday(Date date, NightHour nightHour, ExtraHour extraHour) {
        super(date, nightHour);
        this.extraHour = extraHour;
    }
}
