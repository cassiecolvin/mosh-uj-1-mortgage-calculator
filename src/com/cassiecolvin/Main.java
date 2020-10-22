package com.cassiecolvin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MortgageCalculator calculator = new MortgageCalculator();
        String choice;
        do{
            System.out.print("Principal: ");
            double principal = Double.parseDouble(input.nextLine());
            System.out.print("Annual Interest Rate (%): ");
            double annualInterestRate = Double.parseDouble(input.nextLine());
            System.out.print("Period (Years): ");
            int periodInYears = Integer.parseInt(input.nextLine());
            System.out.print("[1] - Higher accuracy\n[2] - Standard accuracy\nHigher accuracy or Standard accuracy?: ");
            choice = input.nextLine();
            if (choice.equals("1")){
                //convert input to BD
                BigDecimal bdPrincipal = new BigDecimal(principal);
                BigDecimal bdAnnualInterestRate = new BigDecimal(annualInterestRate);
                System.out.println("Your Monthly Payment Is $"+calculator.calculateMortgage(bdPrincipal,bdAnnualInterestRate,periodInYears).setScale(1,RoundingMode.HALF_UP));

            } else if (choice.equals("2")){
                System.out.println("Your Monthly Payment Is $"+calculator.calculateMortgage(principal,annualInterestRate,periodInYears));
            } else {
                System.out.print("Invalid Choice, Please try again");
            }
        } while(!choice.equals("1") && !choice.equals("2"));
    }
}
