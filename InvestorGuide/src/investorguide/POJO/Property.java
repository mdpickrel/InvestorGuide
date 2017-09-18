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
public class Property {
    private String description;
    private Loan loan;
    private float askingPrice;
    private float downPaymentPercent;
    private float earnestMoneyDeposit;
    private float taxPerYear;
    private float hoa;
    private FREQUENCY hoaFrequency = FREQUENCY.MONTHLY;
    private float insurancePerYear;
    private float averageRepairCostsPerYear;
    private float costPerMonth;
    private float desiredProfitPerYear;
    private float rentPerMonth;
    private float roi;
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
    
    
    public float calculateMontlyCost(){
        return (taxPerYear+calculateHoa(FREQUENCY.YEARLY)+insurancePerYear+averageRepairCostsPerYear)/12+loan.getMontlyPayment(); 
    }
    
    public float calculateMonthlRent(){
        return 0.0f;//TODO: 
    }public float calculateMontlyProfit(){
        return 0.0f;//TODO: 
    }public float calculateYearlyProfit(){
        return 0.0f;//TODO: 
    }public float calculateRoi(){
        return 0.0f;//TODO: 
    }public float calculateYearlyInsurance(){
        return 0.0f;//TODO: 
    }public float calculateRequiredSettlementMoney(){
        return 0.0f;//TODO: 
    }public float calculateHoa(FREQUENCY frequency){
        return 0.0f;//TODO:
    }
    
    
    
    
    
}
