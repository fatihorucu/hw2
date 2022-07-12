import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {
    public Transaction(){
        this.customerMadeTransaction = new Unregistered();
    };
    public Transaction(Customer customerMadeTransaction){
        this.customerMadeTransaction = customerMadeTransaction;
    }
    private Customer customerMadeTransaction;
    ArrayList basket = new ArrayList();
    double valueOfBasket;
    double totalProductPromotion;
    public void addToBasket(Product product, double amount){
        basket.add(product);
        basket.add(amount);
    }
    public void deleteFromBasket(Product productToChange, Double amountToDelete){
        int i = basket.indexOf(productToChange);
        if (amountToDelete < (Double) basket.get(i+1)){
            basket.set(i+1,(Double) basket.get(i+1)- amountToDelete);
        }
        else{
            basket.remove(i);
            basket.remove(i);
        }
    }
    public double totalProductPromotions(){
        for (int i = 0; i < basket.size(); i = i+2){
            totalProductPromotion += ((Product)basket.get(i)).priceWVAT() * ((Product)basket.get(i)).getpPromoRate();
        }
        return totalProductPromotion;
    }
    public double invoice(){
        if (customerMadeTransaction instanceof Gold){
            for (int i = 0; i < basket.size(); i = i+2){
                valueOfBasket += ((Product)basket.get(i)).priceWVAT() * ((Double)basket.get(i+1)).doubleValue();
            }
            System.out.printf("\n\nYour basket costs $%.2f. \nTotal product promotions: $%.2f \nTotal transaction promotion: $%.2f \nYour total Points: %.2f \n",valueOfBasket,totalProductPromotions(),customerMadeTransaction.transactionPromotion(this),((Gold) customerMadeTransaction).points);
            Scanner input = new Scanner(System.in);
            String answer;
            double valueToPay = 0;
            boolean loop;
            do {
                loop = false;
                System.out.println("Do you want to use some points? y or n");
                answer = input.next();
                char control = answer.charAt(0);

                if (control == 'y' ||control == 'Y' ) {
                    System.out.println("How much of points do you want to use?");
                    double pointsToUse = input.nextDouble();
                    while (pointsToUse > ((Gold) customerMadeTransaction).points){
                        System.out.println("Not enough points, please try again.");
                        pointsToUse = input.nextDouble();
                    }
                    valueToPay = ((Gold) customerMadeTransaction).valueOfBasket * (1- ((Gold) customerMadeTransaction).tPromoRate)- pointsToUse;
                    ((Gold) customerMadeTransaction).points -= pointsToUse;
                    System.out.printf("You are going to pay: $%.2f", valueToPay);
                }
                else if (control == 'N'|| control == 'n'){
                    valueToPay = ((Gold) customerMadeTransaction).valueOfBasket * (1- ((Gold) customerMadeTransaction).tPromoRate);
                    System.out.printf("You are going to pay: $%.2f", valueToPay);
                }
                else loop = true;
            } while (loop == true);
            ((Gold) customerMadeTransaction).points += customerMadeTransaction.accumulatePoints(this);
            return valueToPay;
        }
        else if (customerMadeTransaction instanceof Regular){
            for (int i = 0; i < basket.size(); i = i+2){
                valueOfBasket += ((Product)basket.get(i)).priceWVAT() * ((Double)basket.get(i+1)).doubleValue();
            }
            System.out.printf("\n\nYour basket costs $%.2f. \nTotal product promotions: $%.2f \nTotal transaction promotion: $%.2f \nYour total Points: %.2f \n",valueOfBasket,totalProductPromotions(),customerMadeTransaction.transactionPromotion(this),((Regular) customerMadeTransaction).points);
            Scanner input = new Scanner(System.in);
            String answer;
            double valueToPay = 0;
            boolean loop;
            do {
                loop = false;
                System.out.println("Do you want to use some points? y or n");
                answer = input.next();
                char control = answer.charAt(0);

                if (control == 'y' ||control == 'Y' ) {
                    System.out.println("How much of points do you want to use?");
                    double pointsToUse = input.nextDouble();
                    while (pointsToUse > ((Regular) customerMadeTransaction).points){
                        System.out.println("Not enough points, please try again.");
                        pointsToUse = input.nextDouble();
                    }
                    valueToPay = ((Regular) customerMadeTransaction).valueOfBasket * (1- ((Regular) customerMadeTransaction).tPromoRate)- pointsToUse;
                    ((Regular) customerMadeTransaction).points -= pointsToUse;
                    System.out.printf("You are going to pay: $%.2f", valueToPay);

                }
                else if (control == 'N'|| control == 'n'){
                    valueToPay = ((Regular) customerMadeTransaction).valueOfBasket * (1- ((Regular) customerMadeTransaction).tPromoRate);
                    System.out.printf("You are going to pay: $%.2f", valueToPay);
                }
                else {
                    System.out.println("Invalid input, try again.");
                    loop = true;
                }
            } while (loop);
            ((Regular) customerMadeTransaction).points +=customerMadeTransaction.accumulatePoints(this);
            return valueToPay;
        }
        else {
            for (int i = 0; i < basket.size(); i = i+2){
                valueOfBasket += ((Product)basket.get(i)).priceWVAT() * ((Double)basket.get(i+1)).doubleValue();
            }
            System.out.printf("\n\nYour basket costs $%.2f. \nTotal product promotions: $%.2f \nTotal transaction promotion: $%.2f \nYour total Points: %.2f \n",valueOfBasket,totalProductPromotions(),((Unregistered)customerMadeTransaction).transactionPromotion(this),((Unregistered) customerMadeTransaction).points);
            double valueToPay = 0;
            valueToPay = ((Unregistered) customerMadeTransaction).valueOfBasket * (1- ((Unregistered) customerMadeTransaction).transactionPromotion(this));
            System.out.printf("You are going to pay: $%.2f", valueToPay);
            return valueToPay;
        }
    }
    public Customer getCustomerMadeTransaction() {
        return customerMadeTransaction;
    }
}
