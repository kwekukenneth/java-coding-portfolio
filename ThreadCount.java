
// Shared resource class for proper synchronization
class SharedCounter {
    private int currentNumber = 1;
    private final int maxNumber = 16;

// Method for printing even numbers
public synchronized void printEven() {
    while (currentNumber <= maxNumber) {
        // Wait if current number is odd
        while (currentNumber % 2 != 0 && currentNumber <= maxNumber) {
            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Print even number within range
        if (currentNumber <= maxNumber) {
            System.out.println("Even Thread: " + currentNumber);
            currentNumber++;
            notify(); //Wake up the waiting thread
        }
    }
}

// Method for printing odd numbers
public synchronized void printOdd() {
    while (currentNumber <= maxNumber) {
        // Wait if current number is even
        while (currentNumber % 2 == 0 && currentNumber <= maxNumber) {
            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Print odd number within range
        if (currentNumber <= maxNumber) {
            System.out.println("Odd Thread:  " + currentNumber);
            currentNumber++;
            notify(); // Wake up the waiting thread
        }
    }
  }
}

// Runnable for printing even numbers 
class EvenNumberPrinter implements Runnable {
    private SharedCounter counter;

    public EvenNumberPrinter(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.printEven();
    }
}

// Runnable for printing odd numbers
class OddNumberPrinter implements Runnable {
    private SharedCounter counter;

    public OddNumberPrinter(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.printOdd();
    }
}

public class ThreadCount{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=========================================");
        System.out.println("  THREAD COUNT PROGRAM");
        System.out.println("========================================");
        System.out.println("Printing numbers 1-16 using two threads");
        System.out.println("----------------------------------------\n");

        // Create shared counter object
        SharedCounter counter = new SharedCounter();

        // Create two threads
        Thread oddThread = new Thread(new OddNumberPrinter(counter), "OddThread");
        Thread evenThread = new Thread(new EvenNumberPrinter(counter), "EvenThread");

        // Start both threads 
        oddThread.start();
        evenThread.start();

        // Pause for both threads to complete
        oddThread.join();
        evenThread.join();

        System.out.println("\n------------------------------------");
        System.out.println("Both threads completed successfully!");
        System.out.println("======================================");
    }
}