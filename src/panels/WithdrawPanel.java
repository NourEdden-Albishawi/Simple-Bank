package panels;

import interfaces.IAccount;

import javax.swing.*;

public class WithdrawPanel extends JPanel {

    private JLabel label;
    private JTextField transactionValue;
    private JButton submit, cancel;
    private IAccount account;

    public WithdrawPanel() {
        label = new JLabel("Enter Transaction Value:");
        transactionValue = new JTextField("Value");
        submit = new JButton("Submit");
        cancel = new JButton("cancel");

        add(label);
        add(transactionValue);
        add(submit);
        add(cancel);
    }

    public void setAccount(IAccount account) {
        this.account = account;
    }

    public IAccount getAccount() {
        return this.account;
    }

    public JLabel getLabel() {
        return this.label;
    }

    public JTextField getTransactionValue() {
        return this.transactionValue;
    }

    public JButton getSubmitButton() {
        return this.submit;
    }

    public JButton getCancelButton() {
        return this.cancel;
    }
}
