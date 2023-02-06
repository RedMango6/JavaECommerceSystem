
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem {
  private ArrayList<Product> products = new ArrayList<Product>();
  private ArrayList<Customer> customers = new ArrayList<Customer>();

  private ArrayList<ProductOrder> orders = new ArrayList<ProductOrder>();
  private ArrayList<ProductOrder> shippedOrders = new ArrayList<ProductOrder>();

  // These variables are used to generate order numbers, customer id's, product
  // id's
  private int orderNumber = 1;
  private int customerId = 1;
  private int productId = 1;

  // General variable used to store an error message when something is invalid
  // (e.g. customer id does not exist)
  String errMsg = null;

  // Random number generator
  Random random = new Random();

  public ECommerceSystem() {
    // NOTE: do not modify or add to these objects!! - the TAs will use for testing
    // If you do the class Shoes bonus, you may add shoe products

    // Create some products. Notice how generateProductId() method is used
    products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney", 2022));
    products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast", 2021));
    products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive", 2001));
    products.add(
        new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney", 1990));
    products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));
    // Random year values have been added to all book objects for booksbyauthor
    // bonus method
    // Create some customers. Notice how generateCustomerId() method is used
    customers.add(new Customer(generateCustomerId(), "Inigo Montoya", "1 SwordMaker Lane, Florin"));
    customers.add(new Customer(generateCustomerId(), "Prince Humperdinck", "The Castle, Florin"));
    customers.add(new Customer(generateCustomerId(), "Andy Dufresne", "Shawshank Prison, Maine"));
    customers.add(new Customer(generateCustomerId(), "Ferris Bueller", "4160 Country Club Drive, Long Beach"));
  }

  private String generateOrderNumber() {
    return "" + orderNumber++;
  }

  private String generateCustomerId() {
    return "" + customerId++;
  }

  private String generateProductId() {
    return "" + productId++;
  }

  public String getErrorMessage() {
    return errMsg;
  }

  public void printAllProducts() {
    for (Product p : products)
      p.print();
  }

  // Print all products that are books. See getCategory() method in class Product
  public void printAllBooks() {
    for (Product p : products)
      if (p.getCategory() == Product.Category.BOOKS) {
        p.print();
        // going through all the products and checking if a product is a book and
        // printing only those which are books
      }
  }

  // Print all current orders
  public void printAllOrders() {
    for (ProductOrder po : orders)
      po.print();
    // self explanatory - all orders in the order arraylist are being printed
  }

  // Print all shipped orders
  public void printAllShippedOrders() {
    for (ProductOrder pos : shippedOrders)
      pos.print();
    // self explanatory - all shipped orders in the shippedorders arraylist are
    // being printed
  }

  // Print all customers
  public void printCustomers() {
    for (Customer c : customers) {
      c.print();
      // self explanatory - all customers are being printed from the customers
      // arraylist where they all are stored
    }
  }

  /*
   * Given a customer id, print all the current orders and shipped orders for them
   * (if any)
   */
  public boolean printOrderHistory(String customerId) {
    // Make sure customer exists - check using customerId
    // If customer does not exist, set errMsg String and return false
    // see video for an appropriate error message string
    // ... code here
    boolean customerExists = false;// this will be used to check below if a customer exists
    for (int i = 0; i < customers.size(); i++) {
      if (customers.get(i).getId().equals(customerId)) {
        customerExists = true;
      }
    } // entire for loop is used to check if the customerId matches a valid customer
      // in the customer arraylist
    if (customerExists == false) {
      System.out.println("Customer #" + customerId + " Not Found");
      return false;
      // if a customer does not exist then the system tells the user that the customer
      // entered is not valid and the functions
      // returns false and exits
    } // if a customer does exist the code carries on this is just a check
      // Print current orders of this customer
    System.out.println("Current Orders of Customer " + customerId);
    // enter code here
    if (customerExists == true) {
      for (int i = 0; i < orders.size(); i++) {
        if (orders.get(i).getCustomer().getId().equals(customerId)) {
          orders.get(i).print();
        }
      }
    } // printing the current orders of the customer
      // Print shipped orders of this customer
    System.out.println("\n\nShipped Orders of Customer " + customerId);
    // enter code here
    if (customerExists == true) {
      for (int i = 0; i < shippedOrders.size(); i++) {
        if (shippedOrders.get(i).getCustomer().getId().equals(customerId)) {
          shippedOrders.get(i).print();
        }
      }
    }
    return true;
    // printing the shipped orders of the customer and returning true indicating the
    // customer exists
  }

  public String orderProduct(String productId, String customerId, String productOptions) {
    // First check to see if customer object with customerId exists in array list
    // customers
    // if it does not, set errMsg and return null (see video for appropriate error
    // message string)
    // else get the Customer object
    Customer c = customers.get(0);// initializing a customer c to the first customer initially, this will be
                                  // changed later
    // this is just set to the first customer to initialize the variable c
    boolean customerExists = false;
    for (int i = 0; i < customers.size(); i++) {
      if (customers.get(i).getId().equals(customerId)) {
        customerExists = true;
        c = customers.get(i);
        // checking if customer exists and getting the customer and storing in variable
        // c
      }
      if (i == customers.size() - 1 && customerExists == false) {
        System.out.println("Customer " + customerId + " Not Found");
        return null;
        // if the customer has not been found in the arraylist's last element then the
        // customerid is wrong and the user is notified
      }
    }
    // Check to see if product object with productId exists in array list of
    // products
    // if it does not, set errMsg and return null (see video for appropriate error
    // message string)
    // else get the Product object
    boolean productExists = false;
    boolean isItBook = false;
    Product p = products.get(0);
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getId().equals(productId)) {
        productExists = true;
        p = products.get(i);
        if (p.getCategory() == Product.Category.BOOKS) {
          isItBook = true;
        }
      } // here we basically check if the productid exists (is valid) and if the product
        // is a book
      if (i == products.size() - 1 && productExists == false) {
        System.out.println("Product " + productId + " Not Found");
        return null;
        // if the product does not exist the user is notified accordingly
      }
    }
    // Check if the options are valid for this product (e.g. Paperback or Hardcover
    // or EBook for Book product)
    // See class Product and class Book for the method vaidOptions()
    // If options are not valid, set errMsg string and return null;
    // Book b = (Book) p;
    if (p.getCategory() == Product.Category.BOOKS) {
      // b = (Book) p;
      if (p.validOptions(productOptions) == false) {
        System.out.println("Product Book ProductID " + productId + " Invalid Options: " + productOptions);
        return null;
        // this if checks if the productId is that of a book but an invalid
        // productoptions has been entered
        // this is also used to check if a book product id is being entered in order
      }
    }
    if (p.getCategory() != Product.Category.BOOKS && productOptions.isBlank() == false
        && productOptions.isEmpty() == false) {
      System.out.println("Product #" + productId + " Is Not A Book");
      return null;
      // checks if a product (other than a book) has been entered (used by orderbook)
    }
    // Check if the product has stock available (i.e. not 0)
    // See class Product and class Book for the method getStockCount()
    // If no stock available, set errMsg string and return null
    // System.out.println(productOptions);
    // System.out.println(p.getStockCount(productOptions));
    if (p.getStockCount(productOptions) <= 0) {
      System.out.println("The Product #" + productId + " Is Out Of Stock");
      return null;
      // checks if the stock of the product is <=0. if so the user is informed
    }
    // Create a ProductOrder, (make use of generateOrderNumber() method above)
    // if (isItBook == false && ) {
    // System.out.println("This Product #" + productId + " Is Not A Book");
    // return null;
    // }
    ProductOrder po;
    ProductOrder bo;
    if (p.getCategory() == Product.Category.BOOKS) {
      bo = new ProductOrder(generateOrderNumber(), p, c, productOptions);
      orders.add(bo);
      p.reduceStockCount(productOptions);
      // System.out.println(p.getStockCount(productOptions)); -> used for testing
      return bo.getOrderNumber();
    } else {
      po = new ProductOrder(generateOrderNumber(), p, c, productOptions);
      orders.add(po);
      p.reduceStockCount("");
      // System.out.println(p.getStockCount("")); -> used for testing
      return po.getOrderNumber();
    }
    // the comments below are done above in 1 go
    // reduce stock count of product by 1 (see class Product and class Book)
    // Add to orders list and return order number string
    // replace this line
  }

  /*
   * Create a new Customer object and add it to the list of customers
   */

  public boolean createCustomer(String name, String address) {
    // Check name parameter to make sure it is not null or ""
    // If it is not a valid name, set errMsg (see video) and return false
    // Repeat this check for address parameter
    if (name == null || name.isBlank()) {// checking if the user enters an invalid name
      System.out.println("Invalid Customer Name");
    } else if (address == null || address.isBlank()) {// checking if the user enters an invalid address
      System.out.println("Invalid Customer Address");
    } else {
      // Create a Customer object and add to array list
      Customer c = new Customer(generateCustomerId(), name, address);
      customers.add(c);
      // if the address and name are both valid a new customer object is created and
      // added to the customer arraylist
    }
    return true;
  }

  public ProductOrder shipOrder(String orderNumber) {
    // Check if order number exists first. If it doesn't, set errMsg to a message
    // (see video)
    // and return false
    // Retrieve the order from the orders array list, remove it, then add it to the
    // shippedOrders array list
    // return a reference to the order
    boolean orderFound = false;// used to check later if the orderNumber parameter is valid
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getOrderNumber().equals(orderNumber)) {
        orderFound = true;
        ProductOrder order = orders.get(i);
        shippedOrders.add(orders.get(i));
        orders.remove(i);
        order.print();
        return order;
      }
    }
    if (orderFound == false) {
      System.out.println("Order " + orderNumber + " Not Found");
    }
    return null;
  }

  /*
   * Cancel a specific order based on order number
   */
  public boolean cancelOrder(String orderNumber) {
    // Check if order number exists first. If it doesn't, set errMsg to a message
    // (see video)
    // and return false
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getOrderNumber().equals(orderNumber)) {
        orders.remove(i);
        return true;
        // checking the orders arraylist to see if an orderNumber matches the parameter
        // orderNumber and if so removing it from the list
      }
    }
    System.out.println("Order " + orderNumber + " Not Found");
    return false;
  }

  // Sort products by increasing price
  public void sortByPrice() {
    Collections.sort(products);
    // using the list's sort method, the comparable is implemented in product class
  }

  // Sort products alphabetically by product name
  public void sortByName() {
    // using bubble sort
    for (int i = 0; i < products.size(); i++) {
      for (int j = 0; j < products.size() - 1; j++) {
        if (products.get(j).getName().compareTo(products.get(j + 1).getName()) > 0) {
          Product temp = products.get(j);
          products.set(j, products.get(j + 1));
          products.set(j + 1, temp);
        }
      }
    }

  }

  // Sort products alphabetically by product name
  public void sortCustomersByName() {
    Collections.sort(customers);
    // using the arraylist's sort method, comparable is implemented in customer
    // class
  }

  public void sortAuthorYear(String authorName) {
    ArrayList<Book> authors = new ArrayList<Book>();// this is used to store the books from the author name entered
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getCategory() == Product.Category.BOOKS) {
        Book p = (Book) products.get(i);// downcasting to use the getAuthor method which I created myself/its only in
                                        // book class
        // System.out.println(p.getAuthor());
        // System.out.println(authorName);
        // System.out.println(p.getAuthor() == authorName);
        if (p.getAuthor().equals(authorName)) {
          authors.add(p);
          // if the authorname matches the name given by the user the author is added to
          // authors list
        }
      }
    }
    if (authors.isEmpty() == true) {
      System.out.println("No Author Of This Name Exists");// if the entered name is not the name of any of the authors -
    } else {
      // bubble sorting author name by increasing order of year published
      for (int i = 0; i < authors.size(); i++) {
        for (int j = 0; j < authors.size() - 1; j++) {
          if (authors.get(j).year > authors.get(j + 1).year) {
            Book temp = authors.get(j);
            authors.set(j, authors.get(j + 1));
            authors.set(j + 1, temp);
          }
        }
      }
      for (int i = 0; i < authors.size(); i++) {
        authors.get(i).print();
        // printing the sorted authors list
      }
    }
  }
}