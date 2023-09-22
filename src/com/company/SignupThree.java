package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree( String formno){
        this.formno=formno;
        setLayout(null);                /**defining default layout as null or else setBounds wo'nt work*/

        JLabel l1= new JLabel("PAGE 3: ACCOUNT DETAILS");        /** creating first label*/
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);                 /**setBounds means position of the text*/
        add(l1);

        JLabel type= new JLabel("ACCOUNT TYPE :");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1=new JRadioButton("SAVING ACCOUNT");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,200,20);                 /**setBounds means position of the text*/
        r1.setBackground(Color.white);
        add(r1);
        r2=new JRadioButton("FIXED DEPOSIT ACCOUNT");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,300,20);                 /**setBounds means position of the text*/
        r2.setBackground(Color.white);
        add(r2);
        r3=new JRadioButton("CURRENT ACCOUNT");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,200,20);                 /**setBounds means position of the text*/
        r3.setBackground(Color.white);
        add(r3);
        r4=new JRadioButton("RECURRING DEPOSIT ACCOUNT");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,300,20);                 /**setBounds means position of the text*/
        r4.setBackground(Color.white);
        add(r4);
        ButtonGroup groupaccount= new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card= new JLabel("CARD NUMBER :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        JLabel number= new JLabel("XXXX-XXXX-XXXX-XXXX");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        JLabel carddetails= new JLabel("Your 16 digit card number");
        carddetails.setFont(new Font("Raleway",Font.BOLD,13));
        carddetails.setBounds(100,320,300,30);
        add(carddetails);

        JLabel pin= new JLabel("PIN NUMBER :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pnumber= new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        JLabel pindetails= new JLabel("Your 4 digit password");
        pindetails.setFont(new Font("Raleway",Font.BOLD,13));
        pindetails.setBounds(100,390,300,30);
        add(pindetails);

        JLabel service= new JLabel("SERVICES REQUIRED :");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,440,300,30);
        add(service);
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,480,200,30);
        add(c1);
        c2=new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,480,200,30);
        add(c2);
        c3=new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,520,200,30);
        add(c3);
        c4=new JCheckBox("EMAIL & SMS ALERTS");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,520,200,30);
        add(c4);
        c5=new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,560,200,30);
        add(c5);
        c6=new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,560,200,30);
        add(c6);
        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBounds(100,640,1000,30);
        add(c7);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.white);
        setSize(850,820);                    /**defining frames size*/
        setLocation(350,0);                         /**setting the location of frame from where it starts*/
        setVisible(true);                                 /**visibility of frame is true for make it visible*/

    }
    public static void main(String[] args) {
        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            String accounttype=null;
            if (r1.isSelected()){
                accounttype="Saving Account";
            }
            else if(r2.isSelected()){
                accounttype="Fixed Deposite Account";
            }
            else if(r3.isSelected()){
                accounttype="Current Account";
            }
            else if(r4.isSelected()){
                accounttype="Reccuring Deposite Account";
            }
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
            String pinnumber=""+Math.abs((random.nextLong() % 9000L)+ 1000L);

            String facility=" ";
            if (c1.isSelected()){
                facility=facility+ "ATM Card";
            }
            else if(c2.isSelected()){
                facility=facility+" Internet Banking";
            }
            else if(c3.isSelected()){
                facility=facility+" Mobile Banking";
            } else if(c4.isSelected()){
                facility=facility+" EMAIL & SMS Alerts";
            } else if(c5.isSelected()){
                facility=facility+"Cheque Book";
            } else if(c6.isSelected()){
                facility=facility+"E-Statement";
            }

            try{
                if (accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }
                else{
                    conn con= new conn();
                    String query1 = "insert into signupthree values('"+ formno+"','"+ accounttype+"','"+ cardnumber +"','"+ pinnumber+"','"+ facility+"')";
                    String query2 = "insert into login values('"+ formno+"','"+ cardnumber +"','"+ pinnumber+"')";
                    con.s.executeUpdate(query1);
                    con.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: "+ cardnumber+ "\n pin: "+ pinnumber);

                   setVisible(false);
                    new Deposite(pinnumber).setVisible(true);


                }

            }catch (Exception ae){
                System.out.println(ae);
            }
        }
        else if (e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
