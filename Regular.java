public class Regular extends Customer{
    double valueOfBasket;
    double pointAccRate = 0.05;
    int limitVForAcc = 50;
    int limitVForTrans = 40;
    double tPromoRate = 0.05;
    double points;
    public Regular(String name){
        setcName(name);
    }
    public void setLimitVForTrans(int limitVForTrans) {
        this.limitVForTrans = limitVForTrans;
    }
    public int getLimitVForTrans() {
        return limitVForTrans;
    }

    public double gettPromoRate() {
        return tPromoRate;
    }

    public void settPromoRate(double tPromoRate) {
        this.tPromoRate = tPromoRate;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public double transactionPromotion(Transaction transaction) {
        for (int i = 0; i < transaction.basket.size();i = i+2){
            valueOfBasket += ((Product)transaction.basket.get(i)).priceAfterPPromo() * ((Double)transaction.basket.get(i+1)).doubleValue();
        }
        if (valueOfBasket > limitVForTrans)
            return (valueOfBasket - limitVForTrans) * tPromoRate;
        else
            return 0;
    }

    @Override
    public double accumulatePoints(Transaction transaction) {
        valueOfBasket = (transactionPromotion(transaction) / tPromoRate) + limitVForTrans;
        if (valueOfBasket - transactionPromotion(transaction) > limitVForAcc )
            return (valueOfBasket - transactionPromotion(transaction) - limitVForAcc) * pointAccRate;
        else
            return 0;
    }
}
;