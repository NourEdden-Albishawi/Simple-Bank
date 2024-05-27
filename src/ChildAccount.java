import java.util.UUID;

public class ChildAccount implements IAccount {

    private final String parent;

    private final UUID id;
    private final String holder;
    private int balance;

    private final int maximumAmount;

    public ChildAccount(UUID id, String parent, String holder, int balance, int maximumAmount) {
        this.parent = parent;
        this.id = id;
        this.holder = holder;
        this.balance = balance;
        this.maximumAmount = maximumAmount;
    }

    public UUID getId() {
        return this.id;
    }

    public String getHolder() {
        return holder;
    }

    @Override
    public int setBalance(int amount) {
        return balance = amount;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int withdraw(int amount) {
        if (amount > 5 && balance > amount && amount < maximumAmount) {
            return balance = -amount;
        } else {
            System.out.println("Invalid amount");
            return balance;
        }
    }

    @Override
    public int deposit(int amount) {
        if (amount > 5 && balance > amount) {
            return balance = +amount;
        } else {
            System.out.println("Invalid amount");
            return balance;
        }
    }
}
