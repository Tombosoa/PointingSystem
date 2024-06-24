package com.salary.calendar.day;

import com.salary.calendar.hours.ExtraHour;
import com.salary.calendar.hours.NightHour;
import com.salary.calendar.hours.NormalHour;
import lombok.*;

import java.util.Date;
@ToString
@Getter
@Setter
@EqualsAndHashCode

public final class NormalDay extends Day {
    private NormalHour normalHour;
    private ExtraHour extraHour;

    public NormalDay(Date date , NormalHour normalHour) {
        super(date);
        this.normalHour = normalHour;
    }

    public NormalDay(Date date, NightHour nightHour, NormalHour normalHour) {
        super(date, nightHour);
        this.normalHour = normalHour;
    }

    public NormalDay(Date date, NightHour nightHour) {
        super(date, nightHour);
    }

    public NormalDay(Date date, ExtraHour extraHour) {
        super(date);
        this.extraHour = extraHour;
    }

    public NormalDay(Date date, NormalHour normalHour, ExtraHour extraHour) {
        super(date);
        this.normalHour = normalHour;
        this.extraHour = extraHour;
    }
}
