package me.nouredden.bank.ui;

import me.nouredden.bank.Bank;
import me.nouredden.bank.accounts.ChildAccount;
import me.nouredden.bank.accounts.SavingAccount;
import me.nouredden.bank.interfaces.IAccount;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    private final JLabel balanceValueLabel;
    private final JTextField parentNameField, maxTransactionField;
    private final JButton calculateInterestButton;

    public ProfilePanel(CardLayout cardLayout, JPanel mainPanel ) {

        setLayout(new BorderLayout());
        setBackground(Color.decode("#f8f9fa"));

        IAccount currentAccount = Bank.Application.getCurrentAccount();
        JPanel profileContent = new JPanel(new GridBagLayout());
        profileContent.setBackground(Color.white);
        profileContent.setBorder(BorderFactory.createLineBorder(Color.decode("#ced4da"), 1));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Profile Panel");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        profileContent.add(titleLabel, gbc);

        JLabel accountInfoLabel = new JLabel("Account Information:");
        accountInfoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        profileContent.add(accountInfoLabel, gbc);

        JLabel accountIdLabel = new JLabel("Account ID: " + currentAccount.getId());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 20, 5, 20);
        profileContent.add(accountIdLabel, gbc);

        JLabel holderLabel = new JLabel("Account Holder: " + currentAccount.getHolder());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 20, 5, 20);
        profileContent.add(holderLabel, gbc);

        balanceValueLabel = new JLabel("Current Balance: $" + currentAccount.getBalance());
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 20, 5, 20);
        profileContent.add(balanceValueLabel, gbc);

        calculateInterestButton = new JButton("Calculate Interest");
        calculateInterestButton.setBackground(Color.decode("#007bff"));
        calculateInterestButton.setForeground(Color.white);
        calculateInterestButton.setFocusPainted(false);
        calculateInterestButton.setVisible(false);
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        profileContent.add(calculateInterestButton, gbc);


        parentNameField = new JTextField(20);
        parentNameField.setVisible(false);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        profileContent.add(parentNameField, gbc);

        JLabel maxTransactionLabel = new JLabel("Max Transaction Amount:");
        maxTransactionLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 5);
        profileContent.add(maxTransactionLabel, gbc);

        maxTransactionField = new JTextField(20);
        maxTransactionField.setVisible(false);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        profileContent.add(maxTransactionField, gbc);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBackground(Color.decode("#28a745"));
        depositButton.setForeground(Color.white);
        depositButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 5, 10, 10);
        profileContent.add(depositButton, gbc);

        depositButton.addActionListener(e -> {
            DepositPanel depositPanel = new DepositPanel(cardLayout, mainPanel);
            mainPanel.add(depositPanel, "Deposit");
            cardLayout.show(mainPanel, "Deposit");
        });

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(Color.decode("#dc3545"));
        withdrawButton.setForeground(Color.white);
        withdrawButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        profileContent.add(withdrawButton, gbc);

        withdrawButton.addActionListener(e -> {
            WithdrawPanel withdrawPanel = new WithdrawPanel(cardLayout, mainPanel);
            mainPanel.add(withdrawPanel, "Withdraw");
            cardLayout.show(mainPanel, "Withdraw");
        });

        JButton logOutButton = new JButton("Log Out");
        logOutButton.setBackground(Color.decode("#6c757d"));
        logOutButton.setForeground(Color.white);
        logOutButton.setFocusPainted(false);
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        profileContent.add(logOutButton, gbc);

        logOutButton.addActionListener(e -> {
            Bank.Application.setCurrentAccount(null);
            cardLayout.show(mainPanel, "Startup");
        });

        CardPanel cardPanel = new CardPanel(profileContent);
        add(cardPanel, BorderLayout.CENTER);
        updateProfilePanel();
    }

    public void updateProfilePanel() {
        IAccount currentAccount = Bank.Application.getCurrentAccount();
        if (currentAccount != null) {
            balanceValueLabel.setText("Current Balance: $" + currentAccount.getBalance());
            if (currentAccount instanceof SavingAccount savingAccount) {
                calculateInterestButton.setVisible(true);
                parentNameField.setVisible(false);
                maxTransactionField.setVisible(false);
                calculateInterestButton.addActionListener( e -> savingAccount.calculateInterest());
            } else if (currentAccount instanceof ChildAccount childAccount) {
                parentNameField.setText(childAccount.getParent());
                parentNameField.setVisible(true);
                maxTransactionField.setText(String.valueOf(childAccount.getMaximumTransactionAmount()));
                maxTransactionField.setVisible(true);
                calculateInterestButton.setVisible(false);
            } else {
                calculateInterestButton.setVisible(false);
                parentNameField.setVisible(false);
                maxTransactionField.setVisible(false);
            }
        } else {
            balanceValueLabel.setText("Error: Current account is null.");
            calculateInterestButton.setVisible(false);
            parentNameField.setVisible(false);
            maxTransactionField.setVisible(false);
        }
    }
}
