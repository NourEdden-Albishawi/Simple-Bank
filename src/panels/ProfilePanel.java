package panels;

import HTU.Main;
import interfaces.IAccount;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel
{
    private JLabel label; // Your Balance Is:
    private JButton checkBalance,deposit,withdraw,back;
    private IAccount account;
    public ProfilePanel(){
        label = new JLabel("Please select your transaction type");
        checkBalance = new JButton("Check Balance");
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        back = new JButton("<--");

        add(label, BorderLayout.PAGE_START);
        add(checkBalance, BorderLayout.CENTER);
        add(deposit, BorderLayout.CENTER);
        add(withdraw, BorderLayout.CENTER);

        add(back, BorderLayout.PAGE_END);
    }

    public IAccount getAccount(){
        return  this.account;
    }
    public IAccount setAccount(IAccount account){
        return this.account = account;
    }

    public JButton getDepositButton(){
        return this.deposit;
    }
    public JButton getCheckBalanceButton(){
        return this.checkBalance;
    }

    public JButton getBackButton(){
        return this.back;
    }
    public JLabel getLabel(){
        return this.label;
    }
    public JButton getWithdrawButton(){
        return this.withdraw;
    }
}
