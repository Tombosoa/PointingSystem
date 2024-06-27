package com.pointingSystem.calendar.day;

import com.pointingSystem.calendar.hour.Hour;
import com.pointingSystem.enums.DayType;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Day {
    private Hour dayHour;
    private Hour nightHour;
    private DayType dayType;
    private LocalDate date;
}
