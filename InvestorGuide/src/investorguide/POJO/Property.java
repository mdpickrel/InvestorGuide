/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investorguide.POJO;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Michael
 */
public class Property {
    private String description;
    private Loan loan;
    private float askingPrice;
    private float downPaymentPercent;
    private float investmentAmount;
    private float earnestMoneyDeposit;
    private float taxPerYear;
    private float hoa;
    private FREQUENCY hoaFrequency;
    private float insurancePerYear;
    private float averageRepairCostsPerYear;
    private float costPerMonth;
    private float desiredProfitPerYear;
    private float rentPerMonth;
    private float roi;
    private float settlementCashRequired;
    private String address;
    private boolean garage;
    private int numOfBeds;
    private float numOfBaths;
    private int sqft;
    private float lotSize;
    private boolean sufficientParking;
    private String mlsNumber;
    private boolean coop;

    public enum FREQUENCY{
        YEARLY,MONTHLY,QUARTERLY;
    }
    
    public Property() {
        this.loan = new Loan(0, 4.5f, 0);
    }

    public Property(String description,float askingPrice, float downPaymentPercent, float earnestMoneyDeposit, float taxPerYear, float hoa, FREQUENCY hoaFrequency, float desiredProfitPerYear) {
        this.askingPrice = askingPrice;
        this.description = description;
        this.downPaymentPercent = downPaymentPercent;
        this.earnestMoneyDeposit = earnestMoneyDeposit;
        this.taxPerYear = taxPerYear;
        this.hoaFrequency = hoaFrequency;
        this.hoa = hoa;
        this.desiredProfitPerYear = desiredProfitPerYear;
        this.loan = new Loan((askingPrice-calculateInvestmentAmount()), 4.5f,30);
        calculateAll();
    }
    

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public float getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(float askingPrice) {
        this.askingPrice = askingPrice;
    }

    public float getDownPaymentPercent() {
        return downPaymentPercent;
    }

    public void setDownPaymentPercent(float downPaymentPercent) {
        this.downPaymentPercent = downPaymentPercent;
    }

    public float getEarnestMoneyDeposit() {
        return earnestMoneyDeposit;
    }

    public void setEarnestMoneyDeposit(float earnestMoneyDeposit) {
        this.earnestMoneyDeposit = earnestMoneyDeposit;
    }

    public float getTaxPerYear() {
        return taxPerYear;
    }

