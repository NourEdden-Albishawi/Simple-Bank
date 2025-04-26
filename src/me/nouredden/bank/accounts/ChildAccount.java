package me.nouredden.bank.accounts;

import me.nouredden.bank.interfaces.IAccount;
import me.nouredden.bank.ui.DepositPanel;
import me.nouredden.bank.ui.WithdrawPanel;

import javax.swing.*;
import java.util.UUID;

public class ChildAccount implements IAccount {


    private final UUID id;
    private final String holder, password;
    private int balance, maximumTransactionAmount;
    private String parent;

    public ChildAccount(String holder, String password, int balance) {
        this.id = UUID.randomUUID();
        this.holder = holder;
        this.password = password;
        setBalance(balance);
    }

    public UUID getId() {
        return this.id;
    }

    @Override
    public String getHolder() {
        return holder;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setParent(String name) {
        this.parent = name;
    }

    public String getParent() {
        return this.parent;
    }

    public void setMaximumTransactionAmount(int amount) {
        this.maximumTransactionAmount = amount;
    }

    public int getMaximumTransactionAmount() {
        return this.maximumTransactionAmount;
    }

    @Override
    public void setBalance(int amount) {
        balance = amount;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void withdraw(int amount) {
        if (amount >= 5) {
            if (balance >= amount) {
                if (amount <= maximumTransactionAmount) {
                    JOptionPane.showMessageDialog(new WithdrawPanel(null, null),
                            "Withdrawal successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    balance -= amount;
                } else {
                    JOptionPane.showMessageDialog(new WithdrawPanel(null, null),
                            "You cannot withdraw more than " + maximumTransactionAmount, "Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(new WithdrawPanel(null, null),
                        "You don't have enough balance to do this transaction", "Insufficient balance", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(new WithdrawPanel(null, null),
                    "You cannot withdraw less than 5$", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deposit(int amount) {
        if (amount >= 5) {
            JOptionPane.showMessageDialog(new DepositPanel(null, null),
                    "Deposit successed.", "Success", JOptionPane.INFORMATION_MESSAGE);
            balance += amount;
        } else {
            JOptionPane.showMessageDialog(new DepositPanel(null, null),
                    "You cannot deposit less than 5$", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}
