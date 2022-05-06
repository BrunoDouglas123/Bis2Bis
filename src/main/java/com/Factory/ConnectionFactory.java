package com.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/desafio1", "root","brunodouglaspereira");
        }catch (SQLException exception){
            System.out.println(exception);
            throw new RuntimeException(exception);
        }
    }
}
