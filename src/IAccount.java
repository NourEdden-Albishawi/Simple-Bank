import java.util.UUID;

public interface IAccount {

    UUID getId();
    String getHolder();

    int setBalance(int amount);
    int getBalance();
    int withdraw(int amount);
    int deposit(int amount);

}
