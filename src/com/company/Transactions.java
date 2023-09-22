package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposite,withdrawl,fastcash,ministatement,pinchange,BalanceEnquiry,exit,close;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(240,300,700,45);
        text.setForeground(Color.white);
        image.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(text);

         deposite = new JButton("Deposite");
        deposite.setBounds(170,415,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
         withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
         fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
         ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
         pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        BalanceEnquiry = new JButton("Balance Enquiry");
        BalanceEnquiry.setBounds(355,485,150,30);
        BalanceEnquiry.addActionListener(this);
        image.add(BalanceEnquiry);
         exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        close = new JButton("Exit");
        close.setBounds(820,0,80,30);
        close.addActionListener(this);
        close.setBackground(Color.red);
        close.setForeground(Color.white );
        image.add(close);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== close){
            System.exit(0);
        }

        if (e.getSource()== exit){
            System.exit(0);
        }
        else if (e.getSource()==deposite){
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }
        else if (e.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(e.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(e.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(e.getSource()==BalanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(e.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }

    }
}
