package com.cassiecolvin;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    static DecimalFormat decimalFormat = new DecimalFormat("$0.00");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Principal: ");
        double principal = input.nextFloat();
        System.out.print("Annual Interest Rate (%): ");
        double annualInterestRate = input.nextFloat();
        System.out.print("Period (Years): ");
        int periodInYears = input.nextInt();
        System.out.println("Your Monthly Payment Is "+decimalFormat.format(calculateMortgage(100000f,6.0f,15)));
    }

    public static double calculateMortgage(double principal, double annualInterestRate, int periodInYears){
        double monthlyInterestRate = calculateMonthlyInterestRate(annualInterestRate);
        int periodInMonths = periodInYears*12;
        return principal*((monthlyInterestRate*Math.pow((1+monthlyInterestRate),periodInMonths))/(Math.pow((1+monthlyInterestRate),periodInMonths)-1));
    }

    public static double calculateMonthlyInterestRate(double annualInterestRate){
        return annualInterestRate/100/12;
    }
}
