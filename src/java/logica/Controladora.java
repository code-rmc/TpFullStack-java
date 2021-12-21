package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ControladoraPersistencia;

public class Controladora {

    private ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    /*
    ******* Empleado *******
    */
    public void crearEmpleado(String nombre, String apellido, String direccion, String dni, String fecha_nac1, String nacionalidad, String celular, String email, String cargo, double sueldo, String usu, String pass) {
        Date fecha_nac;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            fecha_nac = formatter.parse(fecha_nac1);
        } catch (ParseException ex) {
            fecha_nac = null;
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        Empleado empleado = new Empleado(cargo, sueldo, nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
        Usuario usuario = new Usuario(usu, pass, empleado);
        this.controlPersis.crearEmpleado(empleado, usuario);
    }

    public List<Empleado> traerEmpleados() {
        return this.controlPersis.traerEmpleados();
    }
    
    public void eliminarEmpl(int id){
        this.controlPersis.borrarEmpleado(id);
    }

    public Empleado buscarEmpleado(int id) {
        return controlPersis.buscarEmpleado(id);
    }
    
    public void modificarEmpleado(Empleado emple) {
        this.controlPersis.modificarEmpleado(emple);
    }
    
    /*
    ******* Cliente *******
    */
    public void crearCliente(String nombre, String apellido, String direccion, String dni, String fecha_nac1, String nacionalidad, String celular, String email) {
        Date fecha_nac;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            fecha_nac = formatter.parse(fecha_nac1);
        } catch (ParseException ex) {
            fecha_nac = null;
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cliente cliente = new Cliente(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
        this.controlPersis.crearCliente(cliente);
    }

    public void modificarCliente(Cliente cliente) {
        this.controlPersis.modificarCliente(cliente);
    }
    
    public void eliminarCliente(int id) {
        this.controlPersis.borrarCliente(id);
    }
    
    public List<Cliente> traerClientes(){
        return this.controlPersis.traerClientes();
    }
    
    public Cliente buscarCliente(int id) {
        return this.controlPersis.buscarCliente(id);
    }
    
    /*
    ******* Servicio *******
    */
    public void crearServicio(String nombre, String descripcion, String destino, Date fecha_servicio, double costo) {
        Servicio serv = new Servicio(nombre, descripcion, destino, fecha_servicio, costo);
        this.controlPersis.crearServicio(serv);
    }

    public void eliminarServicio(int id) {
        this.controlPersis.borrarServicio(id);
    }
    
    public List<Servicio> traerServicios(){
        return this.controlPersis.traerServicios();
    }
    
    public Servicio buscarServicio(int id) {
        return this.controlPersis.buscarServicio(id);
    }
    
    /*
    ******* Paquete Turistico *******
    */
    public void crearPaqueteTuristico(PaqueteTuristico paquete) {
        this.controlPersis.crearPaqueteTuristico(paquete);
    }
    
    public void eliminarPaquete(int id) {
       this.controlPersis.borrarPaqueteTuristico(id);
    }
    
    public List<PaqueteTuristico> traerPaqueteTuristicos(){
        return this.controlPersis.traerPaqueteTuristicos();
    }
    
    public PaqueteTuristico buscarPaquete(int paq_num) {
        return this.controlPersis.buscarPaquete(paq_num);
    }
    
    /*
    ******* Medio de Pago *******
    */
    public void crearMedioPago(String medioPago, String comision1) {
        double comision = Double.parseDouble(comision1);
        MediosPago medioP = new MediosPago(medioPago, comision);
        this.controlPersis.crearMedioPago(medioP);
    }

    public void modificarMedioPago(MediosPago medioDePago) {
        this.controlPersis.modificarMedioPago(medioDePago);
    }
    
    public void eliminarMedioPago(int id) {
        this.controlPersis.borrarMedioPago(id);
    }
    
    public List<MediosPago> traerMediosPago(){
        return this.controlPersis.traerMediosPago();
    }

    public MediosPago buscarMedioPago(int medio_pago) {
        return this.controlPersis.buscarMedioPago(medio_pago);
    }
    
    /*
    ******* Usuario *******
    */
    public void modificarUsuarios(Usuario usuario) {
        this.controlPersis.modificarUsuario(usuario);
    }
    
    public Usuario buscarUsuarios(int id_usuario) {
        return this.controlPersis.buscarUsuario(id_usuario);
    }

    public Usuario buscarUsuariosXEmpleado(int id) {
        List<Usuario> usu = this.controlPersis.traerUsuarios();
        for (Usuario usuario : usu) {
            if(usuario.getEmpleado().getId_persona() == id) {
                return usuario;
            }
        }
        return null;
    }
    
    public int verificarUsuario(String user, String pass) {
        List<Usuario> usuariosList = this.controlPersis.traerUsuarios();
        if (!usuariosList.isEmpty()) {
            for (Usuario usuario : usuariosList) {
                if (usuario.getNombre_usuario().equals(user) && usuario.getPassword().equals(pass)) {
                    return usuario.getEmpleado().getId_persona();
                }
            }
        }
        return 0;
    }
    
    /*
    ******* Venta *******
    */
    public void crearVenta(int emple_num, String serv_num, String paq_num, int clie_num, int medio_pago, Date fecha) {
        Empleado emp = this.buscarEmpleado(emple_num);
        Cliente cli = this.buscarCliente(clie_num);
        MediosPago medio = this.buscarMedioPago(medio_pago);
        Venta venta = new Venta(fecha, cli, emp,  medio);
        
        if(null != serv_num) {
            int serv_numn = Integer.parseInt(serv_num);
            Servicio serv = this.buscarServicio(serv_numn);
            venta.setTotal(serv.getCosto_servicio());
            venta.setServicio(serv);
        } else {
            int paq_numn = Integer.parseInt(paq_num);
            PaqueteTuristico paq = this.buscarPaquete(paq_numn);
            venta.setTotal(paq.getCosto_paquete());
            venta.setPaq_Turistico(paq);
        }
        
        this.controlPersis.crearVenta(venta);
    }

    public void eliminarVenta(int id) {
        this.controlPersis.borrarVenta(id);
    }

    public Object traerVentas() {
        return this.controlPersis.traerVentas();
    }
    
    /*
    ******* Reporte *******
    */
    public double reporteGananciaHoy() {
        double ganancia_hoy = 0;
        
        // Formateador x Dia
        SimpleDateFormat format_dia = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_hoy = Date.from(ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant());
        
        String por_dia = format_dia.format(fecha_hoy);
        
        List<Venta> ventas = this.reporteListaVentas(por_dia, format_dia);
        
        // Recorro las ventas
        if (ventas.isEmpty()) {
            System.out.println("No hay Ventas");
            return 0;
        }
        
        for(Venta venta : ventas) {
            double comision = venta.getMedioPago().getComision();
            ganancia_hoy += venta.getTotal() - ((venta.getTotal() * comision)/100);
        }
        
        return ganancia_hoy;
    }
    
    public double reporteGananciaMes() {
        double ganancia_mes = 0;
        
        // Formato x Mes
        SimpleDateFormat format_mes = new SimpleDateFormat("yyyy-MM");
        Date fecha_hoy = Date.from(ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant());
        
        String por_mes = format_mes.format(fecha_hoy);
        
        List<Venta> ventas = this.reporteListaVentas(por_mes, format_mes);
        
        // Recorro las ventas
        if (ventas.isEmpty()) {
            System.out.println("No hay Ventas");
            return 0;
        }
        
        for(Venta venta : ventas) {
            double comision = venta.getMedioPago().getComision();
            ganancia_mes += venta.getTotal() - ((venta.getTotal() * comision)/100);
        }
        
        return ganancia_mes;
    }
    
    public List<Venta> reporteListaVentas(String fecha_comparar, SimpleDateFormat format){
            //Almacena las ventas de hoy
        List<Venta> venta_fecha = new ArrayList<>();
        
        List<Venta> ventas = this.controlPersis.traerVentas();
        
        // Recorro las ventas
        if (ventas.isEmpty()) {
            System.out.println("No hay Ventas");
            return venta_fecha;
        }
        
        for(Venta venta : ventas) {
            Date fecha_venta = venta.getFecha_venta();
            // Comparo las fechas del Mes
            if (fecha_comparar.equals(format.format(fecha_venta))) {
                venta_fecha.add(venta);
            }
        }
        
        return venta_fecha;
    }

    public int reporteTotalServicios() {
        return this.controlPersis.traerServicios().size();
    }

    public int reporteTotalClientes() {
        return this.controlPersis.traerClientes().size();
    }
}
