package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener {
    JButton deposite,back,close;
    JTextField amount;
    String pinnumber;

    Deposite( String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Enter the amount you want to deposit ");
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount= new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,25));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        deposite= new JButton("Deposit");
        deposite.setBounds(355,485,150,30);
        deposite.addActionListener(this);
        image.add(deposite);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

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
        new Deposite(" ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==close){
            System.exit(0);
        }
        if (e.getSource()==deposite){
            String number=amount.getText();
            Date date= new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Deposit ");
            }else{
                try {
                conn conn= new conn();
                String query= "insert into bank values ('"+ pinnumber+"','"+ date+"','Deposite','"+ number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }

            }

        }
        else if (e.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }
}
