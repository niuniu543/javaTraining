package com.train.jdbcpool;

import java.io.IOException;
import java.sql.*;

public class JdbcPool {

    public static void main(String[] arges){

        try{
            Class.forName("com.mysql.jdbc.Driver") ;
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&characterEncoding=UTF-8&useTimezone=true&serverTimezone=GMT%2B8&zeroDateTimeBehavior=convertToNull",
                    "root","123456");
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            String sql="insert into t_dict(item_code,item_name) values ('001','字典值');";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM t_dict");
            preparedStatement.executeBatch();
            con.commit();
            while(resultSet.next()){

                String pass = resultSet.getString(1) ;
                String pass2 = resultSet.getString(2) ;
                String pass3 = resultSet.getString(3) ;
                System.out.println("  pass "+pass+" pass2 "+pass2+" pass3 "+pass3);
            }
        }catch (Exception e){

            System.out.println("uuuu"+e);
        }




    }


}
