package com.salary.employe;

import com.salary.calendar.day.NormalDay;
import com.salary.calendar.month.Month;
import com.salary.categories.Category;
import com.salary.categories.CategoryName;
import com.salary.salary.Salary;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employe {
    private String firstname ;
    private String lastname ;
    private String birthdate;
    private String contractStart;
    private String contractEnd;
    private Category category;
    private Salary salary;

    public Employe(String firstname, String lastname, Category category) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.category = category;
    }

    private Salary salaryForSuperior (){
        return category.getSalaryPerWeek();
    }

    private Salary salaryForOthers(Month month){
        return forMonth(month);
    }

    public Salary salaryDetails (Month month){
        if (category.getCategoryName().equals(CategoryName.superior)){
            return salaryForSuperior();
        }
        return salaryForOthers(month);
    }


    private double salaryPerHour(){
        return category.brutPerHour();
    }

    private double forNormalDay (Month month){
        int totalHours = month.getNormalDays()
                .stream().mapToInt(d -> d.getNormalHour().getValue())
                .sum();

        List<NormalDay> withNight = month.getNormalDays()
                .stream().filter(d -> !d.getNightHour().equals(null))
                .toList();

        int totalNightHour = withNight
                .stream().mapToInt(d->d.getNightHour().getValue())
                .sum();

        double extraGainForNight = withNight.get(0).getNightHour().getExtraSupply() * salaryPerHour() * totalNightHour;

        List<NormalDay> extraHour = month.getNormalDays()
                .stream().filter(d-> !d.getExtraHour().equals(null))
                .toList();

        int totalExtraHour = extraHour.stream().mapToInt(d-> d.getExtraHour().getValue())
                .sum();

        double totalGainExtraHour = extraHour.get(0).getExtraHour().getExtraHourSupply() * salaryPerHour() * totalExtraHour;

        return category.getSalaryPerWeek().getBrut() + totalGainExtraHour + extraGainForNight;


    }

    private double forHolidaysHours (Month month){
        int totalHours = month.getHolidays()
                .stream().mapToInt(d->d.getExtraHour().getValue()).sum();

        return   month.getHolidays().get(0).getExtraHour().getExtraHourSupply() * salaryPerHour() * totalHours;


    }

    private double forSundays (Month month){
        int totalHours = month.getSundays()
                .stream().mapToInt(d->d.getExtraHour().getValue()).sum();

        return month.getSundays().get(0).getExtraHour().getExtraHourSupply() * salaryPerHour() * totalHours;


    }

    private Salary forMonth (Month month){
        return new Salary(forSundays(month) + forHolidaysHours(month) + forNormalDay(month));
    }
}
