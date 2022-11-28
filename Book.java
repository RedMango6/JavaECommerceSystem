//Name: Taha Iqbal
//Student ID: 501112475

import java.util.Locale;

/* A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.

*/
public class Book extends Product 
{
  private String author;
  private String title;
  private String yearPublished= "0"; //for BOOKSBYAUTHOR not complete
  
  // Stock related information NOTE: inherited stockCount variable is used for EBooks
  int paperbackStock;
  int hardcoverStock;
  
  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title, String author)
  {
  	 // Make use of the constructor in the super class Product. Initialize additional Book instance variables. 
  	 // Set category to BOOKS

      super(name, id, price,100000, Category.BOOKS);
      this.paperbackStock = paperbackStock;
      this.hardcoverStock = hardcoverStock;
      this.title = title;
      this.author = author;
  }


  public void setYearPublished(String yearPublished){ //for BOOKSBYAUTHOR not complete
      if (yearPublished.trim().length()==4 && this.yearPublished.equals("0")){
          this.yearPublished=yearPublished;
      }

  }

  public String getYearPublished(){  //for BOOKSBYAUTHOR not complete
      return this.yearPublished;
  }

  public String getAuthor(){  //for BOOKSBYAUTHOR not complete
      return author;
  }


  // Check if a valid format  
  public boolean validOptions(String productOptions)
  {
      //In each conditional statement of the following structure, we are checking if the trimmed version of the string is
      //equal (in value) to either "Paperback" "Hardcover" or "EBook".
      String optionString= productOptions.trim().toLowerCase();
      if (optionString.equals("paperback") || optionString.equals("hardcover") || optionString.equals("ebook")){

          return true;

      } else{

          return false;

      }
  }
  
  // Override getStockCount() in super class.
  public int getStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and return) the number of stock for "Paperback" etc
  	// Use the variables paperbackStock and hardcoverStock at the top. 
  	// For "EBook", use the inherited stockCount variable.

        String optionString= productOptions.trim().toLowerCase();
        if (validOptions(productOptions)){ //Checking if productOptions equals either "Paperback", "Hardcover", "Ebook" after trimming.

            if (optionString.equals("paperback")){

                return paperbackStock;

            }else if (optionString.equals("hardcover")){

                return hardcoverStock;

            }else if (optionString.equals("ebook")){
                //In this next line we are using the "super" call to get the private stockCount variable of the product class
                return super.getStockCount(productOptions);

            }
        }
  	    return 1;



	}
  
  public void setStockCount(int stockCount, String productOptions)
	{
    // Use the productOptions to check for (and set) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.

        //In the following conditional statement, we are checking if productOptions equals either "Paperback", "Hardcover", "Ebook" using validOptions()
        // We are also making sure that the inputted stockCount is not less than 0. In real life, we can't have a negative amount of product.

        String optionString= productOptions.trim().toLowerCase();
        if (validOptions(productOptions) && !(stockCount<0)){

            if (optionString.equals("paperback")){

                paperbackStock=stockCount;

            }else if (optionString.equals("hardcover")){

                hardcoverStock=stockCount;

            }else if (optionString.equals("ebook")){

                //super.setStockCount(stockCount, productOptions);

                //In this next line we are using the "super" call to set the private stockCount variable of the product class.
                //we insert 100000 for the stockCount parameter because the number of EBooks is essentially infinite.
                super.setStockCount(100000, productOptions);

            }
        }
	}
  
  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  public void reduceStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and reduce) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
        String optionString= productOptions.trim().toLowerCase();
        //In the following conditional statement, we are checking if productOptions equals either "Paperback", "Hardcover", "Ebook" using validOptions()
        if (validOptions(productOptions)){

            if (optionString.equals("paperback")){

                paperbackStock-=1;

            }else if (optionString.equals("hardcover")){

                hardcoverStock-=1;

            }else if (optionString.equals("ebook")){

                //super.reduceStockCount(productOptions); REMOVE
            }
        }

	}
  /*
   * Print product information in super class and append Book specific information title and author
   */
  public void print()
  {
  	// Replace the line below.
  	// Make use of the super class print() method and append the title and author info. See the video

      super.print(); //calling the super.print() method that does not output a \n at the end.

      //In the next line we do not put a \n escape character in the output so that the output prints on the same line as super.print().
      System.out.printf(" Book Title: %s Author: %s", this.title, this.author);
  }
}
