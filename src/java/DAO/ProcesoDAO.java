/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import VO.ProcesoVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FAMILIA NOVOA
 */
public class ProcesoDAO extends Conexion{
    private String id;
    public String servicio;
    public int numeroequipos;
    public int numerodias;
    public int diasadicionales;
    public double valoralquiler;
    public double valordiasadicionales;
    public double descuentos;
    public double totalapagar;
    public double valordomicilio;
    private Connection cnn;
    private Statement sentencia;
    private ResultSet rs;
    private boolean operacion=false;
    public ProcesoDAO() {
        
    }
    public ProcesoDAO(ProcesoVO procesovo) {
           super();
        try {
           id=procesovo.getId();
        servicio=procesovo.getServicio();
        numeroequipos=procesovo.getNumeroequipos();
        numerodias=procesovo.getNumerodias();
        diasadicionales=procesovo.getDiasadicionales();
        } catch (Exception e) {
            Logger.getLogger(DAO.ProcesoDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
    }
    public double valoralquiler(){
    return (numerodias*35.000)*numeroequipos;
    }  
    public double valordomicilio(){
    return (valoralquiler()*5)/100;
    }
    public double descuento(){
     return (valoralquiler()*5)/100;   
    }
    public double valordiaadicionales(){
     return ((valoralquiler()*2)/100)*diasadicionales;
    }
    public boolean agregar(){
       valoralquiler=valoralquiler();
       valordiasadicionales=valordiaadicionales();
        if(servicio.equals("Dentro de la ciudad")){
       descuentos=0;
       valordomicilio=0;
       totalapagar=valoralquiler+valordiasadicionales+descuentos+valordomicilio;
       }
       if(servicio.equals("Fuera de la ciudad")){
       descuentos=0;
       valordomicilio=valordomicilio();
       totalapagar=valoralquiler+valordiasadicionales+descuentos+valordomicilio;
       }
       if(servicio.equals("Dentro del establecimiento")){
       descuentos=descuento();
       valordomicilio=0;
       totalapagar=valoralquiler+valordiasadicionales+descuentos+valordomicilio;
       }
//       lista.add(servicio);
//       lista.add(numeroequipos);
//       lista.add(numerodias);
//       lista.add(diasadicionales);
//       lista.add(valoralquiler);
//       lista.add(valordiasadicionales);
//       lista.add(descuentos);
//       lista.add(valordomicilio);
//       lista.add(totalapagar);
        try {
            cnn=this.obtenerconexion();
            sentencia=cnn.createStatement();
            sentencia.executeUpdate("INSERT INTO proceso(id,servicio,numeroequipos,numerodias,diasadicionales,valoralquiler,valordiasadicionales,descuentos,valordomicilio,totalapagar)"
             + "VALUES('"+id+"','"+servicio+"','"+numeroequipos+"','"+numerodias+"','"+diasadicionales+"','"+valoralquiler+"','"+valordiasadicionales+"','"+descuentos+"','"+valordomicilio+"','"+totalapagar+"')");
            operacion=true;
        } catch (Exception e) {
             Logger.getLogger(DAO.ProcesoDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return operacion;
    }
    public ArrayList<ProcesoVO> consulta(String id){
       ArrayList<ProcesoVO> lista=new ArrayList();
        try {
            ProcesoVO procesovo=new ProcesoVO();
            cnn=this.obtenerconexion();
            sentencia=cnn.createStatement();
            rs=sentencia.executeQuery("SELECT * FROM proceso WHERE id='"+id+"' ");
            while(rs.next()){
                procesovo.setValoralquiler(rs.getDouble("valoralquiler"));
                procesovo.setValordiasadicionales(rs.getDouble("valordiasadicionales"));
                procesovo.setDescuentos(rs.getDouble("descuentos"));
                procesovo.setValordomicilio(rs.getDouble("valordomicilio"));
                procesovo.setTotalapagar(rs.getDouble("totalapagar"));
                lista.add(procesovo);
                
            }
        } catch (Exception e) {
             Logger.getLogger(DAO.ProcesoDAO.class.getName()).log(Level.SEVERE,null,e);
        }
     return lista;
    }
    
   
       
//        try {
//          ProcesoVO proceso=new ProcesoVO();
//   
//            cnn=this.obtenerconexion();
//            sentencia=cnn.createStatement();
//           rs=sentencia.executeQuery("SELECT * FROM proceso");
//            while (rs.next()) {  
//                 
//                id=rs.getString("id");
//                servicio=rs.getString("servicio");
//                numeroequipos=rs.getInt("numeroequipos");
//                numerodias=rs.getInt("numerodias");
//                diasadicionales=rs.getInt("diasadicionales");
//                valoralquiler=rs.getDouble("valoralquiler");
//                valordiasadicionales=rs.getDouble("valordiasadicionales");
//                descuentos=rs.getDouble("descuentos");
//                valordomicilio=rs.getDouble("valordomicilio");
//                totalapagar=rs.getDouble("totalapagar");
//                proceso.setId(id);
//                proceso.setServicio(servicio);
//                proceso.setNumeroequipos(numeroequipos);
//                proceso.setNumerodias(numerodias);
//                proceso.setDiasadicionales(diasadicionales);
//                proceso.setValoralquiler(valoralquiler);
//                proceso.setValordiasadicionales(valordiasadicionales);
//                proceso.setDescuentos(descuentos);
//                proceso.setValordomicilio(valordomicilio);
//                proceso.setTotalapagar(totalapagar);
//                lista.add(proceso);
//            }
//        } catch (SQLException ex) {
//             Logger.getLogger(ProcesoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    return lista;
//    
//    }
       
    
    
    
}
