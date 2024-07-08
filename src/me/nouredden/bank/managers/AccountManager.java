package me.nouredden.bank.managers;

import me.nouredden.bank.accounts.ChildAccount;
import me.nouredden.bank.accounts.NormalAccount;
import me.nouredden.bank.accounts.SavingAccount;
import me.nouredden.bank.interfaces.IAccount;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private final List<IAccount> userAccounts = new ArrayList<>();

    public IAccount signUpUser(String username, String password, String accountType, int initialBalance) {
        if (isUsernameTaken(username)) {
            return null;
        }
        IAccount account = createAccount(username, password, accountType, initialBalance);
        userAccounts.add(account);
        return account;
    }

    private boolean isUsernameTaken(String username) {
        for (IAccount account : userAccounts) {
            if (account.getHolder().equals(username)) {
                return true;
            }
        }
        return false;
    }
    public IAccount signInUser(String username, String password) {
        for (IAccount account : userAccounts) {
            if (account.getHolder().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    private IAccount createAccount(String username, String password, String accountType, int initialBalance) {
        return switch (accountType.toLowerCase()) {
            case "normal" -> new NormalAccount(username, password, initialBalance);
            case "saving" -> new SavingAccount(username, password, initialBalance);
            case "child" -> new ChildAccount(username, password, initialBalance);
            default -> throw new IllegalArgumentException("Unsupported account type: " + accountType);
        };
    }
}
