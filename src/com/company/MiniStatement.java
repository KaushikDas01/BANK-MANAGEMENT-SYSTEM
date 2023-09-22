package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    MiniStatement(String pinnumber){
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,300);
        add(mini);
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card= new JLabel();
        card.setBounds(20,80,300,50);
        add(card);

        JLabel balance= new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            conn conn= new conn();
           ResultSet rs= conn.s.executeQuery("select * from login where pinnumber ='"+pinnumber+"'");
           while (rs.next()){
               card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
           }

        }catch (Exception e){
            System.out.println(e);
        }
        try{
            conn conn= new conn();

            int bal =0;

            ResultSet rs= conn.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");
            while (rs.next()){

                mini.setText(mini.getText() +"<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                        rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+ "<br><html>");

                if(rs.getString("type").equals("Deposite")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs "+ bal);

        }catch (Exception es){
            System.out.println(es);
        }


        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
