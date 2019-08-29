package com.feivirus.phoenix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Phoenix {
     static void testInsert(Connection connection) {
        Statement statement = null;
        int result  = 0;
        
        try {
            statement = connection.createStatement();
            connection.setAutoCommit(true);
            
            result = statement.executeUpdate("upsert into \"gps\" (\"ROW\", \"device_no\",\"latitude\", "
                    + "\"longitude\", \"direction\", \"speed\", \"timestamp\", \"acc\") values('3','33456', '89.87', '99.89', 123.12, 60, 123123, 1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        
        if (result == 1) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }            
    }
     
     static void testSelect(Connection connection) {
         try {
            PreparedStatement statement = connection.prepareStatement("select * from \"gps\"");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String deviceNo = resultSet.getString("device_no");
                //String deviceNo = resultSet.getString(2);
                Float direction = resultSet.getFloat("direction");
                
                System.out.println("deviceNo " + deviceNo + "  direction " + direction);
            }
            
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }    
    
    public static void main(String[] args) {
        Connection connection = null;      

        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            connection = DriverManager.getConnection("jdbc:phoenix:192.168.1.192:2181", "", "");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        testInsert(connection);
        //testSelect(connection);
        
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
