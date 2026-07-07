import java.util.Arrays;
import java.util.Random;

public class NumberSort {
    public static void main(String[] args) {
        // Create an array to store 25 integer values
        int[] numbers = new int[25];

        // Create a random object to generate random integers
        Random rand = new Random();

        // Fill the array with randomly generated integers
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(100); // Random numbers between 0 and 100

        }

        // Display the unsorted array of the randomly generated integers
        System.out.println("Unsorted Array:");
        System.out.println(Arrays.toString(numbers));

        // Sort the array using Arrays.sort()
        Arrays.sort(numbers);

        // Display the sorted array of randomly generated integers
        System.out.println("\nSorted Array");
        System.out.println(Arrays.toString(numbers));
    }
}