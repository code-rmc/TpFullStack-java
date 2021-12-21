package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;
import logica.Empleado;
import logica.MediosPago;
import logica.PaqueteTuristico;
import logica.Servicio;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "SvVentaAlta", urlPatterns = {"/SvVentaAlta"})
public class SvVentaAlta extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
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
        miSession.setAttribute("listaServicio", control.traerServicios());
        miSession.setAttribute("listaPaquete", control.traerPaqueteTuristicos());
        miSession.setAttribute("listaCliente", control.traerClientes());
        miSession.setAttribute("listaMediosPago", control.traerMediosPago());
        response.sendRedirect("venta.jsp");
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
        HttpSession miSession = request.getSession();
        int emple_num = (int) miSession.getAttribute("Id_Empleado");
        int clie_num = Integer.parseInt(request.getParameter("clie_num"));
        int medio_pago = Integer.parseInt(request.getParameter("medio_pago"));
        String serv_num = request.getParameter("servicio");
        String paq_num = request.getParameter("paq_num");
        String fechaStr = request.getParameter("fecha");
        Date fecha;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            fecha = formatter.parse(fechaStr);
        } catch (ParseException ex) {
            fecha = null;
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.control.crearVenta(emple_num, serv_num, paq_num, clie_num, medio_pago, fecha);
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
