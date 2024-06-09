package controllers;

import accounts.Account;
import accounts.ChildAccount;
import accounts.SavingAccount;
import interfaces.IAccount;
import managers.PanelManager;

import java.util.UUID;

public class AppController {
    private PanelManager panelManager;

    public AppController(PanelManager panelManager) {
        this.panelManager = panelManager;
        initController();
    }

    private void initController() {
        handleSignInController();
        handleSignUpController();
        handleProfileController();
        handleTransaction();
    }

    private void handleSignInController() {
        panelManager.getStartupPanel().getSignInButton().addActionListener(e -> panelManager.switchToPanel("signin"));
        panelManager.getSignInPanel().getBackButton().addActionListener(e -> panelManager.switchToPanel("startup"));
        panelManager.getSignInPanel().getSubmitButton().addActionListener(e -> {
            panelManager.switchToPanel("profile");
        });
    }

    private void handleSignUpController() {
        panelManager.getStartupPanel().getSignUpButton().addActionListener(e -> panelManager.switchToPanel("signup"));
        panelManager.getSignUpPanel().getBackButton().addActionListener(e -> panelManager.switchToPanel("startup"));
        panelManager.getSignUpPanel().getSubmitButton().addActionListener(e -> {
            if (panelManager.getSignUpPanel().getComboBox().getSelectedIndex() == 0) {
                String name = panelManager.getSignUpPanel().getUsernameField().getText();
                int balance = Integer.valueOf(panelManager.getSignUpPanel().getBalanceField().getText());
                IAccount account = new Account(UUID.randomUUID(), name, balance);

                panelManager.getProfilePanel().setAccount(account);
                panelManager.getDepositPanel().setAccount(account);
                panelManager.getWithdrawPanel().setAccount(account);
                panelManager.switchToPanel("signin");
            } else if (panelManager.getSignUpPanel().getComboBox().getSelectedIndex() == 1) {
                String name = panelManager.getSignUpPanel().getUsernameField().getText();
                int balance = Integer.valueOf(panelManager.getSignUpPanel().getBalanceField().getText());
                int interestPeriod = panelManager.getSignUpPanel().getInterestPeriod();
                IAccount account = new SavingAccount(UUID.randomUUID(), name, balance, interestPeriod);

                panelManager.getProfilePanel().setAccount(account);
                panelManager.getDepositPanel().setAccount(account);
                panelManager.getWithdrawPanel().setAccount(account);
                panelManager.switchToPanel("signin");
            } else if (panelManager.getSignUpPanel().getComboBox().getSelectedIndex() == 2) {
                String name = panelManager.getSignUpPanel().getUsernameField().getText();
                String parent = panelManager.getSignUpPanel().getChildHolder();
                int balance = Integer.valueOf(panelManager.getSignUpPanel().getBalanceField().getText());
                int maximumPerTransaction = panelManager.getSignUpPanel().getInterestPeriod();

                IAccount account = new ChildAccount(UUID.randomUUID(), name, parent, balance, maximumPerTransaction);

                panelManager.getProfilePanel().setAccount(account);
                panelManager.getDepositPanel().setAccount(account);
                panelManager.getWithdrawPanel().setAccount(account);
                panelManager.switchToPanel("signin");
            }
        });
    }

    private void handleProfileController() {
        panelManager.getProfilePanel().getCheckBalanceButton().addActionListener(e -> {
            panelManager.getProfilePanel().getLabel().setText(
                    "Your balance is:" + panelManager.getProfilePanel().getAccount().getBalance());
        });
        panelManager.getProfilePanel().getDepositButton().addActionListener(e -> {
            panelManager.switchToPanel("deposit");
        });
        panelManager.getProfilePanel().getWithdrawButton().addActionListener(e -> {
            panelManager.switchToPanel("withdraw");
        });

        panelManager.getProfilePanel().getBackButton().addActionListener(e -> {
            panelManager.switchToPanel("startup");
        });
    }

    private void handleTransaction(){
        panelManager.getDepositPanel().getSubmitButton().addActionListener(e ->{
            int i = Integer.valueOf(panelManager.getDepositPanel().getTransactionValue().getText());
            panelManager.getWithdrawPanel().getAccount().deposit(i);
            panelManager.getProfilePanel().getLabel().setText("Your balance is:" + panelManager.getProfilePanel().getAccount().getBalance());
            panelManager.switchToPanel("profile");

        });
        panelManager.getDepositPanel().getCancelButton().addActionListener(e -> {
            panelManager.switchToPanel("profile");
        });

        panelManager.getWithdrawPanel().getSubmitButton().addActionListener(e ->{
            int i = Integer.valueOf(panelManager.getWithdrawPanel().getTransactionValue().getText());
            panelManager.getWithdrawPanel().getAccount().withdraw(i);
            panelManager.getProfilePanel().getLabel().setText("Your balance is:" + panelManager.getProfilePanel().getAccount().getBalance());
            panelManager.switchToPanel("profile");

        });
        panelManager.getWithdrawPanel().getCancelButton().addActionListener(e -> {
            panelManager.switchToPanel("profile");
        });
    }


}
