package com.oldstuffs.passwordstorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class mainPage implements ActionListener {
    JFrame f;
    JTextField tf1,tf2,tf3;
    JLabel l1,l2,l3;
    JButton b;

    mainPage(){
        f = new JFrame("Password Storage!");

        l1 = new JLabel("Note");
        l1.setBounds(80,50,200,50);
        l1.setFont(new Font("Arial",Font.BOLD,18));
        l2 = new JLabel("Username/Email");
        l2.setBounds(60,150,200,50);
        l2.setFont(new Font("Arial",Font.BOLD,18));
        l3 = new JLabel("Password");
        l3.setBounds(60,250,200,50);
        l3.setFont(new Font("Arial",Font.BOLD,18));

        tf1 = new JTextField();
        tf1.setBounds(300,50,300,50);
        tf2 = new JTextField();
        tf2.setBounds(300,150,300,50);
        tf3 = new JTextField();
        tf3.setBounds(300,250,300,50);

        b = new JButton("Save");
        b.setFocusable(false);
        b.setBounds(280,330,150,50);
        b.setBorder(BorderFactory.createEtchedBorder());
        b.addActionListener(this);

        f.add(l1);f.add(l2);f.add(l3);
        f.add(tf1);f.add(tf2);f.add(tf3);
        f.add(b);
        f.setSize(700,450);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getRootPane().setDefaultButton(b);
    }

    public String doingEncryption(String beforeEncryption){
        char[] ch = new char[beforeEncryption.length()];
        int[] intArray = new int[beforeEncryption.length()];        
    for (int i = 0; i < beforeEncryption.length(); i++) {
        ch[i] = beforeEncryption.charAt(i);
        intArray[i] = ch[i];
        intArray[i] = intArray[i] + 5;
    }
    for (int i = 0; i < intArray.length;i++){
        ch[i] = (char)intArray[i];        
    }
    String afterEncryption = String.valueOf(ch);
    return afterEncryption;
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String usernameBeforeEncryption = tf2.getText();
        String passwordBeforeEncryption = tf3.getText();

        String usernameAfterEncryption = doingEncryption(usernameBeforeEncryption);
        String passwordAfterEncryption = doingEncryption(passwordBeforeEncryption);

        

        try(FileWriter fw = new FileWriter("storage.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print(tf1.getText());
            out.print(" : ");
            out.print(usernameAfterEncryption);
            out.print(" : ");
            out.print(passwordAfterEncryption);
            out.println("");

            JOptionPane.showMessageDialog(f,"Successfully Saved!");
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");

        } catch (IOException io) {
        }
    }
}