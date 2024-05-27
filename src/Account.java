import java.util.UUID;

public class Account implements IAccount {
    private final UUID id;
    private final String holder;
    private int balance;

    public Account(UUID id, String holder, int balance) {
        this.id = id;
        this.holder = holder;
        this.balance = balance;
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
        if (amount > 5 && balance > amount) {
            return balance = +amount;
        } else {
            System.out.println("Invalid amount");
            return balance;
        }
    }

    @Override
    public int deposit(int amount) {
        if (amount > 5 && balance > amount) {
            return balance = -amount;
        } else {
            System.out.println("Invalid amount");
            return balance;
        }
    }
}
