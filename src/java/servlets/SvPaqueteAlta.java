/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.PaqueteTuristico;
import logica.Servicio;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "SvPaqueteAlta", urlPatterns = {"/SvPaqueteAlta"})
public class SvPaqueteAlta extends HttpServlet {

    Controladora control = new Controladora();
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
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaPaquete", control.traerPaqueteTuristicos());
        response.sendRedirect("lista_paquetes.jsp");
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
        
        // Variables auxiliares
        List<Servicio> auxList = new ArrayList<>();
        double total = 0;
        int id;
        
        // Datos Enviados
        String nombre = request.getParameter("nombre");
        String[] servicios = request.getParameterValues("servicio");
        
        for(String servicio : servicios){
            id = Integer.parseInt(servicio);
            Servicio serv = this.control.buscarServicio(id);
            total += serv.getCosto_servicio();
            auxList.add(serv);
        }
        
        total = total-total*0.1;
        
        // Instanciar clase
        PaqueteTuristico paquete = new PaqueteTuristico(nombre, total, auxList);
        
        this.control.crearPaqueteTuristico(paquete);
        response.sendRedirect("index.jsp");
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
