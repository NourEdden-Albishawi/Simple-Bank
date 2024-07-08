package me.nouredden.bank.ui;

import me.nouredden.bank.Bank;
import me.nouredden.bank.interfaces.IAccount;

import javax.swing.*;
import java.awt.*;

public class DepositPanel extends JPanel {

    public DepositPanel(CardLayout cardLayout, JPanel mainPanel) {
        IAccount currentAccount = Bank.Application.getCurrentAccount();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Deposit");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(titleLabel, gbc);

        gbc.gridwidth = 1;

        JLabel amountLabel = new JLabel("Amount:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(amountLabel, gbc);

        JTextField amountField = new JTextField(15);
        amountField.setBorder(BorderFactory.createLineBorder(Color.decode("#ced4da")));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(amountField, gbc);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.decode("#28a745"));
        submitButton.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String amountText = amountField.getText();
            currentAccount.deposit(Integer.parseInt(amountText));

            ProfilePanel profilePanel = new ProfilePanel(cardLayout,mainPanel);
            mainPanel.remove(profilePanel);
            mainPanel.add(profilePanel, "Profile");

            cardLayout.show(mainPanel, "Profile");
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.decode("#6c757d"));
        cancelButton.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(cancelButton, gbc);

        cancelButton.addActionListener(e -> cardLayout.show(mainPanel, "Profile"));
    }
}
