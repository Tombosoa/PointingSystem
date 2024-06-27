package com.pointingSystem.calendar.hour;

import com.pointingSystem.enums.HourType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Hour {
    private HourType type;
    private int value;

    public double calculateRegularPay() {
        return value;
    }

    public double calculateOvertimePay() {
        double overtimePay = 0.0;
        if (value > 40) {
            overtimePay += (value - 40) * 1.3 * calculateRegularPay();
            if (value > 52) {
                overtimePay += (value - 52) * 1.5 * calculateRegularPay();
            }
        }
        return overtimePay;
    }
}
