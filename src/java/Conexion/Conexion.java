/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

/**
 *
 * @author FAMILIA NOVOA
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexion {
    public String driver,url,user,password,bd;
    public Connection cnn;
    
    public Conexion(){
    driver="com.mysql.jdbc.Driver";
    user="root";
    password="";
    bd="calidad";
    url="jdbc:mysql://localhost:3306/"+bd;
        try {
            Class.forName(driver).newInstance();
            cnn=DriverManager.getConnection(url, user, password);
            System.out.println("CONEXION OK ");
        } catch (Exception e) {
            System.out.println("ERROR AL CONECTAR" + e);
        }

    }
    public Connection obtenerconexion(){
      return cnn;
    }
    public Connection cerrarconexion() throws SQLException{
        cnn.close();
        cnn=null;
        return cnn;
    }
    public static void main(String[] args) {
       new Conexion();
    }
    
}
