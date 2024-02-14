import java.util.ArrayList;

public class Shopping {
    
    public static ArrayList<Customer> customers = new ArrayList<Customer>() ;
    public static ArrayList<Product> products = new ArrayList<Product>() ;
    
    public static boolean timeValidty(int[] start, int[] end, String[] datex) {
        /* ensures time validity of price of products
        if the date when product is purchased is between start and 
        end dates of price returns true otherwise false.
        means of indexes for Each of parameters ;
        zeroth index: "day"
        first index: "month"
        second index: "year" 
        */
       int[] date = Product.stringToInt(datex);
       if (start[2] == date[2] && end[2] == date[2]) {
           if (start[1] == date[1] && end[1] == date[1]) {
               if (date[0] >= start[0] && date[0] <= end[0])
                   return true;}
            else if (start[1] == date[1] && date[0] >= start[0])
                   return true;
            else if (end[1] == date[1] && date[0] <= end[0])
               return true;
            else if (end[1] > date[1] && start[1] < date[1])
            return true;}
       else if (start[2] == date[2]){
           if (start[1] == date[1] && date[0] >= start[0])
               return true;
           else if (start[1] < date[1])
               return true; }
       else if(end[2]== date[2]) {
           if (end[1] == date[1] && date[0] <= end[0])
               return true;
           else if (end[1] > date[1])
               return true; }
       else if(start[2]< date[2] && date[2] < end[2])
           return true;
       return false;   
       }
            
    public static double findProduct(String name, String type, String date) {
        /* finds sold products according to the name and type comparison between 
        every product objects in products Arraylist which is an attribute of 
        Shopping class and token parameters.
        if found, returns price of the product otherwise zero.  
        */
        double price = 0;
        for (Product i:Shopping.products) {
            if(i.getName().equals(name) && i.getType().equals(type)) {
               if (timeValidty(i.getStartDate(),i.getEndDate(), date.split("\\.")))
                    price = i.getPrice();
        }
    }
        return price;
}
    public static void displayAllBills(){
        //Displays all customers in "Customers" arraylist and their shopping bills         
        for (Customer customer:customers) {
            System.out.printf("---%s---\n", customer.getConsumer());
            double total = 0;
            for (Product product:customer.getProduct()) {
                System.out.println(product.display());
                total += product.getTotalPrice();  //calculates total pay amount for each customer    
            }
            System.out.printf("Total\t%s\n",Product.decimalFormatting(total));             
        } 
    }
}