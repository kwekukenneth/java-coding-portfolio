class BankAccount {
    private double balance;
    private String accountName;

public BankAccount(String accountName, double initialBalance) {
    this.accountName = accountName;
    this.balance = initialBalance;

}
// Synchronized deposit method
public synchronized void deposit(String user, double amount) {
    System.out.printf("[%s] Depositing: £%.2f\n", user, amount);
    balance += amount;
    System.out.printf("[%s] New Balance: £%.2f\n", user, balance);
    System.out.println("---");

    // Add small delay to simulate processing time
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}

// Synchronized withdrawal method
public synchronized void withdraw(String user, double amount) {
    System.out.printf("[%s] Attempting to withdraw: £%.2f\n", user, amount);

    if (balance - amount < 0) {
        System.out.printf("⚠ ALERT: [%s] Insufficient funds! Balance: £%.2f, Withdrawal: £%.2f\n",
                                                user, balance, amount);
System.out.println("⚠ Transaction DENIED - Account would go negative!");
System.out.println("---");
    } else {
        balance -= amount;
        System.out.printf("[%s] Withdrawal successful: £%.2f\n", user, amount);
        System.out.printf("[%s] New Balance: £%.2f\n", user, balance);
        System.out.println("---");
    }

    // Add small delay to simulate processing time
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}

// Get current balance 
public synchronized double getBalance() {
    return balance;
}

public String getAccountName() {
    return accountName;
}
}

// Thread class representing User 1
class User1Thread extends Thread {
    private BankAccount account;
    private String userName;

    public User1Thread(BankAccount account, String userName) {
        this.account = account;
        this.userName = userName;
    }

    @Override
    public void run() {
        System.out.println("\n>>> " + userName + " starting transactions...\n");

        // Perform 5 operations: 2 withdrawals, 2 deposits, 1 extra operation
        account.deposit(userName, 200.00);
        account.withdraw(userName, 150.00);
        account.deposit(userName, 100.00);
        account.withdraw(userName, 300.00);
        account.withdraw(userName, 50.00);

        System.out.println(">>> " + userName + " completed all transactions.\n");
    }
}

// Thread class representing User 2
class User2Thread extends Thread{
    private BankAccount account;
    private String userName;

    public User2Thread(BankAccount account, String userName) {
        this.account = account;
        this.userName = userName;
    }

    @Override
    public void run() {
        System.out.println("\n>>> " + userName + " starting transactions...\n");

        // 5 operational threads: 2 withdrawals, 2 deposits, 1 extra operation
        account.withdraw(userName, 100.00);
        account.deposit(userName, 250.00);
        account.withdraw(userName, 200.00);
        account.deposit(userName, 150.00);
        account.deposit(userName, 75.00);

        System.out.println(">>> " + userName + " completed all transactions.\n");
    }
}

public class JointAccount {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("     JOINT BANK ACCOUNT SIMULATION");
        System.out.println("========================================");

        // Create shared bank account with initial balance
        double initialBalance = 500.00;
        BankAccount sharedAccount = new BankAccount("Joint Savings Account", initialBalance);

        System.out.printf("\nAccount: %s\n", sharedAccount.getAccountName());
        System.out.printf("Initial Balance: £%.2f\n", initialBalance);
        System.out.printf("\n=========================================\n");

        // Create two user threads
        User1Thread babara = new User1Thread(sharedAccount, "Babara");
        User2Thread jacob = new User2Thread(sharedAccount, "Jacob");

        // Start both threads
        babara.start();
        jacob.start();

        // Wait for both threads to complete
        try {
            babara.join();
            jacob.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
            Thread.currentThread().interrupt();
        }

        // Display final balance
        System.out.println("=====================================");
        System.out.println("    ALL TRANSACTIONS COMPLETED");
        System.out.println("======================================");
        System.out.printf("\nFinal Balance: £%.2f\n", sharedAccount.getBalance());

        // Check if account is overdrawn
        if (sharedAccount.getBalance() < 0) {
            System.out.println("\n⚠ WARNING: Account is OVERDRAWN!");
        } else if (sharedAccount.getBalance() < 100) {
            System.out.println("\n⚠ NOTICE: Low balance - Consider making a deposit");
        } else {
            System.out.println("\n✓ Account is in good standing");
        }

        System.out.println("\n===============================================");
        }
    }

