package com.company;

import java.sql.*;
import java.util.List;

public class MyThread extends Thread {
    private List<DocumentEntity> list;
    public MyThread (List<DocumentEntity> list){
        this.list=list;
    }

    @Override
    public void run() {
        try {
            storeData(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void storeData(List<DocumentEntity> list) throws SQLException, ClassNotFoundException {
        Connection connection;
        PreparedStatement preparedStatement;
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "ariya", "myjava123");
        for (DocumentEntity entity:list){
        preparedStatement=connection.prepareStatement ("INSERT INTO archive(id, title, context) VALUES (?,?,?)");
        preparedStatement.setInt (1,entity.getId());
        preparedStatement.setString (2,entity.getTitle());
        preparedStatement.setString (3,entity.getContext());
        preparedStatement.executeUpdate ();}
    }

}
