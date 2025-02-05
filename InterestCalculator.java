package DataStructures;  // Only include if you are using a package

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput = "y";
        
        while (continueInput.equalsIgnoreCase("y")) {
            // Getting loan amount and interest rate from user
            System.out.print("Enter the loan amount: ");
            BigDecimal loanAmount = scanner.nextBigDecimal();
            
            System.out.print("Enter the interest rate (in %): ");
            BigDecimal interestRate = scanner.nextBigDecimal();
            
            // Calculating interest: interest = loanAmount * (interestRate / 100)
            BigDecimal interest = loanAmount.multiply(interestRate);
            
            // Rounding interest to 2 decimal places
            interest = interest.setScale(2, RoundingMode.HALF_UP);
            
            // Formatting loan amount and interest as currency and percentage
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            NumberFormat percentFormat = NumberFormat.getPercentInstance();
            percentFormat.setMaximumFractionDigits(3); // Setting percentage to 3 decimal places
            
            // Displaying results
            System.out.println("Loan Amount: " + currencyFormat.format(loanAmount));
            System.out.println("Interest Rate: " + percentFormat.format(interestRate));  // No need to divide by 100, already in percentage format
            System.out.println("Interest Amount: " + currencyFormat.format(interest));
            
            // Asking user if they want to continue
            System.out.print("Would you like to calculate again? (y/n): ");
            continueInput = scanner.next();
        }
        
        
        scanner.close();
    }
}
