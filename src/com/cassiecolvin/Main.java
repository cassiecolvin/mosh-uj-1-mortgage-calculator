package com.cassiecolvin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MortgageCalculator calculator = new MortgageCalculator();

        System.out.print("Principal: ");
        double principal = input.nextDouble();
        System.out.print("Annual Interest Rate (%): ");
        double annualInterestRate = input.nextDouble();
        System.out.print("Period (Years): ");
        int periodInYears = input.nextInt();

        //convert input to BD
        BigDecimal bdPrincipal = new BigDecimal(principal);
        BigDecimal bdAnnualInterestRate = new BigDecimal(annualInterestRate);

        System.out.println("Your Monthly Payment Is "+calculator.calculateMortgage(bdPrincipal,bdAnnualInterestRate,periodInYears).setScale(1,RoundingMode.HALF_UP));
    }
}
