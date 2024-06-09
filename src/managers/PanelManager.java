package managers;

import panels.*;

import javax.swing.*;
import java.awt.*;

public class PanelManager
{
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private StartupPanel startupPanel;
    private SignInPanel signInPanel;
    private SignUpPanel signUpPanel;
    private ProfilePanel profilePanel;
    private DepositPanel depositPanel;
    private WithdrawPanel withdrawPanel;

    public PanelManager() {
        frame = new JFrame("HTU Bank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        startupPanel = new StartupPanel();
        signInPanel = new SignInPanel();
        signUpPanel = new SignUpPanel();
        profilePanel = new ProfilePanel();
        depositPanel = new DepositPanel();
        withdrawPanel  = new WithdrawPanel();

        mainPanel.add(startupPanel, "startup");
        mainPanel.add(signInPanel, "signin");
        mainPanel.add(signUpPanel, "signup");
        mainPanel.add(profilePanel, "profile");
        mainPanel.add(depositPanel, "deposit");
        mainPanel.add(withdrawPanel, "withdraw");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void switchToPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public StartupPanel getStartupPanel(){
        return this.startupPanel;
    }

    public SignInPanel getSignInPanel(){
        return this.signInPanel;
    }

    public SignUpPanel getSignUpPanel(){
        return this.signUpPanel;
    }
    public ProfilePanel getProfilePanel(){
        return this.profilePanel;
    }

    public DepositPanel getDepositPanel(){
        return this.depositPanel;
    }

    public WithdrawPanel getWithdrawPanel() {
        return withdrawPanel;
    }
}
