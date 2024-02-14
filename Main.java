import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        new ReadFile(args[1], Shopping.products); 
        new ReadFile(Shopping.customers, args[0]);
        Shopping.displayAllBills(); 

    } 
}