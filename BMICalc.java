import java.util.Scanner;


public class BMICalc {
    
   
    public static double calculateBMI(float weight, float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        
        double bmi = weight / (height * height);
        return bmi;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== BMI Calculator ===");
        
        try {
            System.out.print("Enter weight (kg): ");
            float weight = scanner.nextFloat();
            
            System.out.print("Enter height (m): ");
            float height = scanner.nextFloat();
            
            double bmi = calculateBMI(weight, height);
            
            System.out.printf("\nYour BMI: %.2f\n", bmi);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}