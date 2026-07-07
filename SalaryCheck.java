import java.util.Scanner;

// Custom exception class for invalid salary
class InvalidSalaryException extends Exception{
    public InvalidSalaryException(String message){
        super(message);
    }
}

public class SalaryCheck {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int salary = 0;
        boolean validInput = false;
        

        // Loop until valid salary is entered. User will keep being prompted until valid input is confirmed. 
        while (!validInput) {
            try {
                System.out.print("Enter annual salary (£): " );
                String input = scanner.nextLine();

                // Parse the input to the integer
                salary = Integer.parseInt(input);

                // Throw custom exception if salary is not a positive integer value. Validate if salary is positive.
                if (salary <= 0 ) { 
                    throw new InvalidSalaryException("Invalid salary entry. Please enter a positive value.");
                }

                // Input should be valid at this point
                validInput = true;

            } catch (NumberFormatException e) {
                // Manage non-numeric input
                System.out.println("Invalid salary entry. Please enter a positive value. ");

            } catch (InvalidSalaryException e) {
                // Manage non-integer input
                System.out.println(e.getMessage());
               
            }
        }

        System.out.println("------------------------");
        System.out.println("Your salary is £" + salary);

        scanner.close();
    }
}
