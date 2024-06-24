package com.salary.calendar.hours;

import lombok.Getter;

@Getter
public final class NightHour extends WorkHour {
    private double extraSupply ;
    public NightHour(int value , double extraSupply ) {
        super(value);
        this.extraSupply = extraSupply;
    }
}
