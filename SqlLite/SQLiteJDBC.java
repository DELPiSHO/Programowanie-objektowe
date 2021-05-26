package com.company;

import java.sql.*;
// przyklad z http://www.tutorialspoint.com/sqlite/sqlite_java.htm

public class SQLiteJDBC
{
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:main");
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            int rocz = 0;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM pensje;" );
            while ( rs.next() && rocz>700 ) {
                String  imie = rs.getString("imie");
                int rocznik = rs.getInt("rocznik");
                int pensja  = rs.getInt("pensja");
                System.out.println( imie + "  " + rocznik + "  " + pensja);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
