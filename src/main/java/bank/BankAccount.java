package bank;

class BankAccount {
    private static int amount=0;

    public static int getAmount() {
        return amount;
    }

    // increase bank account
    public static synchronized int enroll(int money) {
        return amount= amount + money;
    }

    // decrease bank account
    public static synchronized int withdraw(int money) {
        return amount  =amount - money;
    }

}
