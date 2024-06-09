package panels;

import javax.swing.*;

public class StartupPanel extends JPanel
{
    private JButton signIn, signUp;
    private JLabel label;
    public StartupPanel(){
        signIn = new JButton("Sign In");
        signUp = new JButton("Sign Up");
        label = new JLabel("Welcome to HTU Bank");

        signIn.setBounds(20,100,400,20);
        signUp.setBounds(20,100,400,20);
        label.setBounds(20,150,400,20);

        add(signIn);
        add(signUp);
        add(label);
    }

    public JButton getSignInButton(){
        return this.signIn;
    }

    public JButton getSignUpButton(){
        return this.signUp;
    }
    public JLabel getLabel(){
        return this.label;
    }

}
