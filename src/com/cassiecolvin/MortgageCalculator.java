package com.cassiecolvin;

import java.math.BigDecimal;
import java.math.MathContext;

public class MortgageCalculator {

    public MortgageCalculator(){

    }

    public BigDecimal calculateMortgage(BigDecimal principal, BigDecimal annualInterestRate, int periodInYears){
        BigDecimal bd1 = new BigDecimal("1.0");

        //Perform initial calculations to scale of monthly payments vs annual
        BigDecimal monthlyInterestRate = calculateMonthlyInterestRate(annualInterestRate);
        int periodInMonths = periodInYears*12;

        //Perform math to calculate monthly mortgage rate
        BigDecimal subCalculation1 = (monthlyInterestRate.add(bd1)).pow(periodInMonths, MathContext.DECIMAL128);
        return principal.multiply(monthlyInterestRate.multiply(subCalculation1,MathContext.DECIMAL128).divide(subCalculation1.subtract(bd1),MathContext.DECIMAL128),MathContext.DECIMAL128);
    }

    public BigDecimal calculateMonthlyInterestRate(BigDecimal annualInterestRate){
        BigDecimal outOf100 = new BigDecimal("100.0");
        BigDecimal monthsInYear = new BigDecimal("12.0");
        return (annualInterestRate.divide(outOf100)).divide(monthsInYear);
    }
}
