package com.salary.calendar.hours;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public final class ExtraHour extends WorkHour {
    private double extraHourSupply ;
    public ExtraHour(int value , double extraHourSupply) {
        super(value);
        this.extraHourSupply = extraHourSupply;
    }
}
