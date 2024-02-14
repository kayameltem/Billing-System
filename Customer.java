import java.util.ArrayList;

public class Customer {
    private String consumer ;
    private String type ;
    private String date ;
    private ArrayList<Product> product ; //consists of purchased products by consumer
    
    public Customer(String consumer, String type,String date,ArrayList<Product> product)
    {
        this.consumer = consumer;
        this.type = type;
        this.date = date;
        this.product = product;       
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public String getConsumer() {
        return consumer;
    }
}