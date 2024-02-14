import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {    
    private String name;
    private String type;
    private int[] startDate;
    private int[] endDate;
    private double price;
    private int amount ;
    private double totalPrice ; 
    Customer customer ;
    
    public Product(String name, double price, int amount) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        totalPrice = price * amount;       
    }
    
    public Product(String name,String type, String start,String end,double price) {
        this.name = name;
        this.type = type;
        this.price = price;
        startDate = stringToInt(start.split("\\.")); 
        endDate = stringToInt(end.split("\\."));
    }
    
    public static int [] stringToInt(String[] array) {
        // transforms type of arrays string to integer
        int[] intArray = new int[array.length] ;
        for (int i = 0; i < array.length; i++){
            intArray[i] = Integer.valueOf(array[i]);
        }
        return intArray;   
    }
    public  static BigDecimal decimalFormatting(double price) {
        //returns price parameter with one scale.
        BigDecimal bd = BigDecimal.valueOf(price);
        bd = bd.setScale(1, RoundingMode.DOWN);
        return bd;
    
    }  

    public String display() {
        //Displays name, price, amount and totalPrice attributes of Product objects    
        return String.format("%s\t%s\t%d\t%s", name,decimalFormatting(price),
                amount,decimalFormatting(totalPrice));    
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int[] getStartDate() {
        return startDate;
    }

    public int[] getEndDate() {
        return endDate;
    }

    public double getPrice() {
        return price;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
}