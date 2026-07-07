package Utilities;

public class Calculator {
    // Addition
    public double add(double a, double b) {
        return a + b;
    }

    //Subtraction
public double subtract(double a, double b) {
    return a - b;
}

    // Multiplication
public double multiply(double a, double b) {
    return a * b;
}

// Division
public double divide(double a, double b){
    if (b == 0) {
        System.out.println("Error: Zero (0) cannot be used!");
        return 0;
    }
return a / b;
}
}