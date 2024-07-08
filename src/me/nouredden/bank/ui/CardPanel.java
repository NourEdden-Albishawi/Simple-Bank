package me.nouredden.bank.ui;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    public CardPanel(JPanel content) {
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.decode("#ced4da"), 1));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 300));
        add(content, BorderLayout.CENTER);
    }
}
