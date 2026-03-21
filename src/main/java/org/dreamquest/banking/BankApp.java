package org.dreamquest.banking;


public class BankApp {

    private volatile double balance;

    private String name;


    private final Object lockName = new Object();
    private final Object lockBalance = new Object();

    private final LockClass lockClass = new LockClass();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        synchronized (lockName) {
            try {
                System.out.println("Started updated the name: ");
                Thread.sleep(7000);
                this.name = name;
                System.out.println("Name is updated successfully with name: " + this.name);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public BankApp(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        try {
            System.out.println("Talking to the banker about depositing the money.......");
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        synchronized (lockBalance) {
//            double currentBalance = this.balance;
//            balance += amount;
//
//            System.out.printf("Deposit amount %.2f, Current Balance amount %.2f, " +
//                    "Updated Balance amount %.2f%n", amount, currentBalance, balance);
//        }

        synchronized (lockClass) {
            try {
                System.out.println("lock class is locked from deposit sync block");

                Thread.sleep(8000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            double currentBalance = this.balance;
            balance += amount;

            System.out.printf("Deposit amount %.2f, Current Balance amount %.2f, " +
                    "Updated Balance amount %.2f%n", amount, currentBalance, balance);
        }


    }

    public synchronized void withdrawal(double amount) {
        try {
            Thread.sleep(200);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (balance < amount)
            return;

        double currentBalance = this.balance;
        balance -= amount;

        System.out.printf("Withdrawal amount %.2f, Current Balance amount %.2f, " +
                "Updated Balance amount %.2f%n", amount, currentBalance, balance);
    }

    public double getBalance() {
        return balance;
    }


}
