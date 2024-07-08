package me.nouredden.bank.ui;

import javax.swing.*;
import java.awt.*;

public class StartupPanel extends JPanel {

    public StartupPanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#f8f9fa"));

        JPanel startupContent = new JPanel();
        startupContent.setLayout(new GridBagLayout());
        startupContent.setBackground(Color.white);
        startupContent.setBorder(BorderFactory.createLineBorder(Color.decode("#ced4da"), 1));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Welcome to our Banking App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        startupContent.add(titleLabel, gbc);

        JButton signInButton = new JButton("Sign In");
        signInButton.setBackground(Color.decode("#007bff"));
        signInButton.setForeground(Color.white);
        signInButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 5);
        startupContent.add(signInButton, gbc);

        signInButton.addActionListener(e -> cardLayout.show(mainPanel, "SignIn"));

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.decode("#28a745"));
        signUpButton.setForeground(Color.white);
        signUpButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        startupContent.add(signUpButton, gbc);

        signUpButton.addActionListener(e -> cardLayout.show(mainPanel, "SignUp"));

        CardPanel cardPanel = new CardPanel(startupContent);
        setLayout(new GridBagLayout());
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.anchor = GridBagConstraints.CENTER;
        gbcMain.insets = new Insets(50, 50, 50, 50);
        add(cardPanel, gbcMain);
    }
}
