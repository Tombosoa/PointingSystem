package com.salary.categories;

import com.salary.calendar.hours.NormalHour;
import com.salary.salary.Salary;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Category {
    private CategoryName categoryName;
    private NormalHour normalHour;
    private Salary salaryPerWeek ;

    public double brutPerHour(){
        return salaryPerWeek.getBrut() / normalHour.getValue();
    }
}
