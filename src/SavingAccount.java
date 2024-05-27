import java.util.UUID;

public class SavingAccount implements IAccount {


    private final UUID id;
    private final String holder;
    private int balance;
    private final double interestRate = 0.06;
    private final int years;
    public SavingAccount(UUID id, String holder, int balance, int years) {
        this.id = id;
        this.holder = holder;
        this.balance = balance;
        this.years = years;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public String getHolder() {
        return this.holder;
    }

    @Override
    public int setBalance(int amount) {
        return 0;
    }

    @Override
    public int getBalance() {
        if(balance>= 100&& balance < 20000){
            return setBalance(balance);
        }
        return getBalance();
    }

    @Override
    public int withdraw(int amount) {
        if(amount >= 5 && balance> amount){
            return withdraw(amount);
        }
        System.out.println("");
        return balance;
    }

    @Override
    public int deposit(int amount) {
        return deposit(amount);
    }

    public double calculateInterest(){
        return years * balance * interestRate;
    }
}
