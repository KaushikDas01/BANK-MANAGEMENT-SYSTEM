package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton deposite,withdrawl,fastcash,ministatement,pinchange,balanceEnquery,exit,close;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Select Withdrawl Mode");
        text.setBounds(240,300,700,45);
        text.setForeground(Color.white);
        image.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(text);

        deposite = new JButton("RS 100");
        deposite.setBounds(170,415,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        withdrawl = new JButton("RS 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        fastcash = new JButton("RS 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement = new JButton("RS 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange = new JButton("RS 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceEnquery = new JButton("RS 10000");
        balanceEnquery.setBounds(355,485,150,30);
        balanceEnquery.addActionListener(this);
        image.add(balanceEnquery);
        exit = new JButton("BACK");
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
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== close){
            System.exit(0);
        }

        if (e.getSource()== exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else {
            String amount=((JButton)e.getSource()).getText().substring(3);
            conn c= new conn();
            try {
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposite")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date= new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+amount+" Debited Sucessfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch (Exception a){
                System.out.println(a);
            }
        }


    }
}
