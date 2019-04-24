/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author FAMILIA NOVOA
 */
public class ProcesoVO {
    private String id;
    private String servicio;
    private int numeroequipos;
    private int numerodias;
    private int diasadicionales;
    private double valoralquiler;
    private double valordiasadicionales;
    private double descuentos;
    private double totalapagar;
    private double valordomicilio;
    public ProcesoVO() {
    }

    public ProcesoVO(String id, String servicio, int numeroequipos, int numerodias, int diasadicionales) {
        this.id = id;
        this.servicio = servicio;
        this.numeroequipos = numeroequipos;
        this.numerodias = numerodias;
        this.diasadicionales = diasadicionales;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getNumeroequipos() {
        return numeroequipos;
    }

    public void setNumeroequipos(int numeroequipos) {
        this.numeroequipos = numeroequipos;
    }

    public int getNumerodias() {
        return numerodias;
    }

    public void setNumerodias(int numerodias) {
        this.numerodias = numerodias;
    }

    public int getDiasadicionales() {
        return diasadicionales;
    }

    public void setDiasadicionales(int diasadicionales) {
        this.diasadicionales = diasadicionales;
    }

    public double getValoralquiler() {
        return valoralquiler;
    }

    public void setValoralquiler(double valoralquiler) {
        this.valoralquiler = valoralquiler;
    }

    public double getValordiasadicionales() {
        return valordiasadicionales;
    }

    public void setValordiasadicionales(double valordiasadicionales) {
        this.valordiasadicionales = valordiasadicionales;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public double getTotalapagar() {
        return totalapagar;
    }

    public void setTotalapagar(double totalapagar) {
        this.totalapagar = totalapagar;
    }

    public double getValordomicilio() {
        return valordomicilio;
    }

    public void setValordomicilio(double valordomicilio) {
        this.valordomicilio = valordomicilio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
