package com.wetool.datamove.core;

import com.wetool.datamove.po.Data;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class datatest {
    public static void main(String[] args){

        Connection connection = null;
        PreparedStatement preparedStatement =null;
        //数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/examtest?characterEncoding=utf-8");

        List<Data> list = new ArrayList<>();
        for (int i = 30004;i<30009;i++){
            Data data = new Data();
            data.setId(i+"");
            data.setPassword(i+"");
            data.setUsername(i+"");
            list.add(data);
        }
        System.out.println(list.size());
        int count = 0;
        String valus = "";
        for (Data data : list) {
            if(count == 0){
                valus = "('"+data.getId()+"','"+data.getUsername()+"','"+data.getPassword()+"')";
                count+=1;
            }else {
                valus = valus+",('"+data.getId()+"','"+data.getUsername()+"','"+data.getPassword()+"')";
            }
        }
        count = 0;
        System.out.println(valus);

        String LL ="好好";
        String sql = "insert into elasticsearch(id,username, password) values"+valus;
        System.out.println(sql);


       try
        {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            int i = preparedStatement.executeUpdate();
            System.out.println("成功插入"+i+"条数据");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            if(preparedStatement != null){
                try
                {
                    preparedStatement.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try
                {
                    connection.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}
