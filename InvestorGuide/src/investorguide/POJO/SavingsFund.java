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
public class SavingsFund {
    
    private float startingBalance;

    public float getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(float startingBalance) {
        this.startingBalance = startingBalance;
    }
    
    public float calculateRemainFunds(float settlementAmount){
        return startingBalance - settlementAmount;
    }
    
}
