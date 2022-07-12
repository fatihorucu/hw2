public class Unregistered extends Customer{
    final double points = 0;
    double valueOfBasket;
    public Unregistered(){};

    @Override
    public double transactionPromotion(Transaction transaction) {
        for (int i = 0; i < transaction.basket.size();i = i+2){
            valueOfBasket += ((Product)transaction.basket.get(i)).priceAfterPPromo() * ((Double)transaction.basket.get(i+1)).doubleValue();
        }
        return 0;
    }

    @Override
    public double accumulatePoints(Transaction transaction) {
        return 0;
    }
}
