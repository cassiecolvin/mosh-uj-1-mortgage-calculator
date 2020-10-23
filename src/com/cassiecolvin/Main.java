package com.cassiecolvin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MortgageCalculator calculator = new MortgageCalculator();
        String choice;

        System.out.print("Principal: ");
        double principal = Double.parseDouble(input.nextLine());
        System.out.print("Annual Interest Rate (%): ");
        double annualInterestRate = Double.parseDouble(input.nextLine());
        System.out.print("Period (Years): ");
        int periodInYears = Integer.parseInt(input.nextLine());

        System.out.println("Your Monthly Payment Is $"+calculator.calculateMortgage(principal,annualInterestRate,periodInYears));

    }
}
