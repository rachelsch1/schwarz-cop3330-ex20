package ex20.base;

/* More complex programs may have decisions nested in other decisions, so that when one decision is made, additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state. The program prompts the user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone else.

Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.

Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.

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
