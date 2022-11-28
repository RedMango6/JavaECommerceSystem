//Name: Taha Iqbal
//Student ID: 501112475

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem
{
    private ArrayList<Product>  products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
    	
    	// Create some products. Notice how generateProductId() method is used
    	products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    	products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney"));
    	products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    	products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    	products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    	products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast"));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive"));
    	products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney"));
    	products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));

        //Adding Shoe products.
        int[] jordanBrownCounts= {50,50,50,50,50};
        int[] jordanBlackCounts= {50,50,50,50,50};
        products.add(new Shoe("Jordans", generateProductId(), 200.0, jordanBrownCounts, jordanBlackCounts));
    	
    	// Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    }
    
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public String getErrorMessage()
    {
    	return errMsg;
    }
    
    public void printAllProducts() //WORKS
    {
        //Going through the products using a for-each loop and extracting each element into Product p.
    	for (Product p : products) {

            p.print(); //Calling print() method of the product class

        }
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {

        //Going through the products using a for-each loop and extracting each element into Product p.
        for (Product p : products){

            if (p.getCategory()== Product.Category.BOOKS){ //Checking if the product is a book.

                p.print(); //Calling print() method of the Product class

            }
        }
    	
    }
    
    // Print all current orders
    public void printAllOrders()
    {
        //Going through the orders using a for-each loop and extracting each element into ProductOrder o.
        for (ProductOrder o: orders){

            o.print(); //Calling print() method of the ProductOrder class
        }

    	
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
        for (ProductOrder o: shippedOrders){ //Going through the shippedOrders using a for-each loop and extracting each element into ProductOrder o.

            o.print(); //Calling print() method of the ProductOrder class
        }
    	
    }
    
    // Print all customers
    public void printCustomers()
    {
        for (Customer c: customers){ //Going through the customers using a for-each loop and extracting each element into Customer c.

            c.print(); //Calling print() method of the Customer class

        }
    	
    }
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public boolean printOrderHistory(String customerId)
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	// ... code here


        int customerIndex=0;  //If we find the customer using the customerId, we will record its index
        boolean customerExistence=false; // boolean for customer-existence verification

        for (int i=0; i<customers.size(); i+=1){ //Going through the customers-arraylist with an unadvanced for loop

            if (customers.get(i).getId().equals(customerId)){ //checking if the id of each customer is equal to customerId

                // if the customer-id's match, then we have verified the existence of the customer and we have found the location of
                // that customer in the customers-arraylist.
                customerIndex=i;
                customerExistence=true;
                break;

            }

        }

        if (!customerExistence){
            this.errMsg="Customer "+customerId+" Not Found"; //setting errMsg to the appropriate value incase it does not exist.
            return false;
        }


    	// Print current orders of this customer


    	System.out.println("Current Orders of Customer " + customerId);

    	// enter code here


        for (int i=0; i<orders.size(); i+=1){   //going through the arraylist of current orders

            if (orders.get(i).getCustomer().getId().equals(customerId)){  //checking if the id of the customer of that order is equal to customerId.

                orders.get(i).print(); //print order if the id of the customer of the order at position i is equal to customerId.
            }

        }
    	
    	// Print shipped orders of this customer

    	System.out.println("\nShipped Orders of Customer " + customerId);

    	//enter code here


        for (int i=0; i<shippedOrders.size(); i+=1){ //going through the arraylist of shipped orders

            if (shippedOrders.get(i).getCustomer().getId().equals(customerId)){  //checking if the id of the customer of that shipped-order is equal to customerId.

                shippedOrders.get(i).print(); //print order if the id of the customer of the order is equal to customerId.
            }

        }
    	
    	return true; //returning true after the customer's existence was verified and the customer's history was printed
    }
    
    public String orderProduct(String productId, String customerId, String productOptions)
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object


        int customerIndex=0; //If we find the customer using the customerId, we will record its index

        boolean customerExistence=false; // boolean for customer-existence verification

        for (int i=0; i<customers.size(); i+=1){ //Going through the customers-arraylist with an unadvanced for loop

            if (customers.get(i).getId().equals(customerId)){ //checking if the id of each customer is equal to customerId

                // if the customer-id's match, then we have verified the existence of the customer and we have found the location of
                //that customer in the customers-arraylist.
                customerIndex=i;
                customerExistence=true;
                break;

            }
        }
        if (!customerExistence){

            this.errMsg="Customer "+customerId+" Not Found"; //setting errMsg to the appropriate value incase the customer does not exist.
            return null;

        }

    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object


        int productIndex=0;  //If we find the product using the productId, we will record its index.
        boolean productExistence=false;   // boolean for product-existence verification


        for (int i=0; i<products.size(); i+=1){ //Going through the products-arraylist with an unadvanced for loop

            if (products.get(i).getId().equals(productId)){ //checking if the id of each product is equal to productId

                // if the product-id's match, then we have verified the existence of the product and we have found the location of
                //that product in the products-arraylist.

                productIndex=i;
                productExistence=true;
                break;
            }
        }
        if (!productExistence){
            this.errMsg= "Product "+ productId+" Not Found"; //setting errMsg to the appropriate value incase the product does not exist.
            return null;
        }


        // Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method validOptions()
    	// If options are not valid, set errMsg string and return null;



        if (!(products.get(productIndex).validOptions(productOptions))){ //checking if the options are valid for the product using
            // the validOptions() method in the Products class and the Books class.

            if (products.get(productIndex).getCategory()== Product.Category.BOOKS){
                this.errMsg="Product Book ProductId "+productId+" Invalid Options: "+productOptions;
            } else if (products.get(productIndex).getCategory()== Product.Category.CLOTHING){
                this.errMsg="Product Shoe ProductId "+productId+" Invalid Options: "+productOptions;
            }

            return null;
        }
    	
    	// Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null

        if (products.get(productIndex).getStockCount(productOptions)==0){ //Checking if the stock of the product is 0 using the getStockCount method.
            this.errMsg="Product #"+productId+" has no "+productOptions+" stock left.";
            return null;
        }
    	
      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string

        //In the following line, we create the product order and assighn its reference to the productOrderNew variable.
        ProductOrder newProductOrder= new ProductOrder(generateOrderNumber(), products.get(productIndex), customers.get(customerIndex), productOptions); //done

        //In this next line, we reduce the appropriate type of stock of the product using the productOptions variable.
        products.get(productIndex).reduceStockCount(productOptions);

        //In this next line, we add the new order to the orders arrayList using the newProductOrder reference variable
        orders.add(newProductOrder);

    	return newProductOrder.getOrderNumber();  //returning the orderNumber
    }
    
    /*
     * Create a new Customer object and add it to the list of customers.
     */
    
    public boolean createCustomer(String name, String address)
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter

        if (name==null || name.equals("")){ //Checking name parameter to make sure it is not null or ""

            this.errMsg="Invalid Customer Name"; //assighning proper error message for the getErrorMessage() call in ECommerceUserInterface
            return false;
        }


        if (address==null || address.equals("")){ //Checking address parameter to make sure it is not null or ""

            this.errMsg= "Invalid Customer Address"; //assighning proper error message for the getErrorMessage() call in ECommerceUserInterface
            return false;
        }


    	// Create a Customer object and add to array list

        customers.add(new Customer(generateCustomerId(), name, address));

    	return true;
    }
    
    public ProductOrder shipOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video)
    	// and return null

        int orderIndex=0; //variable to store index position of the order if it exists
        boolean orderExistence=false;  //boolean to verify order-existence


        for (int i=0; i<orders.size(); i+=1){ //going through the orders arraylist (which stores the current orders)

            if (orders.get(i).getOrderNumber().equals(orderNumber)){ //checking if the order at position i has the same orderNumber value as
                // the orderNumber parameter

                orderIndex=i;
                orderExistence=true;
                break;

            }
        }

        if (!orderExistence){
            this.errMsg= "Order "+orderNumber+" Not Found"; //setting error message to appropriate value if the order does not exist in the orders arraylist.
            return null;
        }


    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order

        ProductOrder returnOrder= orders.get(orderIndex);// storing the order that matches the orderNumber parameter in
        // the returnOrder reference variable.

        //The following two lines are the "shipping" action

        orders.remove(orderIndex); //removing the order from order arraylist (which stores the current/unshipped orders)
        shippedOrders.add(returnOrder); //adding the reference in returnOrder to shippedOrders.


    	return returnOrder; //returning a reference to the actual order.
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public boolean cancelOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false

        int orderIndex=0; //variable to store index position of the order if it exists
        boolean orderExistence=false; //boolean to verify order-existence


        for (int i=0; i<orders.size(); i+=1){ //going through the orders arraylist (which stores the current orders)

            if (orders.get(i).getOrderNumber().equals(orderNumber)){ //checking if the order at position i has the same orderNumber value as
                    // the orderNumber parameter
                orderIndex=i;
                orderExistence=true;
                break;

            }
        }

        if (!orderExistence){
            this.errMsg="Order "+ orderNumber+" Not Found";  //setting error message to appropriate value if the order does not exist in the orders arraylist.
            return false;
        }

        //In the next line, we obtain the reference of the product of the order that is about to be cancelled.
        Product cancelledProduct= orders.get(orderIndex).getProduct();

        //In this next line, we store the productOptions of the order that is about to be cancelled.
        String cancelledOrderOptions= orders.get(orderIndex).getProductOptions();

        //get present stockCount of the product that corresponds with productOptions
        int cancelledProductCount = orders.get(orderIndex).getProduct().getStockCount(cancelledOrderOptions);

        //increase stockcount of the product by 1.
        cancelledProduct.setStockCount(cancelledProductCount+1, cancelledOrderOptions);


        orders.remove(orderIndex); //removing the order from the order arraylist (which stores all current orders)
        return true;


    }
    
    // Sort products by increasing price
    public void sortByPrice()
    {
        //
        Comparator<Product> productCom= new Comparator<Product>() {  //Here we are creating the comparator so we can
            //specify logic for the Collections.sort() method.

            @Override
            public int compare(Product o1, Product o2) {

                //if (price of the earlier one is greater than the price of the later one) {switch}
                if (o1.getPrice()>o2.getPrice()){

                    return 1;

                    //else if (price of the earlier one is equal to the price of the later one) {don't switch}
                } else if (o1.getPrice()==o2.getPrice()){

                    return 0;

                    //else if (price of the earlier one is lass than the price of the later one) {don't switch}
                } else{

                    return -1;
                }
            }
        };
        Collections.sort(products, productCom); //sorting products using the productCom comparator
  	  
    }
    
    
    // Sort products alphabetically by product name
    public void sortByName()
    {
        Comparator<Product> productNameCom= new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {

                //if (ASCII of first value of first name > ASCII of first value of second name){ switch values}
                if ((int)o1.getName().charAt(0) > (int)o2.getName().charAt(0)){

                    return 1;

                    //if (ASCII of first value of first name == ASCII of first value of second name){ don't switch values}
                } else if ((int)o1.getName().charAt(0) == (int)o2.getName().charAt(0)){

                    return 0;

                    //if (ASCII of first value of first name < ASCII of first value of second name){ don't switch values}
                } else{
                    return -1;
                }
            }
        };
        Collections.sort(products, productNameCom);
  	  
    }
    
        
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
        Collections.sort(customers); //using Comparable interface (that is implemented by Customer class).
  	  
    }

    public boolean printBooksByAuthor(String author){ // for BOOKSBYAUTHOR not complete

        /*

        ArrayList<Product>  books = new ArrayList<Product>();
        for (int i=0; i<products.size(); i+=1){
            if (products.get(i).getCategory()== Product.Category.BOOKS) {
                books.add(products.get(i));
            }
        }


        int authorIndex=0;  //If we find the customer using the customerId, we will record its index
        boolean authorExistence=false; // boolean for customer-existence verification

        for (int i=0; i<books.size(); i+=1){ //Going through the customers-arraylist with an unadvanced for loop

            if (customers.get(i).getId().equals(customerId)){ //checking if the id of each customer is equal to customerId

                // if the customer-id's match, then we have verified the existence of the customer and we have found the location of
                // that customer in the customers-arraylist.
                customerIndex=i;
                customerExistence=true;
                break;

            }

        }

        if (!customerExistence){
            this.errMsg="Customer "+customerId+" Not Found"; //setting errMsg to the appropriate value incase it does not exist.
            return false;
        }



        */
        return true;
    }
}
