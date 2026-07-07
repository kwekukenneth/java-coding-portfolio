import java.util.Scanner;

// Interface for finding minimum and maximum values.
interface MinMax {
    int min();
    int max();
}

// Class that implements MinMax interface.
class MyData implements MinMax {
    private int[] data;  
    
    // Constructor to initialize an array
    public MyData(int[] data) {
        this.data = data;
    }
    
    // Method to find minimum value in the array 
    @Override
    public int min() {
        if (data == null || data.length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        
        int minimum = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < minimum) {
                minimum = data[i];
            }
        }
        return minimum;
    }
    
    // Method to find maximum value in the array 
    @Override
    public int max() {
        if (data == null || data.length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        
        int maximum = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > maximum) {
                maximum = data[i];
            }
        }
        return maximum;
    }
    
    // Main method to demonstrate the functionality.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get array size from user
        System.out.print("How many numbers do you want to enter? (at least 5): ");
        int size = input.nextInt();
        
        // Validate size
        if (size < 5) {
            System.out.println("Please enter at least 5 numbers.");
            input.close();
            return;
        }
        
        // Create array and allow the user input
        int[] numbers = new int[size];
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
        
        // Create MyData object with the array
        MyData myData = new MyData(numbers);
        
        // Display the array
        System.out.println("\nArray elements:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        
        // Find and display minimum value.
        int minimum = myData.min();
        System.out.println("Minimum value: " + minimum);
        
        // Find and display maximum value.
        int maximum = myData.max();
        System.out.println("Maximum value: " + maximum);
        
        input.close();
    }
}