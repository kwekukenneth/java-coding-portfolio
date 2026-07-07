import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Product class implements Serializable
class Product implements Serializable {
    private static final long serialVersionUID = 1L;
        
        private String name;
        private double price;
        private int calories;
        private int quantity;

    public Product(String name, double price, int calories, int quantity){
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.quantity = quantity;
    }

        // Getters and Setters
        public String getName(){
            return name;
        }

        public double getPrice(){
            return price;
        }

        public int getCalories(){
            return calories;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity){
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-20s £%.2f %5d cal Stock: %d",
                                     name,price, calories, quantity);
        }

}
    public class ProductFiles {
        // File name for serialized data
        private static final String FILE_NAME = "products.dat";

        // ArrayList to store Product objects
        private static ArrayList<Product> products = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);
    }
        public static void main(String[] args) {
            // Load existing products from file when program starts
            loadProducts();

            boolean running = true;
        }
        

    }
        // Main program loop
        while (running) {
            displayMenu();

        try { 
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    viewProducts();
                    break;

                case 2:
                    addProducts();
                    break;

                case 3:
                    removeProducts();
                    break;

                case 4:
                    updateProduct();
                    break;

                case 5:
                    saveProducts();
                    System.out.println("\nPRODUCT MENU");

                case 6: 
                    saveProducts();
                    System.out.println("View Products. Exiting program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
                    break;
            }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

private static void displayMenu() {
    System.out.println("\n===============================");
    System.out.println("    Mobile Catering Product Manager");
    System.out.println("===============================");
    System.out.println("1. View all products");
    System.out.println("2. Add a product");
    System.out.println("3. Remove a product");
    System.out.println("4. Update a product");
    System.out.println("5. Save products to file");
    System.out.println("6. Save and Exit");
    System.out.println("-------------------------------");
    System.out.println("Enter your choice: ");

}

private static void viewProducts(){
    System.out.println("\n========== Product List =========");

    if (products.isEmpty()) {
        System.out.println("No products in inventory.");
    } else {
        System.out.println(String.format("\n%-4s %-20s %-10s %-12s %-10s", 
                                                "#", "Name", "Price", "Calories", "Stock"));
    System.out.println("------------------------------------------------");

    for (int i = 0; i < products.size(); i++) {
        System.out.println((i + 1) + ".  " + products.get(i));
    }
    System.out.println("\nTotal products: " + products.size());
}
}

private static void addProducts() {
    System.out.println("\n========== Add New Product ==========");

    try {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();


        System.out.println("Enter price (£): ");
        double price = Double.parseDouble(scanner.nextLine());

        if (price < 0) {
            System.out.println("Price cannot be negative. Product not added.");
            return;
        }

    
    System.out.println("Enter calories: ");
    int calories = Integer.parseInt(scanner.nextLine());

    if (calories < 0) {
        System.out.println("Calories cannot be negative. Product not added.");
        return;
    }

    System.out.println("Enter quatity in stock: ");
    int quantity = Integer.parseInt(scanner.nextLine());

    if (quantity < 0) {
        System.out.println("Quatity cannot be negative. Product not added.");
        return;
    
}


// Create new Product and to ArrayList
Product newProduct = new Product(name, price, calories, quantity);
products.add(newProduct);

System.out.println("\n Product " + name + " added successfully!");

} catch (NumberFormatException e) {
    System.out.println("\nInvalid input format. Product not added.");
}

private static void removeProducts() {
    System.out.println("\n============= Remove Product =============");

    if (products.isEmpty()) {
        System.out.println("No products available to remove.");
        return;
    }

    viewProducts();

    try{
        System.out.println("\nEnter product number to remove (0 to cancel): ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index == -1) {
            System.out.println("Remove cancelled.");
            return;
        }

        if (index >= 0 && index < products.size()) {
            Product removed = products.remove(index);
            System.out.println("\n Removed: " + removed.getName());
        } else {
            System.out.println("\nInvalid product number.");
        }

    } catch (NumberFormatException e) {
        System.out.println("\nInvalid input.");
    }
}

private static void updateProduct() {
    System.out.println("\n========= Update Product ==========");

    if (products.isEmpty()) {
        System.out.println("No products available to update.");
        return;
    }

viewProducts();

try {
    System.out.println("\nEnter product number to update (0 to cancel): ");
    int index = Integer.parseInt(scanner.nextLine()) - 1;

    if (index == -1) {
        System.out.println("Update cancelled");
        return;
    }

}

if (index >= 0 && index < products.size()) {
    Product product = products.get(index);

    System.out.println("\nUpdating: " + product.getName());
    System.out.println("(Press Enter to keep current value)");

    System.out.println("New name [" + product.getName() + "]: ");
    String name = scanner.nextLine();
    if (!name.isEmpty()) product.setName(name);

    System.out.print("New quatity [£" + product.getPrice() + "]: ");
    String priceStr = scanner.nextLine();
    if (!priceStr.isEmpty()) {
        product.setPrice(Double.parseDouble(priceStr));
    }
}System.out.print("New calories [" + product.getCalories() + "]: ");
                String calStr = scanner.nextLine();
                if (!calStr.isEmpty()) {
                    product.setCalories(Integer.parseInt(calStr));
                }
                
                System.out.print("New quantity [" + product.getQuantity() + "]: ");
                String qtyStr = scanner.nextLine();
                if (!qtyStr.isEmpty()) {
                    product.setQuantity(Integer.parseInt(qtyStr));
                }
                
                System.out.println("\n✓ Product updated successfully!");
                
            } else {
                System.out.println("\nInvalid product number.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid input format.");
        }
    }
    
    private static void saveProducts() {
        // Serialize the entire ArrayList to file
        // IMPORTANT: Writing to an existing file OVERWRITES it completely
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            
            // Write the entire ArrayList as one object
            objectOut.writeObject(products);
            
            objectOut.close();
            fileOut.close();
            
            System.out.println("Data serialized to '" + FILE_NAME + "'");
            
        } catch (IOException e) {
            System.out.println("Error: Can't serialize to file.");
            System.out.println(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    private static void loadProducts() {
        // Deserialize the ArrayList from file
        try {
            FileInputStream fileIn = new FileInputStream(FILE_NAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            // Read the ArrayList object and cast it
            products = (ArrayList<Product>) objectIn.readObject();
            
            objectIn.close();
            fileIn.close();
            
            System.out.println("Products loaded from file: '" + FILE_NAME + "'");
            System.out.println("Found " + products.size() + " product(s) in inventory.");
            
        } catch (FileNotFoundException e) {
            System.out.println("No existing product file found.");
            System.out.println("Starting with empty inventory.");
            // products ArrayList is already initialized as empty
            
        } catch (IOException e) {
            System.out.println("Error reading from file.");
            System.out.println(e.getMessage());
            
        } catch (ClassNotFoundException e) {
            System.out.println("Product class not found during deserialization.");
            System.out.println(e.getMessage());
        }
    }
}
}
}


