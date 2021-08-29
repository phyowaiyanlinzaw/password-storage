package com.oldstuffs.passwordstorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginPage implements ActionListener {
    JFrame f;
    JPanel p;
    JLabel l;
    JPasswordField pwf;
    JButton b;
    int timesTried = 5;

    loginPage(){
        f = new JFrame("Security Check Here!");

        l = new JLabel("Enter your password to log in");
        l.setBounds(120,30,300,50);
        l.setFont(new Font("Arial",Font.BOLD,18));

        pwf = new JPasswordField();
        pwf.setBounds(105,100,300,50);
        pwf.setHorizontalAlignment(SwingConstants.CENTER);

        b = new JButton("Submit");
        b.setFocusable(false);
        b.setBounds(200,180,100,50);
        b.setBorder(BorderFactory.createEtchedBorder());
        b.addActionListener(this);

        f.add(l);f.add(pwf);f.add(b);
        f.setSize(500,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getRootPane().setDefaultButton(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String access = "Shinryujin@99";
        String attempt = pwf.getText();

        if (timesTried != 0) {
            if (attempt.equals(access)) {
                f.dispose();
                mainPage mainPage = new mainPage();
            } else {
                JOptionPane.showMessageDialog(f, "Access Denied! Attemps Remaining: " + String.valueOf(timesTried), "Wrong Password", JOptionPane.ERROR_MESSAGE);
                pwf.setText("");
                timesTried--;
            }
        }
        else {
                JOptionPane.showMessageDialog(f,"No Attempts Left!","Access Denied",JOptionPane.ERROR_MESSAGE);
                f.dispose();
                }
    }
}
