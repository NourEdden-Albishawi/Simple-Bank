package me.nouredden.bank;

import me.nouredden.bank.interfaces.IAccount;
import me.nouredden.bank.managers.AccountManager;
import me.nouredden.bank.ui.*;

import javax.swing.*;
import java.awt.*;

public class Bank {
    private IAccount currentAccount;
    public static Bank Application;

    public Bank() {
        Application = this;

        AccountManager accountManager = new AccountManager();
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JFrame frame = new JFrame("Banking Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        StartupPanel startupPanel = new StartupPanel(cardLayout, mainPanel);
        SignInPanel signInPanel = new SignInPanel(cardLayout, mainPanel, accountManager);
        SignUpPanel signUpPanel = new SignUpPanel(cardLayout, mainPanel, accountManager);

        mainPanel.add(startupPanel, "Startup");
        mainPanel.add(signInPanel, "SignIn");
        mainPanel.add(signUpPanel, "SignUp");

        ((CardLayout) mainPanel.getLayout()).show(mainPanel, "Startup");

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void setCurrentAccount(IAccount account) {
        this.currentAccount = account;

    }

    public IAccount getCurrentAccount() {
        return currentAccount;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bank::new);
    }
}
