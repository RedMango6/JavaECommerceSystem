
/* A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.

*/
public class Book extends Product {
  private String author;
  private String title;

  // Stock related information NOTE: inherited stockCount variable is used for
  // EBooks
  int paperbackStock;
  int hardcoverStock;
  int year;

  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title,
      String author, int yearPublished) {
    // Make use of the constructor in the super class Product. Initialize additional
    // Book instance variables.
    // Set category to BOOKS
    super(name, id, price, Integer.MAX_VALUE, Product.Category.BOOKS);
    this.paperbackStock = paperbackStock;
    this.hardcoverStock = hardcoverStock;
    this.author = author;
    this.title = title;
    this.year= yearPublished;
  }

  // Check if a valid format
  public boolean validOptions(String productOptions) {
    // check productOptions for "Paperback" or "Hardcover" or "EBook"
    // if it is one of these, return true, else return false
    if (productOptions.equals("Paperback") || productOptions.equals("Hardcover") || productOptions.equals("EBook")) {
      return true;
    }
    return false;
  }

  // Override getStockCount() in super class.
  @Override
  public int getStockCount(String productOptions) {
    // Use the productOptions to check for (and return) the number of stock for
    // "Paperback" etc
    // Use the variables paperbackStock and hardcoverStock at the top.
    // For "EBook", use the inherited stockCount variable.
    // System.out.println(paperbackStock);
    if (productOptions.equals("Paperback")) {
      return paperbackStock;
    } else if (productOptions.equals("Hardcover")) {
      return hardcoverStock;
    } else if (productOptions.equals("EBook")) {
      return super.getStockCount("");
    } else {
      return 0;
    }
  }

  public String getAuthor() {
    return this.author;
  }

  public void setStockCount(int stockCount, String productOptions) {
    // Use the productOptions to check for (and set) the number of stock for
    // "Paperback" etc
    // Use the variables paperbackStock and hardcoverStock at the top.
    // For "EBook", set the inherited stockCount variable.
    if (productOptions == "Hardcover") {
      hardcoverStock = stockCount;
    }
    if (productOptions == "Paperback") {
      paperbackStock = stockCount;
    }
    if (productOptions == "EBook") {
      super.setStockCount(stockCount, "EBook");
      ;
    }
  }

  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  public void reduceStockCount(String productOptions) {
    // Use the productOptions to check for (and reduce) the number of stock for
    // "Paperback" etc
    // Use the variables paperbackStock and hardcoverStock at the top.
    // For "EBook", set the inherited stockCount variable.
    if (productOptions.equals("Hardcover")) {
      hardcoverStock--;
    }
    if (productOptions.equals("Paperback")) {
      paperbackStock--;
    }
    if (productOptions.equals("EBook")) {
      super.reduceStockCount("");
    }
  }

  /*
   * Print product information in super class and append Book specific information
   * title and author
   */
  public void print() {
    // Replace the line below.
    super.print();
    System.out
        .print('\t' + " Book Title: " + this.title + " " + "Author: " + this.author + " Year: " + this.year);
    // Make use of the super class print() method and append the title and author
    // info. See the video
    // System.out.print("\nBook");
  }
}
