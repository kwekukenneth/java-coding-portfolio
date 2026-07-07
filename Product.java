import java.io.Serializable;

public class Product implements Serializable {
    
    private String name;
    private double price;
    private int calories;
    private int quantity;

    public Product(String name, double price, int calories, int quantity) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return name + "| £" + price + " | " + calories + " cal | Qty: " + quantity;
    }

    public String getName() {
        return name;
    }
}
