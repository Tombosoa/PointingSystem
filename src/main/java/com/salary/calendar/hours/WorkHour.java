package com.salary.calendar.hours;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public sealed class WorkHour permits NormalHour, ExtraHour, NightHour {
    private int value ;
}
