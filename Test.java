import java.util.ArrayList;

public class Test {
    public static String clcTotalRevenue(ArrayList<Transaction> transactionArray){
        double totalValue = 0;
        for (Transaction transaction : transactionArray)
            totalValue += transaction.invoice();
        return String.format("Total revenue is: %.2f",totalValue);
    }
    public static String clcTotalDiscounts(ArrayList<Transaction> transactionArray){
        double totalDiscounts = 0;
        for (Transaction transaction : transactionArray){
            totalDiscounts += transaction.totalProductPromotions();
            totalDiscounts += transaction.getCustomerMadeTransaction().transactionPromotion(transaction);
        }
        return String.format("Total discount made is: %.2f", totalDiscounts);
    }
    public static void main(String[] args) {
        Product p1 = new Product("p1",20,true,0.06);
        Product p2 = new Product("p2",15,false,0.15);
        Product p3 = new Product("p3",12,false,0.25);
        Product p4 = new Product("p4",20,true,0.12);
        Product p5 = new Product("p5",18,false,0);
        Product p6 = new Product("p6",10,true,0.10);
        ArrayList productArray = new ArrayList();
        productArray.add(p1);
        productArray.add(p2);
        productArray.add(p3);
        productArray.add(p4);
        productArray.add(p5);
        productArray.add(p6);
        Gold c1 = new Gold("c1");
        Gold c2 = new Gold("c2");
        Regular c3 = new Regular("c3");
        Regular c4 = new Regular("c4");
        ArrayList customerArray = new ArrayList();
        customerArray.add(c1);
        customerArray.add(c2);
        customerArray.add(c3);
        customerArray.add(c4);
        Transaction tG = new Transaction(c1);
        Transaction tR = new Transaction(c3);
        Transaction tU = new Transaction();
        ArrayList<Transaction> transactionArray = new ArrayList<Transaction>();
        tG.addToBasket(p1,3.8);
        tG.addToBasket(p3,20.0);
        tG.addToBasket(p4,1.3);
        tR.addToBasket(p2,3);
        tR.addToBasket(p6,4.1);
        tR.addToBasket(p5,1.7);
        tU.addToBasket(p4,2);
        tU.addToBasket(p2,6);
        tU.addToBasket(p1,20);
        transactionArray.add(tG);
        transactionArray.add(tR);
        transactionArray.add(tU);
        System.out.printf("\n %s\n ",clcTotalRevenue(transactionArray));
        System.out.printf("%s",clcTotalDiscounts(transactionArray));
    }
}
