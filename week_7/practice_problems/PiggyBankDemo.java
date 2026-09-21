class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be greater than 0");
            return;
        }
        savings += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw rejected: amount must be greater than 0");
            return;
        }
        if (amount > savings) {
            System.out.println("Withdraw rejected: insufficient savings");
            return;
        }
        savings -= amount;
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

public class PiggyBankDemo {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("deposit(100) -> savings = " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("withdraw(30) -> savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("withdraw(500) -> savings stays " + pb.getSavings());
    }
}