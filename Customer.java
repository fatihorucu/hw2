public abstract class Customer {
    protected String cName;
    public Customer(){}
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public abstract double transactionPromotion(Transaction transaction);
    public abstract double accumulatePoints(Transaction transaction);
}
