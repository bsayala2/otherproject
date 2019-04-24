/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ProcesoDAO;
import DAO.UsuarioDAO;
import VO.ProcesoVO;
import VO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FAMILIA NOVOA
 */
@WebServlet(name = "Proceso", urlPatterns = {"/Proceso"})
public class Proceso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nombre=request.getParameter("nombre");
            String id=request.getParameter("id");
            int telefono=Integer.parseInt(request.getParameter("telefono"));
            String email=request.getParameter("email");
            String servicio =request.getParameter("servicio");
            int numeroequipos=Integer.parseInt(request.getParameter("numeroequipos"));
            int numerodias=Integer.parseInt(request.getParameter("numerodias"));
            int numerodiasadicionales=Integer.parseInt(request.getParameter("diasadicionales"));
            UsuarioVO usuariovo=new UsuarioVO(nombre,id,telefono,email);
            UsuarioDAO usuariodao=new UsuarioDAO(usuariovo);
            ProcesoVO procesovo=new ProcesoVO(id,servicio, numeroequipos, numerodias, numerodiasadicionales);
            ProcesoDAO procesodao=new ProcesoDAO(procesovo);
            usuariodao.agregar();
            procesodao.agregar();
            procesodao.consulta(id);
           request.setAttribute("nombre",nombre);
           request.setAttribute("id", id);
           request.setAttribute("telefono",telefono);
           request.setAttribute("email",email);
           request.setAttribute("servicio",servicio);
           request.setAttribute("numeroequipos",numeroequipos);
           request.setAttribute("numerodias",numerodias);
           request.setAttribute("numerodiasadicionales",numerodiasadicionales);
          for(int i=0;i<procesodao.consulta(id).size();i++){
              procesovo=procesodao.consulta(id).get(i);
          }
           request.setAttribute("valoralquiler",procesovo.getValoralquiler());
           request.setAttribute("valordiasadicionales",procesovo.getValordiasadicionales());
           request.setAttribute("descuentos",procesovo.getDescuentos());
           request.setAttribute("valordomicilio",procesovo.getValordomicilio());
           request.setAttribute("totalapagar",procesovo.getTotalapagar());
           request.getRequestDispatcher("factura.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
