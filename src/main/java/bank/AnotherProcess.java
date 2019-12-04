package bank;

public class AnotherProcess extends Thread {
    Thread thread2 = new Thread();

    @Override
    public void run() {
        for (int i = 1; i < 10; ++i) {
            BankAccount.enroll(i*10);
            System.out.println("SECOND THREAD, name = " + thread2.getName() + " Enroll to account " + i*10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BankAccount.withdraw(i*5);
            System.out.println("SECOND THREAD, name = " + thread2.getName() + " Withdraw from account " + i*5);
        }
    }

}
