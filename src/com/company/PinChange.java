package com.company;

import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton back, change,close;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);

        JLabel text= new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250,280,500,20);
        image.add(text);

        JLabel pintext= new JLabel("New PIN :");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel repintext= new JLabel("Re-Enter New PIN :");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change= new JButton("CHANGE");
        change.setBounds(355,480,150,30);
        change.addActionListener(this);
        image.add(change);

        back= new JButton("BACK");
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
       new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== close){
            System.exit(0);
        }
        if (e.getSource()==change){          /** if user clicks on change button */
        try{
            String npin=pin.getText();
            String rpin= repin.getText();

            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter NEW PIN");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Re-Enter NEW PIN");
                return;
            }
            if (!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered Pin Does Not Match");
                return;
            }
            conn conn= new conn();
            String query1="update bank set pin ='"+rpin+"' where pin= '"+pinnumber+"' ";
            String query2="update login set pinnumber ='"+rpin+"' where pinnumber = '"+pinnumber+"' ";
            String query3="update signupthree set pin ='"+rpin+"' where pin= '"+pinnumber+"' ";

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null,"PIN changed successfully ");

            setVisible(false);
            new Transactions(rpin).setVisible(true);


        }catch (Exception eas){
            System.out.println(eas);
        }
        }
        else{                           /** if user clicks on back button */
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
}
