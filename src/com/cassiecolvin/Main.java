package com.cassiecolvin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MortgageCalculator calculator = new MortgageCalculator();
        String choice;

        do {
            System.out.print("[1] Fixed Rate Mortgage\n[2] Ballon Loan\nWhat type of mortgage loan do you have?: ");
            choice = input.nextLine();
            if (choice.equals("1")){
                System.out.print("Principal: ");
                double principal = Double.parseDouble(input.nextLine());
                System.out.print("Annual Interest Rate (%): ");
                double annualInterestRate = Double.parseDouble(input.nextLine());
                System.out.print("Period (Years): ");
                int periodInYears = Integer.parseInt(input.nextLine());
                System.out.println(calculator.displayFixedRateMortgageMonthlyPayment(principal,annualInterestRate,periodInYears));
            }
            else if (choice.equals("2")){
                System.out.print("Principal: ");
                double principal = Double.parseDouble(input.nextLine());
                System.out.print("Annual Interest Rate (%): ");
                double annualInterestRate = Double.parseDouble(input.nextLine());
                System.out.print("Calculated Period (Years): ");
                int calculatedPeriodInYears = Integer.parseInt(input.nextLine());
                System.out.print("Actual Period (Years): ");
                int actualPeriodInYears = Integer.parseInt(input.nextLine());
                System.out.println(calculator.displayBalloonLoanInfo(principal,annualInterestRate,calculatedPeriodInYears,actualPeriodInYears));
            }
            else
                System.out.println("Invalid Choice! Please try again...");

        } while (!choice.equals("1") && !choice.equals("2"));

    }
}
