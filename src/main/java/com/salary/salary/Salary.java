package com.salary.salary;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Salary {
    private double brut;
    private double net;

    public Salary(double brut) {
        this.brut = brut;
        this.net = netCalcul();
    }

    private double netCalcul () {
        return brut * 0.8;
    }
}
