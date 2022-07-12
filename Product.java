public class Product {
    private String pName;
    private double price;
    private boolean pType;
    private final double LUXURY_VAT = 0.18;
    private final double NORMAL_VAT = 0.08;
    private double pPromoRate;
    public Product(String pName, double price, boolean pType, double pPromoRate){
        setpName(pName);
        setPrice(price);
        setpType(pType);
        setpPromoRate(pPromoRate);
    }
    public double getPrice() {
        return price;
    }
    public double getLUXURY_VAT() {
        return LUXURY_VAT;
    }

    public double getNORMAL_VAT() {
        return NORMAL_VAT;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getpName() {
        return pName;
    }

    public void setpType(boolean pType) {
        this.pType = pType;
    }
    public boolean getpType(){
        return pType;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getpPromoRate() {
        return pPromoRate;
    }

    public void setpPromoRate(double pPromoRate) {
        this.pPromoRate = pPromoRate < 0 ? 0 : pPromoRate;
    }

    public String toString(){
        return String.format("Name: %s \n Price: %.2f \n Product Type Luxury? : %b \n Product Promotion: %.2f",pName,price,pType,pPromoRate);
    }
    public double priceWVAT(){
        if (pType)
            return price * (1 + LUXURY_VAT);
        else
            return price * (1 + NORMAL_VAT);
    }
    public double priceAfterPPromo(){
        return (1- pPromoRate) * priceWVAT();
    }
}
