public class Gold extends Customer {
    double pointAccRate = 0.03;
    double tPromoRate = 0.02;
    double valueOfBasket;
    double points;
    public Gold(String name){
        setcName(name);
    }
    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
    @Override
    public double transactionPromotion(Transaction transaction) {
        valueOfBasket = 0;
        for (int i = 0; i < transaction.basket.size();i = i+2){
            valueOfBasket += ((Product)transaction.basket.get(i)).priceAfterPPromo() * ((Double)transaction.basket.get(i+1)).doubleValue();
        }
        return valueOfBasket * tPromoRate;
    }

    @Override
    public double accumulatePoints(Transaction transaction) {
        valueOfBasket = transactionPromotion(transaction) / tPromoRate;
        return (valueOfBasket - transactionPromotion(transaction)) * pointAccRate;
    }

    public double getValueOfBasket() {
        return valueOfBasket;
    }
}