    public void setTaxPerYear(float taxPerYear) {
        this.taxPerYear = taxPerYear;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public FREQUENCY getHoaFrequency() {
        return hoaFrequency;
    }

    public void setHoaFrequency(FREQUENCY hoaFrequency) {
        this.hoaFrequency = hoaFrequency;
    }

    public float getInsurancePerYear() {
        return insurancePerYear;
    }

    public void setInsurancePerYear(float insurancePerYear) {
        this.insurancePerYear = insurancePerYear;
    }

    public float getAverageRepairCostsPerYear() {
        return averageRepairCostsPerYear;
    }

    public void setAverageRepairCostsPerYear(float averageRepairCostsPerYear) {
        this.averageRepairCostsPerYear = averageRepairCostsPerYear;
    }

    public float getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(float costPerMonth) {
        this.costPerMonth = costPerMonth;
    }

    public float getDesiredProfitPerYear() {
        return desiredProfitPerYear;
    }

    public void setDesiredProfitPerYear(float desiredProfitPerYear) {
        this.desiredProfitPerYear = desiredProfitPerYear;
    }

    public float getRentPerMonth() {
        return rentPerMonth;
    }

    public void setRentPerMonth(float rentPerMonth) {
        this.rentPerMonth = rentPerMonth;
    }

    public float getRoi() {
        return roi;
    }

    public void setRoi(float roi) {
        this.roi = roi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasGarage() {
        return garage;
    }    

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public float getNumOfBaths() {
        return numOfBaths;
    }

    public void setNumOfBaths(float numOfBaths) {
        this.numOfBaths = numOfBaths;
    }

    public int getSqft() {
        return sqft;
    }

    public void setSqft(int sqft) {
        this.sqft = sqft;
    }

    public float getLotSize() {
        return lotSize;
    }

    public void setLotSize(float lotSize) {
        this.lotSize = lotSize;
    }

    public boolean isSufficientParking() {
        return sufficientParking;
    }

    public void setSufficientParking(boolean sufficientParking) {
        this.sufficientParking = sufficientParking;
    }

    public String getMlsNumber() {
        return mlsNumber;
    }

    public void setMlsNumber(String mlsNumber) {
        this.mlsNumber = mlsNumber;
    }

    public boolean isCoop() {
        return coop;
    }

    public void setCoop(boolean coop) {
        this.coop = coop;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(float investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public float getSettlementCashRequired() {
        return settlementCashRequired;
    }

    public void setSettlementCashRequired(float settlementCashRequired) {
        this.settlementCashRequired = settlementCashRequired;
    }
    
    
    public float calculateMontlyCost(){
        costPerMonth = (taxPerYear+calculateHoa(FREQUENCY.YEARLY)+insurancePerYear+averageRepairCostsPerYear)/12+loan.getMontlyPayment(); 
        return costPerMonth;
    }
    
    public float calculateMonthlRent(){
        rentPerMonth = costPerMonth+(calculateMontlyProfit());
        return rentPerMonth;
    }
    public float calculateMontlyProfit(){
        return desiredProfitPerYear/12;
    }
    public float calculateYearlyProfit(){
        desiredProfitPerYear = (rentPerMonth-costPerMonth)*12;
        return desiredProfitPerYear; 
    }
    public final float calculateInvestmentAmount(){
        investmentAmount = askingPrice *downPaymentPercent/100;
        return investmentAmount;
    }
    public float calculateRoi(){
        roi = 12*(rentPerMonth -costPerMonth)/investmentAmount;
        return roi;
    }
    public float calculateYearlyInsurance(){
        insurancePerYear = askingPrice/1000f*5f;
        return insurancePerYear;
    }
    public float calculateRequiredSettlementMoney(){
        Calendar now = Calendar.getInstance();
        Calendar endOfYear = Calendar.getInstance();
        endOfYear.set(Calendar.MONTH, 12);
        endOfYear.set(Calendar.DAY_OF_MONTH,31);
        long daysRemainingInYear = TimeUnit.MILLISECONDS.toDays(Math.abs(endOfYear.getTimeInMillis()-now.getTimeInMillis()));
        settlementCashRequired =(investmentAmount)+earnestMoneyDeposit+((daysRemainingInYear-30)*taxPerYear/360); 
        return settlementCashRequired;
    }
    public float calculateHoa(FREQUENCY frequency){
        float monthly= 0.0f;
        float yearly=0.0f;
        float quarterly= 0.0f;
        switch(hoaFrequency){
            case MONTHLY:
                monthly = hoa;
                yearly = hoa*12;
                quarterly = hoa*3;
                break;
            case QUARTERLY:
                monthly = hoa/3;
                quarterly = hoa;
                yearly = hoa*4;
                break;
            case YEARLY:
                monthly = hoa/12;
                quarterly = hoa/4;
                yearly = hoa;
                break;
        }
        hoaFrequency = frequency;
        switch(frequency){
            case MONTHLY:
                hoa = monthly;
                break;
            case QUARTERLY:
                hoa = quarterly;
                break;
            case YEARLY:
                hoa = yearly;
                break;
        }
        return hoa;
    }
    
    private void calculateAll(){
        calculateYearlyInsurance();
        calculateMontlyCost();
        calculateMonthlRent();
        calculateMontlyProfit();
        calculateHoa(FREQUENCY.YEARLY);
        calculateRoi();
        calculateRequiredSettlementMoney();
    }

    @Override
    public String toString() {
        return "Property{" + "description=" + description + ", loan=" + loan + ", askingPrice=" + askingPrice + ", downPaymentPercent=" + downPaymentPercent + ", investmentAmount=" + investmentAmount + ", earnestMoneyDeposit=" + earnestMoneyDeposit + ", taxPerYear=" + taxPerYear + ", hoa=" + hoa + ", hoaFrequency=" + hoaFrequency + ", insurancePerYear=" + insurancePerYear + ", averageRepairCostsPerYear=" + averageRepairCostsPerYear + ", costPerMonth=" + costPerMonth + ", desiredProfitPerYear=" + desiredProfitPerYear + ", rentPerMonth=" + rentPerMonth + ", roi=" + roi + ", settlementCashRequired=" + settlementCashRequired + ", address=" + address + ", garage=" + garage + ", numOfBeds=" + numOfBeds + ", numOfBaths=" + numOfBaths + ", sqft=" + sqft + ", lotSize=" + lotSize + ", sufficientParking=" + sufficientParking + ", mlsNumber=" + mlsNumber + ", coop=" + coop + '}';
    }
    
    
      public static void main(String[] args) {
        SavingsFund fund = new SavingsFund(135000f);
        System.out.println("Property Info:\n");
        Property snowBird = new Property("2701 Snowbird",280000f, 35f, 2500f, 2049.40f, 2544, Property.FREQUENCY.YEARLY, 3500f);
        System.out.println(snowBird.toString());
        System.out.println("Savings Info:\n");
        System.out.println(fund.calculateRemainFunds(snowBird)+"");
        
        
    }
    
    
    
}
