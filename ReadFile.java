import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    
    private ArrayList<String> lines = new ArrayList<String>();
    
    private ReadFile(String path) throws IOException { 
        /*  Reads files line by line and creates a string arraylist consists of
        these lines.
        If file is not found or occurs an error while reading file returns
        an error message.
        Constitutes a basis for other ReadFile constructors */
        BufferedReader reader = null;
        try {
            FileReader file = new FileReader(path);
            reader = new BufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim().replace("\n",""));
            } 
        }
        catch (FileNotFoundException e) {
            System.err.printf("No such a  %s file..\n", path);
            System.exit(0);
        }
        catch (IOException e){
            System.err.printf("Occurs an error while reading %s file..\n", path);
            System.exit(0);
        }    
        finally {
            if (reader != null) 
                reader.close(); 
        } 
    }
    
    public ReadFile(String path , ArrayList<Product> products) throws IOException {
        /* Reads file line by line and creates Product objects, sets attributes 
        then adds the references of the objects to the "products" arraylist 
        which is in Shopping Class */
        this(path);
        for (String lineX:this.lines) {
            if (! lineX.isEmpty()) {
                String[] line = lineX.split("\t");
                double price = Double.valueOf(line[4]);
                Product product = new Product(line[0],line[1],line[2],line[3],price);
                Shopping.products.add(product);
            }
        }
    }
    public ReadFile(ArrayList<Customer> customers,String path) throws IOException{
        /* Reads file line by line and creates Customer objects, sets attributes
        then adds the references of the objects to the "customers" arraylist 
        which is in Shopping Class */
        this(path);
        for (String lineX:this.lines) {
            ArrayList<Product> soldProducts = new ArrayList<Product>();           
            if (! lineX.isEmpty()) {
                String[] line = lineX.split("\t");
                for (int i =3; i< line.length -1; i+=2) {
                    int amount = Integer.valueOf(line[i+1]);
                    double price = Shopping.findProduct(line[i],line[1],line[2]);
                    Product sold = new Product(line[i],price,amount);
                    soldProducts.add(sold);
                    /* finds products and their valid price which are bought by 
                    customers, then add to the "soldProducts" arraylist 
                    which is an attribute of Customer objects */
            }
                Customer customer = new Customer(line[0],line[1],line[2],soldProducts);
                customers.add(customer);
                //adds each customer to Customer arraylist in Shopping Class
            } 
        }
    }
}