/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investorguide;

import investorguide.POJO.Property;
import investorguide.POJO.SavingsFund;

/**
 *
 * @author Michael
 */
public class TesterMain {
    public static void main(String[] args) {
        SavingsFund fund = new SavingsFund(135000f);
        System.out.println("Property Info:\n");
        Property snowBird = new Property("2701 Snowbird",280000f,35f, 2500f, 2049.40f, 2544, Property.FREQUENCY.YEARLY, 3500f);
        snowBird.toString();
        System.out.println("Savings Info:\n");
        System.out.println(fund.calculateRemainFunds(snowBird)+"");
        
        
    }
    
    
}
