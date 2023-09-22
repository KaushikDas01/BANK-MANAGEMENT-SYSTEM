package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Locale;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,signup;
    JTextField cardtextfield;
    JPasswordField pintextfield;
    JCheckBox show;

    Login(){
        setLayout(null);
        ImageIcon  i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon  i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

                /*first label for atm only*/
        JLabel text= new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,30);
        add(text);

//        second label for card text and user input
        JLabel cardno= new JLabel("CARD NO: ");
        cardno.setFont(new Font("Baleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        cardtextfield= new JTextField();     //textfield for enter cardnumber
        cardtextfield.setBounds(300,150,230,30);
        cardtextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtextfield);

//        third label for pin text and user input
        JLabel pin= new JLabel("PIN: ");
        pin.setFont(new Font("Baleway",Font.BOLD,28));
        pin.setBounds(120,220,150,30);
        add(pin);
        pintextfield= new JPasswordField ();      //textfield for enter pin number
        pintextfield.setBounds(300,220,230,30);
        pintextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(pintextfield);
        show= new JCheckBox("Show Password");
        show.setBounds(540,220,120,30);
        show.setFont(new Font("Arial",Font.BOLD,10));
        show.addActionListener(this);
        add(show);

        //adding login IN button
        login= new JButton("LOG IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        //adding CLEAR button
        clear= new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        //adding sign up button
        signup= new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        setTitle("AUTOMATED TELLER MACHINE");
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (show.isSelected()){
            pintextfield.setEchoChar((char) 0);
        }
        else {
            pintextfield.setEchoChar('*');
        }
        if (e.getSource()==clear){
            cardtextfield.setText("");
            pintextfield.setText("");
        }
        else if(e.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if(e.getSource()==login){
            conn conn= new conn();
            String cardnumber=cardtextfield.getText();
            String pinnumber=pintextfield.getText();
            String query="select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"' ";
            try{
                ResultSet rs= conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN ");
                }
            }catch (Exception ea){
                System.out.println(ea);
            }

        }

    }
}
