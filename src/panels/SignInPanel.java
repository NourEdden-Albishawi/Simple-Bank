package panels;

import javax.swing.*;
import java.awt.*;

public class SignInPanel extends JPanel
{
    private JTextField username;
    private JComboBox<String> type;
    private JLabel label;
    private JButton submit,back;

    public SignInPanel(){
        username = new JTextField("Username");
        type = new JComboBox<String>(new String[]{"Normal","Saving","Child"});
        label = new JLabel("Welcome to HTU Bank! Please Log In");
        submit = new JButton("Submit");
        back = new JButton("<--");


        username.setBounds(20,100,400,20);
        type.setBounds(20,150,400,20);
        label.setBounds(20,20,400,20);
        submit.setBounds(20,300,400,20);
        back.setBounds(10,350,400,20);

        add(username);
        add(type);
        add(label);
        add(submit);
        add(back, BorderLayout.PAGE_END);
    }

    public JTextField getUsernameField(){
        return this.username;
    }
    public JComboBox getComboBox(){
        return this.type;
    }
    public JLabel getLabel(){
        return this.label;
    }
    public JButton getSubmitButton(){
        return this.submit;
    }

    public JButton getBackButton(){
        return this.back;
    }
}
