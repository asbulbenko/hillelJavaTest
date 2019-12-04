package bank;

public class Process extends Thread{
    Thread thread1 = new Thread();

    @Override
    public void run() {
        // in the loop bank account will increase
        // and decrease in the same time
        for (int i = 1; i < 10; ++i) {
            BankAccount.enroll(i*10);
            System.out.println("FIRST THREAD, name = " + thread1.getName() + " Enroll to account " + i*10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BankAccount.withdraw(i*5);
            System.out.println("FIRST THREAD, name = " + thread1.getName() + " Withdraw from account " + i*5);
        }
    }
}
