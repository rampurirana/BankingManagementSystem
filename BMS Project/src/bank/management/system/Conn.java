package bank.management.system;

import java.sql.*;

public class Conn {

    Connection connection;
    Statement statement;
    public Conn(){

        try {
            //Connect the my sql workbench for store the data
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Rana@1435");
            statement = connection.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
