package me.nouredden.bank.interfaces;

import java.util.UUID;

public interface IAccount {

    UUID getId();
    String getHolder();
    String getPassword();

    void setBalance(int amount);
    int getBalance();
    void withdraw(int amount);
    void deposit(int amount);


}
