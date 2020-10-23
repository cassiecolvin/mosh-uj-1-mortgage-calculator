package com.cassiecolvin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MortgageCalculator {

    public MortgageCalculator(){

    }

    public double calculateMortgage(double principal, double annualInterestRate,int periodInYears){
        double monthlyInterestRate = annualInterestRate/100/12;
        int periodInMonths = periodInYears*12;

        double subCalculation1 = Math.pow(monthlyInterestRate+1.0,periodInMonths);
        return Math.round(principal*((monthlyInterestRate*subCalculation1)/(subCalculation1-1.0))*10.0)/10.0;
    }
}
