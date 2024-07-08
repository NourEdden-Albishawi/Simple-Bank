package me.nouredden.bank.ui;

import me.nouredden.bank.Bank;
import me.nouredden.bank.interfaces.IAccount;
import me.nouredden.bank.managers.AccountManager;

import javax.swing.*;
import java.awt.*;

public class SignInPanel extends JPanel {

    public SignInPanel(CardLayout cardLayout, JPanel mainPanel, AccountManager accountManager) {

        setLayout(new GridBagLayout());
        setBackground(Color.decode("#f8f9fa"));

        JPanel signInContent = new JPanel();
        signInContent.setLayout(new GridBagLayout());
        signInContent.setBackground(Color.white);
        signInContent.setBorder(BorderFactory.createLineBorder(Color.decode("#ced4da"), 1));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Sign In");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        signInContent.add(titleLabel, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 5);
        signInContent.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(20);
        usernameField.setPreferredSize(new Dimension(250, 30));
        usernameField.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        signInContent.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 5);
        signInContent.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(250, 30));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        signInContent.add(passwordField, gbc);

        JButton signInButton = new JButton("Sign In");
        signInButton.setBackground(Color.decode("#007bff"));
        signInButton.setForeground(Color.white);
        signInButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        signInContent.add(signInButton, gbc);

        signInButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            IAccount account = accountManager.signInUser(username, password);
            if (account != null) {
                Bank.Application.setCurrentAccount(account);
                ProfilePanel profilePanel = new ProfilePanel(cardLayout,mainPanel);
                mainPanel.add(profilePanel, "Profile");
                cardLayout.show(mainPanel, "Profile");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.", "Sign In Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.decode("#dc3545"));
        cancelButton.setForeground(Color.white);
        cancelButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        signInContent.add(cancelButton, gbc);

        cancelButton.addActionListener(e -> cardLayout.show(mainPanel, "Startup"));
        CardPanel cardPanel = new CardPanel(signInContent);
        setLayout(new GridBagLayout());
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.anchor = GridBagConstraints.CENTER;
        gbcMain.insets = new Insets(50, 50, 50, 50);
        add(cardPanel, gbcMain);
    }
}
