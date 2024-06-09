package accounts;

import interfaces.IAccount;

import java.util.UUID;

public class ChildAccount implements IAccount {

    private final String parent;

    private final UUID id;
    private final String holder;
    private int balance;

    private int maximumAmount;

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
        if(amount >= 5){
            if(balance >= amount){
                if(amount <= maximumAmount){
                    System.out.println(amount + " has been taken off your account");
                    return balance -= amount;
                }else{
                    System.out.println("You cannot withdraw more than " + maximumAmount);

                }
            }else{
                System.out.println("You don't have enough balance to do this transaction");
            }
        }else{
            System.out.println("You cannot withdraw less than 5$");
        }

        return balance;
    }

    @Override
    public int deposit(int amount) {
        if (amount >= 5 ) {
            System.out.println(amount + " has been deposit into your account");
            return balance +=amount;
        } else {
            System.out.println("You cannot deposit less than 5$ per transaction.");
            return balance;
        }
    }
}
