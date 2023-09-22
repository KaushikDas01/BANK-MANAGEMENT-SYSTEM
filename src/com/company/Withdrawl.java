package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdrawl,back,close;
    JTextField amount;
    String pinnumber;

    Withdrawl( String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Enter the amount you want to withdraw ");
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount= new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,25));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdrawl= new JButton("Withdraw");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

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
        new Withdrawl(" ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==close){
            System.exit(0);
        }
        if (e.getSource()==withdrawl){
            String number=amount.getText();
            Date date= new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw ");
            }else{
                try {
                    conn conn= new conn();
                    String query= "insert into bank values ('"+ pinnumber+"','"+ date+"','Withdrawl','"+ number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawn Successfully");
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
