package com.feivirus.phoenix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * phoenix 源码分析v0.01
 * https://blog.csdn.net/feivirus/article/details/102685049
 */
public class Phoenix {
    static void testCreateIndex(Connection connection) {
        Statement statement = null;
        String sqlCreateIndex = "CREATE LOCAL INDEX IDX_WM_JNY_ID ON DATA_CENTER.WKD_MESSAGE (JNY_ID) async";
        
        try {
            statement = connection.createStatement();
            connection.setAutoCommit(true);
            int result = statement.executeUpdate(sqlCreateIndex);
            
            if(result > 0) {
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    static void testInsert(Connection connection) {
        Statement statement = null;
        int result = 0;
        String sqlUserA = "UPSERT INTO FEIVIRUS_TEST.DC_USER(id,name, PASSWORD) SELECT ID + ";
        String sqlUserB = " ,NAME,PASSWORD FROM FEIVIRUS_TEST.DC_USER_1 WHERE id < 201";
        //(2,2,1,2)
        String sqlOrder = "UPSERT INTO FEIVIRUS_TEST.DC_ORDER(id,DC_USER_ID, ORDER_TYPE, DC_GOODS_ID)VALUES (";     
        //1,'g1',1,8.8)
        String sqlGood = "UPSERT INTO FEIVIRUS_TEST.DC_GOODS(id,GOODS_NAME, GOODS_CATEGORY, GOODS_PRICE)VALUES(";
        int currentRow = 5003;
        StringBuffer buffer = new StringBuffer();
        String sqlTest = "upsert into DATA_CENTER.DEV_GPS_TEST(BUSINESS_NO, dev)values('";

        try {
            statement = connection.createStatement();
            connection.setAutoCommit(true);
//            result = statement.executeUpdate("upsert into \"gps\" (\"ROW\", \"device_no\",\"latitude\", "
//                    + "\"longitude\", \"direction\", \"speed\", \"timestamp\", \"acc\") values('3','33456', '89.87', '99.89', 123.12, 60, 123123, 1)");            
            while (currentRow <= 1000000) {
                //user
                //buffer.append(sqlUserA);
                
                //order
                buffer.append(sqlTest);
                //id
                buffer.append(currentRow);
                buffer.append("','");
                //dc_user_id
//                buffer.append(currentRow);
//                buffer.append(",1,");
                //dc_goods_id
                buffer.append(currentRow);
                buffer.append("')");
                //buffer.append(sqlUserB);
                
                //goods
//                buffer.append(sqlGood);
//                buffer.append(currentRow);
//                buffer.append(",'g1',1,");
//                buffer.append(currentRow);
//                buffer.append(")");
                
                result = statement.executeUpdate(buffer.toString());
                if (result > 0) {
                    System.out.println("插入成功 " + currentRow);
                } else {
                    System.out.println("插入失败");
                    break;
                }
                buffer.delete(0, buffer.length());
                currentRow += 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void testSelect(Connection connection) {
        try {
            String singleTableSelect = "SELECT * FROM DATA_CENTER.WAKANDA_GPS AS wg WHERE JNY_ID = '12019101100000001'";
            String tableJoinSelect = " select wg.speed as speed ,wj.JNY_ID as jnyId " + 
                    " from DATA_CENTER.WAKANDA_GPS AS  wg " + 
                    " INNER JOIN DATA_CENTER.WKD_JOURNEY wj " + 
                    " on wg.JNY_ID = wj.JNY_ID " + 
                    " WHERE wg.JNY_ID = '12019101100000001'";
            String singleTableSelectWithoutIndex = "SELECT * FROM DATA_CENTER.WAKANDA_GPS";
            PreparedStatement statement = connection.prepareStatement(singleTableSelectWithoutIndex);
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //String businessNo = resultSet.getString("business_no");
                String jnyId = resultSet.getString("JNYID");
                Float speed = resultSet.getFloat("SPEED");

                System.out.println("business_no " + jnyId + "  speed " + speed);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = null;

        try {
            //Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            Class.forName("org.apache.phoenix.queryserver.client.Driver");
            Properties properties = new Properties();
            properties.setProperty("phoenix.schema.isNamespaceMappingEnabled", "true");
            properties.setProperty("phoenix.schema.mapSystemTablesToNamespace", "true");
            properties.setProperty("testWhileIdle", "false");
            
            //connection = DriverManager.getConnection("jdbc:phoenix:192.168.1.192:2181", properties);
            connection = DriverManager.getConnection("jdbc:phoenix:192.168.1.189:2182", properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(connection == null) {
            return;
        }

        testInsert(connection);
        //testSelect(connection);
        //testCreateIndex(connection);

        try {
            connection.close();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }
}
