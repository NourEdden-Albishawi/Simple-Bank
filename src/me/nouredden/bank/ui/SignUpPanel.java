package me.nouredden.bank.ui;

import me.nouredden.bank.accounts.ChildAccount;
import me.nouredden.bank.accounts.SavingAccount;
import me.nouredden.bank.managers.AccountManager;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SignUpPanel extends JPanel {

    private final JTextField parentNameField;
    private final JTextField maxTransactionField;
    private JTextField interestRateField;
    private JTextField interestPeriodField;

    public SignUpPanel(CardLayout cardLayout, JPanel mainPanel, AccountManager accountManager) {

        setLayout(new GridBagLayout());
        setBackground(Color.decode("#f8f9fa"));

        JPanel signUpContent = new JPanel(new GridBagLayout());
        signUpContent.setBackground(Color.white);
        signUpContent.setBorder(BorderFactory.createLineBorder(Color.decode("#ced4da"), 1));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        signUpContent.add(titleLabel, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 5);
        signUpContent.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(20);
        usernameField.setPreferredSize(new Dimension(250, 30));
        usernameField.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        signUpContent.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 5);
        signUpContent.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(250, 30));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        signUpContent.add(passwordField, gbc);

        JLabel accountTypeLabel = new JLabel("Account Type:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 5);
        signUpContent.add(accountTypeLabel, gbc);

        String[] accountTypes = {"Normal", "Saving", "Child"};
        JComboBox<String> accountTypeBox = new JComboBox<>(accountTypes);
        accountTypeBox.setPreferredSize(new Dimension(250, 30));
        accountTypeBox.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        signUpContent.add(accountTypeBox, gbc);

        JLabel balanceLabel = new JLabel("Initial Balance:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 5);
        signUpContent.add(balanceLabel, gbc);

        JTextField balanceField = new JTextField(20);
        balanceField.setPreferredSize(new Dimension(250, 30));
        balanceField.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 10, 10);
        signUpContent.add(balanceField, gbc);


        parentNameField = new JTextField(20);
        maxTransactionField = new JTextField(20);

        accountTypeBox.addActionListener(e -> {
            String selectedType = (String) accountTypeBox.getSelectedItem();
            assert selectedType != null;

            JLabel parentNameLabel = new JLabel("Parent's Name:");
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.insets = new Insets(10, 10, 10, 5);

            JLabel maxTransactionLabel = new JLabel("Max Transaction Amount:");
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.insets = new Insets(10, 10, 10, 5);

            if (selectedType.equals("Saving")) {
                JLabel interestRateLabel = new JLabel("Interest Rate (%):");
                gbc.gridx = 0;
                gbc.gridy = 5;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.EAST;
                gbc.insets = new Insets(10, 10, 10, 5);
                signUpContent.add(interestRateLabel, gbc);

                interestRateField = new JTextField(20);
                interestRateField.setPreferredSize(new Dimension(25, 25));
                interestRateField.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
                gbc.gridx = 1;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(10, 5, 10, 10);
                signUpContent.add(interestRateField, gbc);

                JLabel interestPeriodLabel = new JLabel("Interest Period In Years:");
                gbc.gridx = 0;
                gbc.gridy = 6;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.EAST;
                gbc.insets = new Insets(10, 10, 10, 5);
                signUpContent.add(interestPeriodLabel, gbc);

                interestPeriodField = new JTextField(20);
                interestPeriodField.setPreferredSize(new Dimension(25, 25));
                interestPeriodField.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
                gbc.gridx = 1;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(10, 5, 10, 10);
                signUpContent.add(interestPeriodField, gbc);

                interestRateField.setVisible(true);
                interestPeriodField.setVisible(true);

                parentNameField.setVisible(false);
                maxTransactionField.setVisible(false);
                parentNameLabel.setVisible(false);
                maxTransactionLabel.setVisible(false);

            } else if (selectedType.equals("Child")) {

                signUpContent.add(parentNameLabel, gbc);

                parentNameField.setPreferredSize(new Dimension(250, 30));
                parentNameField.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
                gbc.gridx = 1;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(10, 5, 10, 10);
                signUpContent.add(parentNameField, gbc);
                signUpContent.add(maxTransactionLabel, gbc);

                maxTransactionField.setPreferredSize(new Dimension(250, 30));
                maxTransactionField.setBorder(BorderFactory.createLineBorder(Color.decode("#adb5bd")));
                gbc.gridx = 1;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(10, 5, 10, 10);
                signUpContent.add(maxTransactionField, gbc);
                parentNameField.setVisible(true);
                maxTransactionField.setVisible(true);
            }
            revalidate();
            repaint();
        });

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.decode("#28a745"));
        signUpButton.setForeground(Color.white);
        signUpButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        signUpContent.add(signUpButton, gbc);

        signUpButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String accountType = (String) accountTypeBox.getSelectedItem();
            int initialBalance = Integer.parseInt(balanceField.getText());

            switch (Objects.requireNonNull(accountType)) {
                case "Normal" -> accountManager.signUpUser(username, password, accountType, initialBalance);
                case "Saving" -> {
                    double interestRate = Double.parseDouble(interestRateField.getText());
                    int interestPeriodInYears = Integer.parseInt(interestPeriodField.getText());
                    SavingAccount savingAccount = (SavingAccount) accountManager.signUpUser(username, password, accountType, initialBalance);
                    savingAccount.setInterestRate(interestRate);
                    savingAccount.setInterestPeriodInYears(interestPeriodInYears);
                }
                case "Child" -> {
                    String parentName = parentNameField.getText();
                    int maxTransactionAmount = Integer.parseInt(maxTransactionField.getText());
                    ChildAccount childAccount = (ChildAccount) accountManager.signUpUser(username, password, accountType, initialBalance);
                    childAccount.setParent(parentName);
                    childAccount.setMaximumTransactionAmount(maxTransactionAmount);
                }
            }
            cardLayout.show(mainPanel, "Startup");
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.decode("#dc3545"));
        cancelButton.setForeground(Color.white);
        cancelButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        signUpContent.add(cancelButton, gbc);

        cancelButton.addActionListener(e -> cardLayout.show(mainPanel, "Startup"));

        CardPanel cardPanel = new CardPanel(signUpContent);
        setLayout(new GridBagLayout());
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.fill = GridBagConstraints.BOTH;
        gbcMain.weightx = 1.0;
        gbcMain.weighty = 1.0;
        add(cardPanel, gbcMain);
    }
}
