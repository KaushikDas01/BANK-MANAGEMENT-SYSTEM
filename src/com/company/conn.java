package com.company;
import java.sql.*;


/**
 there are mainly 5 steps in JDBC connection [JAVA DATABASE CONNECTION]
 1.REGISTER THE DRIVER
 2.CREATE CONNECTION
 3.CREATE STATEMENT
 4.EXECUTE QUERY
 5.CLOSE CONNECTION
 */
public class conn {
    Connection c;       /** 2nd step*/
    Statement s;        /** 3rd step*/
    public conn(){
        try {
            /**1st step*/
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","kaushik");         /** 2nd step*/
            s=c.createStatement();


        }catch (Exception e){
            System.out.println(e);
        }
    }
}
