package panels;

import javax.swing.*;

public class SignUpPanel extends JPanel {
    private JTextField username, balance;
    private JComboBox<String> type;
    private JLabel label;
    private JButton submit, back;

    private int interestPeriod, transactionMax;
    private String childHolder;

    public SignUpPanel() {
        username = new JTextField("Username");
        balance = new JTextField("Balance");
        type = new JComboBox<String>(new String[]{"Normal", "Saving", "Child"});
        label = new JLabel("Welcome to HTU Bank! Please Sign Up");
        submit = new JButton("Submit");
        back = new JButton("<--");

        username.setBounds(20, 100, 400, 20);
        balance.setBounds(10, 150, 400, 20);
        type.setBounds(20, 200, 400, 20);
        label.setBounds(20, 250, 400, 20);
        submit.setBounds(20, 300, 400, 20);
        back.setBounds(10, 350, 400, 20);


        getComboBox().addActionListener(e -> {
            if (getComboBox().getSelectedIndex() == 1) {
                JTextField interests = new JTextField("Interest Period");
                add(interests);
                interestPeriod = Integer.valueOf(interests.getText());
            }
            if (getComboBox().getSelectedIndex() == 2) {
                JTextField value = new JTextField("Maximum Transaction Value");
                JTextField parent = new JTextField("Parent name");
                add(value);
                add(parent);
                childHolder = parent.getText();
                transactionMax = Integer.valueOf(value.getText());

            }
        });

        add(username);
        add(balance);
        add(type);
        add(label);
        add(submit);
        add(back);
    }

    public JTextField getUsernameField() {
        return this.username;
    }

    public JTextField getBalanceField() {
        return this.balance;
    }

    public JComboBox getComboBox() {
        return this.type;
    }

    public JLabel getLabel() {
        return this.label;
    }

    public JButton getSubmitButton() {
        return this.submit;
    }

    public JButton getBackButton() {
        return this.back;
    }

    public String getChildHolder() {
        return this.childHolder;
    }

    public int getInterestPeriod() {
        return this.interestPeriod;
    }

    public int getTransactionMax() {
        return this.transactionMax;
    }
}
