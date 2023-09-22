package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nametextfield, fnametextfield,emailtextfield,addresstextfield,citytextfield,statetextfield,pintextfield;
    JButton next;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser jd;
    SignupOne(){
        setLayout(null);            /**defining default layout as null or else setBounds wo'nt work*/
        Random r= new Random();     /**creating a random number for application number*/
        random= (Math.abs((r.nextLong()%9000L)+1000L));

        /**fist label as Application no* */
        JLabel formno= new JLabel("APPLICATION FORM NO. " + random);   /** creating first label*/
        formno.setFont(new Font("Raleway",Font.BOLD,38));         /**defining the font details*/
        formno.setBounds(140,20,600,38);                  /**setBounds means position of the text*/
        add(formno);

        /** 2nd lebel as personal details*/
        JLabel personaldetails= new JLabel("Page 1: Personal Details ");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);

        /** 3RD lebel as name*/
        JLabel name= new JLabel("NAME: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        nametextfield= new JTextField();                            /**Adding textfields for user inputs*/
        nametextfield.setFont(new Font("Raleway",Font.BOLD,14));     /**setting the font details*/
        nametextfield.setBounds(340,140,400,30);           /** setting the position in front of name label*/
        add(nametextfield);

        /** 4TH lebel as fname*/
        JLabel fname= new JLabel("FATHER'S NAME: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        fnametextfield= new JTextField();                            /**Adding textfields for user inputs*/
        fnametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        fnametextfield.setBounds(340,190,400,30);
        add(fnametextfield);

        /** 5TH lebel as dob*/
        JLabel dob= new JLabel("DATE OF BIRTH: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        jd= new JDateChooser();        /**here JDateChooser is a external lib jar file which we imported */
        jd.setBounds(340,240,400,30);
        add(jd);

        /** 6TH lebel as gender*/
        JLabel g= new JLabel("GENDER: ");
        g.setFont(new Font("Raleway",Font.BOLD,20));
        g.setBounds(100,290,200,30);
        add(g);
        male= new JRadioButton("MALE");       /**adding radio buttons which are similar to MCQ's*/
        male.setBounds(340,290,60,30);
        male.setBackground(Color.white);
        add(male);
        female= new JRadioButton("FEMALE");
        female.setBounds(500,290,100,30);
        female.setBackground(Color.white);
        add(female);
        /**The ButtonGroup class creates a group in which you can add radio buttons.
         Of course, only one radio button in a button group can be selected at any time*/
        ButtonGroup gender= new ButtonGroup();
        gender.add(male);
        gender.add(female);

        /** 7TH lebel as email*/
        JLabel email= new JLabel("EMAIL ADDRESS: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        emailtextfield= new JTextField();                            /**Adding textfields for user inputs*/
        emailtextfield.setFont(new Font("Raleway",Font.BOLD,14));
        emailtextfield.setBounds(340,340,400,30);
        add(emailtextfield);

        /** 8TH lebel as marital*/
        JLabel marital= new JLabel("MARITAL STATUS: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        married= new JRadioButton("MARRIED");       /**adding radio buttons which are similar to MCQ's*/
        married.setBounds(340,390,100,30);
        married.setBackground(Color.white);
        add(married);
        unmarried= new JRadioButton("UNMARRIED");
        unmarried.setBounds(485,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        others= new JRadioButton("OTHERS");
        others.setBounds(650,390,100,30);
        others.setBackground(Color.white);
        add(others);
        /**The ButtonGroup class creates a group in which you can add radio buttons.
         Of course, only one radio button in a button group can be selected at any time*/
        ButtonGroup m= new ButtonGroup();
        m.add(married);
        m.add(unmarried);
        m.add(others);

        /** 9TH lebel as address*/
        JLabel address= new JLabel("ADDRESS ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        addresstextfield= new JTextField();                            /**Adding textfields for user inputs*/
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        addresstextfield.setBounds(340,440,400,30);
        add(addresstextfield);

        /** 10TH lebel as city*/
        JLabel city= new JLabel("CITY: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        citytextfield= new JTextField();                            /**Adding textfields for user inputs*/
        citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
        citytextfield.setBounds(340,490,400,30);
        add(citytextfield);

        /** 11TH lebel as state*/
        JLabel state= new JLabel("STATE: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        statetextfield= new JTextField();                            /**Adding textfields for user inputs*/
        statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        statetextfield.setBounds(340,540,400,30);
        add(statetextfield);

        /** 12TH lebel as pin*/
        JLabel pin= new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,590,200,30);
        add(pin);
        pintextfield= new JTextField();                            /**Adding textfields for user inputs*/
        pintextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pintextfield.setBounds(340,590,400,30);
        add(pintextfield);

        /**adding button */
        next= new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(660,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);        /**setting background color of frame*/
        setSize(850,800);                       /**defining frames size*/
        setLocation(350,10);                           /**setting the location of frame from where it starts*/
        setVisible(true);                                   /**visibility of frame is true for make it visible*/
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno=""+random;  //lonng
        String name= nametextfield.getText();   //setText
        String fname= fnametextfield.getText();   //setText
        String dob= ((JTextField)jd.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if (male.isSelected()){
            gender="Male";
        }
        else if (female.isSelected()){
            gender="Female";
        }

        String email =emailtextfield.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }
        else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        else if (others.isSelected()){
            marital="Others";
        }

        String address=addresstextfield.getText();
        String city= citytextfield.getText();
        String state=statetextfield.getText();
        String pin=pintextfield.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"NAME is Required");
            }
            else {
                conn c=new conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"'," +
                        "'"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);          /** to close the current class*/
                new SignupTwo(formno).setVisible(true);       /** open the signuptwo class*/
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SignupOne();
    }


}
