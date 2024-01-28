
package com.pack.varotrafiaraoccasion.Work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPostgres{

 public ConnectionPostgres(){}

 public Connection getconnexion(){
    try {
        String url = "jdbc:postgresql://viaduct.proxy.rlwy.net:25707/railway";
        String username = "postgres";
        String password = "31516fe344-5d-2b4bAEA-C2--5CG*E*";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return null;
    
 }

}