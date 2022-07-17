# hw2
OOP used project
Develop the java program for transactions of a retail company.

A retail company sells different products such as food, electronic equipments, and beverages. These products are sold to different types of customers of the company with different promotions. There are product specific promotions or transaction specific ones. Transaction promotions depend on customer type. Customers gain points depending on the total value of transaction after all discounts are deduced. How to accumulate points also depend on customer type. Registered customers can use some of their points for payment or added to total points of the customer

For some transactions there may not be a registered customer at all in that case only product promotions are applied which are independent of customer type or even when there is no registered customer associated with the transaction.

Develop a Java program to calculate total payment of a customer when a transaction is completed. Managers also use this program to monitor total revenue and discounts from different promotion or customer types.

Use polymorphism and software reusability as much as possible Here are the class descriptions. Add any other relevant variable or method as required. Write constructors, get, set, display and any other methods as needed.

Create the Product class holding name, price and type of the product.
All products have value added tax rate. Some products are luxury in that they are subject to a higher value added tax than ordinary products.  Do not develop different product classes for normal or luxury  products but indicate by a boolean variable in the product class whether  the product is luxury or normal. Value added tax rates for normal and luxury products are not product specific. There is only one value added tax rate applied to normal products and one for luxury products. Define these rates properly in the Product class.

Create the abstract Customer class holding name of the customer.
Create two concrete customer classes as Regular and Gold Both types of customers benefit from product specific promotions via the same procedure but transaction promotions depends of customer  type. Golds benefit from transaction specific promotions with higher promotion rates than regulars. These promotion rates are not customer specific and defined in the appropriate customer classes in a proper way as will be explained later.

Each type of customer gets points as they make purchases fro m the store. The point accumulation rates of these type of customers are different (depends on customer type only – class specific). Develop proper customer classes as the subclasses of the abstract Customer class.

Promotions are calculated after value added tax is added to the products’ base price. promotions are calculated then deduced from payments. Points gained by customers are calculated based on net value of the transaction after deducing all discounts. Optionally registered customers can use some of their points in payment of the current transaction. 

There are two broad promotion types as mentioned above; product specific or transaction promotions.

Product specific promotions are associated with Products.  So Product class should have a productPromotion variable which is a percentage value set by a proper method if the products sold with a promotion. x% discount is applied on price plus VAT. For each product the %x value may be different even can be changed during the course of the program in the test class.

Example:  Suppose product apple (a normal product) is decided to be promoted, set the promotion variable  to a percentage value, say 0.15, price of apple is 20, VAT for normal products: 10%  a transaction contains 2 kg of aapple. 
Total amount = 2*(20+20*0.1)*(1-0.15) = 44 – 6.6 = 37.4 

The transaction promotions are calculated after the product promotions are calculated and subtracted from the value of transactions. 

Example suppose in a transaction the customer adds 2 kg apples and 3 kg pairs to her basket.
Apple price is 20, pair price is 30 suppose apple is normal and pair is luxury.  Normal VAT is 0.1 luxury VAT is 0.2. Apples are sold with product promotion rate of 0.15, pairs are sold with promotion rate of 0.05. What is the amount of money the customer would pay for this transaction? (value of the transaction after product promotions are calculated and subtracted from the gross valued of transaction)
value after product promotions  = 2*((20*1.1.*(1-0.15) (for 2 kg of apples)
                                                             +3*30*1.2*(1-0.05) (for 3 kg of pairs)
                                                             = 44*0.85 + 108*0.95
Value of transaction = 44 – 6.6 + 108 – 5.4 =  140

Transaction promotions for gold customers:.z percent of the total value of the transaction based on original prices plus value added tax and subtracting product promotions.
In the previous example if the customer is a gold one and z value is 0.02
value of transaction after  product promotions is 140 TL and z% is 2 , the customer has a transaction promotion of 2.8 (140*0.02) and total value of the transaction is : 140-2.8 = 137.2

For regular customers: if the transaction value exceeds a  limit value (which is applicable to all regular customers) for each TL exceeding this limit the discount is zR%. 
Ex: if limit is 40 and zR is 0.05 and value of the transaction (after product promotions) is 140, discount due to transaction promotion for a regular customer is (140-40)* 0.05 = 5 TL

Note on implementations: declare a transactionPromotion method in the abstract Customer class. Implement in each subclass. This method takes the value of transaction after product promotions and return discout from transaction promotion. Define the limit parameters, zR and z paamters in relevant customer classes.

Gaining points:
For gold customer zP% of the net transaction value after subtracting transaction discounts is accumulated as points.. For regular customers if final value  of transaction  exceeds a PointLimit PLR, %zPR percent is accumulated as points.

Example: for gold customers if zP value is 0.03 3% of the net value of a transaction is added to the points
In previous example:  net value was 137.2, so the gold customer gains new 1.375*3 points.
If point limit is 100 and %2 PR = 0.02, the regular customer’s gains: (135 - 100)*0.02 = 2 points.

Implementation: implement the gainPoint methods similar to transactionPromotion methods: define in each concrete customer class taking the net value of transaction after all promotions and calculating and adding total points of each customer.

The Transaction class: Each transaction is associated optionally with a registered customer, some has no registered customers. Products purchased are hold in an ArrayList of Product  amount pairs, a Product object is followed by an Integer or Double object representing number of amout of that product added to the basket. 
Write an add method to add a product amount pair to the end of the ArrayList. There is a cancel method as well. This method takes a product object to be canceled and an amount variable as parameters finds the product  object in the ArrayList and either deletes the Product, amount pair from the list or adjust the amount variable if still some amount of the product is purchased (in the preovous example, if 1 kg of pair is canceled there is still 2 kg of pars in the basket)

The traction class has a customer variable in case the buyer is one of the registered types of customers (regular or gold otherwise remains as null). 

The Invoice method of the Transaction class calculates and returns the total payment of the tramsaction. (Including value added tax and all discounts), discount made to this customer from this transaction (discounts from both product promotions and transaction promotions). Update the points of the customer a registerd is customer associated. Present all to the screen and ask the customer how much of her accumulated points to use. Based on the input entered, calculate and present the total payment and updates the total points if customer uses some in the payment. 

In the test class, create 6  products (insert into an ArrayList), some are normal and the rest are luxury porudcts. Some of these product are sold with product promotions. Create two regular and two gold customer. (store the customers of the company into another ArrayList as well). 

Create a set of transactions. Let these customers purchase some products. Associate some of these transactions with either type of customers even some transactions should have no customers at all.. Calculate and print invoices of these transactions. Store each transaction into an ArrayList as well. 

In the test class there should be three ArrayLists as: customers, products and transactions. 
Traversing over these lists management of the store should learn total revenue, total discounts make in transactions including product and transaction promotions, 
Each customer can be quaried for her total points as well. The management should be able to change product promotions as well as parameters of transaction promotions for Gold and Regular customers, may change the point accumulation parameters of the two types of customers as well. 

