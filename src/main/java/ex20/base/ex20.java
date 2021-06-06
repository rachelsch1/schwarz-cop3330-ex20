package ex20.base;

/* UCF COP3330 Summer 2021 Assignment 1 Solution
   Copyright 2021 Rachel Schwarz
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class ex20 {
    private static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is the order amount? ");
        String str1 = input.nextLine();
        int amount = Integer.parseInt(str1);

        System.out.print("What state do you live in? ");
        String state = input.nextLine();

        System.out.print("What county do you live in? ");
        String county = input.nextLine();

        double salesTax = 0;
        double tax = 0;
        double total = 0;
        String outputTax = ".";
        String outputTotal = ".";

        if(state.equals("Wisconsin")) {
            salesTax = .05;
            if(county.equals("Eu Claire")){
                salesTax = salesTax + .005;
                tax = amount * salesTax;
                total = amount + tax;
                outputTax = "The tax is $" + df.format(tax) + ".\n";
                outputTotal = "The total is $" + df.format(total) + ".\n";
            }
            else if(county.equals("Dunn")) {
                salesTax = salesTax + .004;
                tax = amount * salesTax;
                total = amount + tax;
                outputTax = "The tax is $" + df.format(tax) + ".\n";
                outputTotal = "The total is $" + df.format(total) + ".\n";
            }
            else {
                tax = amount * salesTax;
                total = amount + tax;
                outputTax = "The tax is $" + df.format(tax) + ".\n";
                outputTotal = "The total is $" + df.format(total) + ".\n";
            }
        }
        else if(state.equals("Illinois")) {
            salesTax = .08;
            tax = amount * salesTax;
            total = amount + tax;
            outputTax = "The tax is $" + df.format(tax) + ".\n";
            outputTotal = "The total is $" + df.format(total) + ".\n";
        }
        else{
            outputTotal = "The total is $" + df.format(total) + ".\n";
        }

        System.out.print((state.equals("Wisconsin") || state.equals("Illinois")) ? outputTax + outputTotal : outputTotal);
    }
}
