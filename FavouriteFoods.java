import java.io.*;
import java.util.Scanner;

public class FavouriteFoods {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Create a file name
        System.out.println("Enter the name of the file you want to create: ");
        String fileName = input.nextLine();

        // Step 2: Get 3 favourite foods from the user
        System.out.println("\nEnter 3 favourite foods:");
        String favfood1 = FoodInput(input, 1);
        String favfood2 = FoodInput(input, 2);
        String favfood3 = FoodInput(input, 3);

        // Step 3: Write the first 3 foods to save to file
        writeInitialFoods(fileName, favfood1, favfood2, favfood3);

        //Step 4: Read the file for verifiction
        System.out.println("\nReading file contents:");
        readFile(fileName);

        //Step 5: Get 2 more favourite foods from the user
        System.out.println("\nEnter 2 more favourite foods:");
        String food4 = FoodInput(input, 4);
        String food5 = FoodInput(input, 5);

        // Step 6: Attach the additional foods
        appendFoods(fileName, food4, food5);

        //Step 7: Read the file again to display all 5 foods
        System.out.println("\nFinal file contents (all 5 foods):");
        readFile(fileName);

        System.out.println("\nSuccess! Check the file " + fileName + " in your file system.");
        
        input.close();
    }

    // Helper method to obtain food input with sequntial numbering
    static String FoodInput(Scanner input, int number){
        System.out.print("Food " + number + ": ");
        return input.nextLine();
}

// Write initial 3 foods to file 
static void writeInitialFoods(String fileName, String food1, String food2, String food3) {
    try {
        File dataFile = new File(fileName);

        // Create file
        if (dataFile.createNewFile()) {
            System.out.println("\nFile " + fileName + " created successfully.");
        } else {
            System.out.println("\nFile already exists. Overwriting...");
        }

        // Write the 3 foods to file
        FileWriter writer = new FileWriter(dataFile);
        writer.write(food1 + "\n");
        writer.write(food2 + "\n");
        writer.write(food3 + "\n");
        writer.close();

        System.out.println("First three foods written to file.");

    } catch (IOException e) {
        System.out.println("Error writing to the file.");
        System.out.println(e);
    }
}

// Append 2 more foods to existing file
static void appendFoods(String fileName, String food4, String food5) {
    try {
        File dataFile = new File(fileName);
        FileWriter writer = new FileWriter(dataFile, true); // true = append mode
        writer.write(food4 + "\n");
        writer.write(food5 + "\n");
        writer.close();

        System.out.println("2 additional foods attach to file.");

    } catch (IOException e) {
        System.out.println("Error attaching to file.");
        System.out.println(e);
    }
}

// Read file contents and display them
static void readFile(String fileName) {
    try {
        File dataFile = new File(fileName);
        Scanner read = new Scanner(dataFile);
        int count = 1;

        while (read.hasNextLine()) {
            
            String data = read.nextLine();
            System.out.println(count + ". " + data);
            count++;
        }

        read.close();
    } catch (FileNotFoundException e) {
        System.out.println("Error reading file: File not found.");
        System.out.println(e);
    }
}

}
