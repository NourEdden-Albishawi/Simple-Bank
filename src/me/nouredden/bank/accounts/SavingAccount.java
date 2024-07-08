package me.nouredden.bank.accounts;

import me.nouredden.bank.interfaces.IAccount;
import me.nouredden.bank.ui.DepositPanel;
import me.nouredden.bank.ui.WithdrawPanel;

import javax.swing.*;
import java.util.UUID;

public class SavingAccount implements IAccount {

    private final UUID id;
    private final String holder, password;
    private int balance, interestPeriodInYears;
    private double interestRate;

    public SavingAccount(String holder, String password, int balance) {
        this.id = UUID.randomUUID();
        this.holder = holder;
        this.password = password;
        setBalance(balance);
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
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setBalance(int amount) {
        if (balance >= 100 && balance < 20000) {
            balance = amount;
        }
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void withdraw(int amount) {
        if (amount >= 5) {
            if (balance >= amount) {
                JOptionPane.showMessageDialog(new WithdrawPanel(null, null),
                        "Withdrawal successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                balance -= amount;
            } else {
                JOptionPane.showMessageDialog(new WithdrawPanel(null, null),
                        "Insufficient balance", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(new WithdrawPanel(null, null),
                    "You can't withdrawal less than 5$", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deposit(int amount) {
        if (amount >= 5) {
            JOptionPane.showMessageDialog(new DepositPanel(null, null),
                    "Deposit successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
            balance += amount;
        } else {
            JOptionPane.showMessageDialog(new DepositPanel(null, null),
                    "You can't deposit less than 5$", "Failed", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void calculateInterest() {
        JOptionPane.showMessageDialog(new WithdrawPanel(null, null),
                "Your interest value is " + ((getInterestPeriodInYears() * getBalance()) * getInterestRate()),
                "Calculate Interests", JOptionPane.INFORMATION_MESSAGE);
    }

    public int getInterestPeriodInYears() {
        return this.interestPeriodInYears;
    }

    public void setInterestPeriodInYears(int i) {
        this.interestPeriodInYears = i;
    }

    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
