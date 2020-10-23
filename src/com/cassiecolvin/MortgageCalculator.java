package com.cassiecolvin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MortgageCalculator {

    public MortgageCalculator(){

    }

    private double calculateLoanMonthlyPayment(double principal, double annualInterestRate,int periodInYears){
        double monthlyInterestRate = annualInterestRate/100/12;
        int periodInMonths = periodInYears*12;

        double subCalculation1 = Math.pow(monthlyInterestRate+1.0,periodInMonths);
        return Math.round(principal*((monthlyInterestRate*subCalculation1)/(subCalculation1-1.0))*10.0)/10.0;
    }

    private double calculateRemainingBalloonLoanAmountDue(double principal, double monthlyPayment,int actualPeriodInYears){
        return Math.round((principal-(actualPeriodInYears*12)*monthlyPayment)*10.0)/10.0;
    }

    public String displayFixedRateMortgageMonthlyPayment(double principal, double annualInterestRate, int periodInYears){
        return "Your monthly payment is $"+calculateLoanMonthlyPayment(principal,annualInterestRate,periodInYears);
    }

    public String displayBalloonLoanInfo(double principal, double annualInterestRate,int calculatedPeriodInYears,int actualPeriodInYears){
        double monthlyPayment = calculateLoanMonthlyPayment(principal,annualInterestRate,calculatedPeriodInYears);
        double remainingBalance = calculateRemainingBalloonLoanAmountDue(principal,monthlyPayment,actualPeriodInYears);

        return "Your monthly balloon loan payment for a "+actualPeriodInYears+" year loan is $"+monthlyPayment+" with a remaining balance of $"+remainingBalance;
    }
}
