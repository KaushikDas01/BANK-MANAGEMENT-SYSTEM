package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField pantextfield,aadartextfield;
    JButton next;
    JRadioButton syes,sno,accyes,accno;
    JComboBox religion,category,income,education,occupation;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);            /**defining default layout as null or else setBounds wo'nt work*/

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        /**fist label as additionaldetails for Application details */
        JLabel additionaldetails= new JLabel("Page 2: Additional Details ");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);

        /** 2ND lebel as rel for Religion*/
        JLabel rel= new JLabel("RELIGION: ");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,120,30);
        add(rel);
        String valreligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        religion= new JComboBox(valreligion);     /** jcombo box is used for drop dowm optipns*/
        religion.setBounds(340,140,400,30); /** setting its position*/
        religion.setBackground(Color.white);
        add(religion);

        /** 3RD lebel as cat for Category*/
        JLabel cat= new JLabel("CATEGORY: ");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,190,200,30);
        add(cat);
        String valcategory[]={"General","OBC-A","OBC-B","SC","ST","PWD"};
        category= new JComboBox(valcategory);
        category.setBounds(340,190,400,30);
        category.setBackground(Color.white);
        add(category);

        /** 4TH lebel as salary for income*/
        JLabel salary= new JLabel("INCOME: ");
        salary.setFont(new Font("Raleway",Font.BOLD,20));
        salary.setBounds(100,240,200,30);
        add(salary);
        String valincome[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income= new JComboBox(valincome);
        income.setBounds(340,240,400,30);
        income.setBackground(Color.white);
        add(income);

        /** 5TH and 6th lebel as education qualification*/
        JLabel g= new JLabel("EDUCATIONAL: ");
        g.setFont(new Font("Raleway",Font.BOLD,20));
        g.setBounds(100,290,200,30);
        add(g);
        JLabel edu= new JLabel("QUALIFICATION: ");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,320,200,30);
        add(edu);
        String educategory[]={"Non-Graduation","Graduate","Post-Graduate","Doctorate","Others"};
        education= new JComboBox(educategory);
        education.setBounds(340,320,400,30);
        education.setBackground(Color.white);
        add(education);

        /** 7TH lebel as work for occupation*/
        JLabel work= new JLabel("OCCUPATION: ");
        work.setFont(new Font("Raleway",Font.BOLD,20));
        work.setBounds(100,390,200,30);
        add(work);
        String workcategory[]={"Salaried","Self_Emploied","Business","Student","Retired","Others"};
        occupation= new JComboBox(workcategory);
        occupation.setBounds(340,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);

        /** 8TH lebel as pan number*/
        JLabel pan= new JLabel("PAN NUMBER ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        pantextfield= new JTextField();                            /**Adding textfields for user inputs*/
        pantextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pantextfield.setBounds(340,440,400,30);
        add(pantextfield);

        /** 9TH lebel as aadhar number*/
        JLabel adhar= new JLabel("AADHAR NUMBER: ");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(100,490,200,30);
        add(adhar);
        aadartextfield= new JTextField();                            /**Adding textfields for user inputs*/
        aadartextfield.setFont(new Font("Raleway",Font.BOLD,14));
        aadartextfield.setBounds(340,490,400,30);
        add(aadartextfield);

        /** 10TH lebel as sinior*/
        JLabel sinior= new JLabel("SINIOR CITIZEN: ");
        sinior.setFont(new Font("Raleway",Font.BOLD,20));
        sinior.setBounds(100,540,200,30);
        add(sinior);
        syes=new JRadioButton("YES");
        syes.setBounds(340,540,100,30);
        syes.setBackground(Color.white);
        add(syes);
        sno=new JRadioButton("NO");
        sno.setBounds(440,540,100,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup siniors=new ButtonGroup();
        siniors.add(syes);
        siniors.add(sno);


        /** 11TH lebel as exacc*/
        JLabel exacc= new JLabel("EXISTING ACCOUNT: ");
        exacc.setFont(new Font("Raleway",Font.BOLD,20));
        exacc.setBounds(100,590,220,30);
        add(exacc);
        accyes=new JRadioButton("YES");
        accyes.setBounds(340,590,100,30);
        accyes.setBackground(Color.white);
        add(accyes);
        accno=new JRadioButton("NO");
        accno.setBounds(440,590,100,30);
        accno.setBackground(Color.white);
        add(accno);

        ButtonGroup eaccnt=new ButtonGroup();
        eaccnt.add(accyes);
        eaccnt.add(accno);

        /**adding button */
        next= new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(660,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);        /**setting background color of frame*/
        setSize(850,800);                       /**defining its size*/
        setLocation(350,10);                           /**setting the location from where it starts*/
        setVisible(true);                                   /**visibility is true for make it visible*/
    }

 @Override
    public void actionPerformed(ActionEvent ae) {
        String sreligion =(String) religion.getSelectedItem();
        String scategory= (String) category.getSelectedItem();
        String sincome= (String) income.getSelectedItem();
        String seducation= (String) education.getSelectedItem();
        String soccupation= (String) occupation.getSelectedItem();


        String siniorcitizen =null;
        if (syes.isSelected()){
            siniorcitizen="YES";
        }
        else if (sno.isSelected()){
            siniorcitizen="NO";
        }

        String existiingAcc=null;
        if(accyes.isSelected()){
            existiingAcc="YES";
        }
        else if(accno.isSelected()){
            existiingAcc="NO";
        }

        String span=pantextfield.getText();
        String saadhar= aadartextfield.getText();

        try{
                conn c=new conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"',"
                        + "'"+soccupation+"','"+span+"','"+saadhar+"','"+siniorcitizen+"','"+existiingAcc+"')";
                c.s.executeUpdate(query);

            //sign up 3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");
    }


}
