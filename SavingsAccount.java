/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package savingsaccount;

/**
 *
 * @author rwm5592
 */
public class SavingsAccount {
    private static double annualInterestRate ;
    private double savingsBalance;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        
        setInterestRate(.04);
        
        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);
        
        System.out.printf("%s%s\t\t%s\t\t%s\n","Savings Account Balances\n","Month","Saver1","Saver2");
        
        for (int month = 1; month <= 12; month++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            
            System.out.printf("%d\t\t%.2f\t\t%.2f\n",month,saver1.savingsBalance,saver2.savingsBalance);
        }
        
        setInterestRate(.05);
        
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        
        System.out.printf("%s\t\t%.2f\t\t%.2f\n","13",saver1.savingsBalance,saver2.savingsBalance);
    }
    
    
    public void calculateMonthlyInterest() {
       savingsBalance =  (savingsBalance * annualInterestRate)/12 + savingsBalance;
    }
    
    public static void setInterestRate(double annualInterestRate) {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;      
    }
}
