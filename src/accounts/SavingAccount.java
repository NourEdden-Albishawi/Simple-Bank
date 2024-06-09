package accounts;

import interfaces.IAccount;

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
        if (balance >= 100 && balance < 20000) {
            return balance = amount;
        }
        return balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int withdraw(int amount) {
        if (amount > 5 && balance >= amount) {
            System.out.println(amount + " has been removed from your account");
            return balance -=amount;
        } else {
            System.out.println("Invalid amount");
            return balance;
        }
    }

    @Override
    public int deposit(int amount) {
        if (amount > 5 && balance >= amount) {
            System.out.println(amount + " has been added into your account");
            return balance +=amount;
        } else {
            System.out.println("Invalid amount");
            return balance;
        }

    }

    public double calculateInterestRate() {
        double value = ((getYears() * getBalance()) * getInterestRate());
        return value;
    }
    public double getInterestRate(){
        return interestRate;
    }
    public int getYears(){
        return years;
    }
}
