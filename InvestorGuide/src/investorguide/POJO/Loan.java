/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investorguide.POJO;

/**
 *
 * @author Michael
 */
public class Loan {
    private final float LOAN_INITIAL_AMOUNT;
    private final float INTEREST_RATE;
    private final int LOAN_LENGTH;//_IN_YEARS
    private float montlyPayment;
    private float totalLoanAmount;
    private float accruedInterest;//life of loan

    public Loan(float LOAN_INITIAL_AMOUNT, float INTEREST_RATE, int LOAN_LENGTH) {
        this.LOAN_INITIAL_AMOUNT = LOAN_INITIAL_AMOUNT;
        this.INTEREST_RATE = INTEREST_RATE;
        this.LOAN_LENGTH = LOAN_LENGTH;
        this.montlyPayment = calcMontlyPayment();
        this.totalLoanAmount = calcTotalLoanAmount();
        this.accruedInterest = calcAccruedInterest();
        
    }

    public float getLOAN_INITIAL_AMOUNT() {
        return LOAN_INITIAL_AMOUNT;
    }

    public float getINTEREST_RATE() {
        return INTEREST_RATE;
    }

    public int getLOAN_LENGTH() {
        return LOAN_LENGTH;
    }

    public float getMontlyPayment() {
        return montlyPayment;
    }

    public void setMontlyPayment(float montlyPayment) {
        this.montlyPayment = montlyPayment;
    }

    public float getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(float totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public float getAccruedInterest() {
        return accruedInterest;
    }

    public void setAccruedInterest(float accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    private float calcMontlyPayment() {
        float c= INTEREST_RATE/12/100;
        float x = ((Double)Math.pow(1+c, LOAN_LENGTH*12)).floatValue();
        return LOAN_INITIAL_AMOUNT*(c*x)/(x-1);
    }

    private float calcTotalLoanAmount() {
        return montlyPayment*12*LOAN_LENGTH;
    }

    private float calcAccruedInterest() {
        return totalLoanAmount-LOAN_INITIAL_AMOUNT;
    }
    
    
    
    
    
}
