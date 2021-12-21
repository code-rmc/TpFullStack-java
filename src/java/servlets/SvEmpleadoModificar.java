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
import logica.Controladora;
import logica.Empleado;
import logica.Usuario;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "SvEmpleadoModificar", urlPatterns = {"/SvEmpleadoModificar"})
public class SvEmpleadoModificar extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        String f_nac = request.getParameter("fecha_nac");
        Date fecha_nac;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            fecha_nac = formatter.parse(f_nac);
        } catch (ParseException ex) {
            fecha_nac = null;
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        // Datos Usuario
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        Empleado emple = this.control.buscarEmpleado(id);
        emple.setNombre(nombre);
        emple.setApellido(apellido);
        emple.setDireccion(direccion);
        emple.setDni(dni);
        emple.setFecha_nac(fecha_nac);
        emple.setNacionalidad(nacionalidad);
        emple.setCelular(celular);
        emple.setEmail(email);
        emple.setCargo(cargo);
        emple.setSueldo(sueldo);
        
        Usuario usuario = this.control.buscarUsuarios(id_usuario);
        usuario.setNombre_usuario(user);
        if (pass != null) {
            usuario.setPassword(pass);
        }
        
        this.control.modificarUsuarios(usuario);
        this.control.modificarEmpleado(emple);
        
        request.getSession().setAttribute("listaEmpleados", this.control.traerEmpleados());
        response.sendRedirect("lista_empleados.jsp");        
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
        
        int id = Integer.parseInt(request.getParameter("id"));
        Empleado emple = control.buscarEmpleado(id);
        Usuario usuario = this.control.buscarUsuariosXEmpleado(id);
        HttpSession miSession = request.getSession();
        miSession.setAttribute("Empleado", emple);
        miSession.setAttribute("Datos_usuario", usuario);
        response.sendRedirect("empleado_mod.jsp");
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
