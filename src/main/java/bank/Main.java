package bank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // creating two threads
        Thread thread1 = new Process();
        Thread thread2 = new AnotherProcess();

        // putting threads in runnable state
        thread1.start();
        thread2.start();

        // wait till threads will finish execution and die
        thread1.join();
        thread2.join();

        // check bank account
        System.out.println("Finished...");
        System.out.println(BankAccount.getAmount());


    }
}
