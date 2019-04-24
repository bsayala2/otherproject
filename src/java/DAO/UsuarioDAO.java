/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import VO.UsuarioVO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FAMILIA NOVOA
 */
public class UsuarioDAO extends Conexion{
    private String nombre;
    private String id;
    private int telefono;
    private String email;
    Connection cnn;
    boolean operacion=false;
    private Statement sentencia;
         public UsuarioDAO() 
        {
        
        }
        public UsuarioDAO(UsuarioVO usuariovo)
        {
        super();
        try 
        {
            nombre=usuariovo.getNombre();
            id=usuariovo.getId();
            telefono=usuariovo.getTelefono();
            email=usuariovo.getEmail();
        } 
         catch (Exception e) {
            Logger.getLogger(DAO.UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }      
     }
     public boolean agregar(){
         try {
             cnn=this.obtenerconexion();
             sentencia=cnn.createStatement();
             sentencia.executeUpdate("INSERT INTO usuario(nombre,id,telefono,email) VALUES('"+nombre+"','"+id+"','"+telefono+"','"+email+"')");
             operacion=true;
         } catch (Exception e) {
              Logger.getLogger(DAO.UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
         }
         return operacion;
     }
    
}
