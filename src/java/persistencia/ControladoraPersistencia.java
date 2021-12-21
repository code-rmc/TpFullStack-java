
package persistencia;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.MediosPago;
import logica.PaqueteTuristico;
import logica.Servicio;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {

    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    ClienteJpaController cliJPA = new ClienteJpaController();
    MediosPagoJpaController mediJPA = new MediosPagoJpaController();
    ServicioJpaController servJPA = new ServicioJpaController();
    PaqueteTuristicoJpaController paqTurJPA = new PaqueteTuristicoJpaController();
    VentaJpaController ventJPA = new VentaJpaController();
    
    /*
    ******* Empleado ABML *******
    */
    public void crearEmpleado(Empleado empleado, Usuario usuario) {
        try {
            this.empleJPA.create(empleado);
            this.usuJPA.create(usuario);
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void modificarEmpleado(Empleado emple) {
        try {
            this.empleJPA.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarEmpleado(int id){
        Empleado empleado = empleJPA.findEmpleado(id);
        empleado.setBorrar(true);
        this.modificarEmpleado(empleado);
    }
    
    public List<Empleado> traerEmpleados() {
        List<Empleado> empleadosB = new ArrayList<>();
        List<Empleado> empleados = this.empleJPA.findEmpleadoEntities();
        empleados.stream().filter((empleado) -> (empleado.isBorrar() == false)).forEachOrdered(empleadosB::add);
        return empleadosB;
    }
    
    public Empleado buscarEmpleado(int id) {
        return empleJPA.findEmpleado(id);
    }
    
    /*
    ******* Cliente ABML *******
    */
    public void crearCliente(Cliente cliente) {
        try {
            this.cliJPA.create(cliente);
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void modificarCliente(Cliente cliente) {
        try {
            this.cliJPA.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarCliente(int id) {
        Cliente cliente = this.cliJPA.findCliente(id);
        cliente.setBorrar(true);
        this.modificarCliente(cliente);
    }
    
    public List<Cliente> traerClientes() {
        List<Cliente> clientesB = new ArrayList<>();
        List<Cliente> clientes = this.cliJPA.findClienteEntities();
        clientes.stream().filter((cliente) -> (cliente.isBorrar() == false)).forEachOrdered(clientesB::add);
        return clientesB;
    }
    
    public Cliente buscarCliente(int id) {
        return this.cliJPA.findCliente(id);
    }
    
    /*
    ******* Medio de Pago ABML *******
    */
    public void crearMedioPago(MediosPago medioP) {
        try {
            this.mediJPA.create(medioP);
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void borrarMedioPago(int id) {
        MediosPago medioDePago = this.mediJPA.findMediosPago(id);
        medioDePago.setBorrar(true);
        this.modificarMedioPago(medioDePago);
    }
    
    public void modificarMedioPago(MediosPago medioDePago) {
        try {
            this.mediJPA.edit(medioDePago);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<MediosPago> traerMediosPago() {
        List<MediosPago> mediosPagoB = new ArrayList<>();
        List<MediosPago> mediosDePago = this.mediJPA.findMediosPagoEntities();
        mediosDePago.stream().filter((medioDePago) -> (medioDePago.isBorrar() == false)).forEachOrdered(mediosPagoB::add);
        return mediosPagoB;
    }

    
    public MediosPago buscarMedioPago(int medio_pago) {
        return this.mediJPA.findMediosPago(medio_pago);
    }
    
    /*
    ******* Servicio ABML *******
    */
    public void crearServicio(Servicio serv) {
            this.servJPA.create(serv);
        
    }
    
    public void borrarServicio(int id) {
        Servicio servicio = this.servJPA.findServicio(id);
        servicio.setBorrar(true);
        this.modificarServicio(servicio);
    }
    
    public void modificarServicio(Servicio servicio) {
        try {
            this.servJPA.edit(servicio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Servicio> traerServicios() {
        List<Servicio> servicioB = new ArrayList<>();
        List<Servicio> servicios = this.servJPA.findServicioEntities();
        servicios.stream().filter((servicio) -> (servicio.isBorrar() == false)).forEachOrdered(servicioB::add);
        return servicioB;
    }
    
    public Servicio buscarServicio(int id) {
        return this.servJPA.findServicio(id);
    }
    /*
    ******* Paquete Turistico ABML *******
    */
    public void crearPaqueteTuristico(PaqueteTuristico paquete) {
        this.paqTurJPA.create(paquete);
    }
    
    public void borrarPaqueteTuristico(int id) {
        PaqueteTuristico paqueteTuristico = this.paqTurJPA.findPaqueteTuristico(id);
        paqueteTuristico.setBorrar(true);
        this.modificarPaqueteTuristico(paqueteTuristico);
    }
    
    public void modificarPaqueteTuristico(PaqueteTuristico paqueteTuristico) {
        try {
            this.paqTurJPA.edit(paqueteTuristico);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<PaqueteTuristico> traerPaqueteTuristicos() {
        List<PaqueteTuristico> paquetesTuristicoB = new ArrayList<>();
        List<PaqueteTuristico> paquetesTuristico = this.paqTurJPA.findPaqueteTuristicoEntities();
        paquetesTuristico.stream().filter((paqueteTuristico) -> (paqueteTuristico.isBorrar() == false)).forEachOrdered(paquetesTuristicoB::add);
        return paquetesTuristicoB;
    }    

    public PaqueteTuristico buscarPaquete(int paq_num) {
        return this.paqTurJPA.findPaqueteTuristico(paq_num);
    }

    /*
    ******* Venta ABML *******
    */
    public void crearVenta(Venta venta) {
        this.ventJPA.create(venta);
    }
    
    public void borrarVenta(int id) {
        Venta venta = this.ventJPA.findVenta(id);
        venta.setBorrar(true);
        this.modificarVenta(venta);
    }
    
    public void modificarVenta(Venta venta) {
        try {
            this.ventJPA.edit(venta);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Venta> traerVentas() {
        List<Venta> ventasB = new ArrayList<>();
        List<Venta> ventas = this.ventJPA.findVentaEntities();
        ventas.stream().filter((venta) -> (venta.isBorrar() == false)).forEachOrdered(ventasB::add);
        return ventasB;
    }

    /*
    ******* Usuario ABML *******
    */
    public void borrarUsuario(int id) {
        Usuario usuario = this.usuJPA.findUsuario(id);
        usuario.setBorrar(true);
        this.modificarUsuario(usuario);
    }
    
    public void modificarUsuario(Usuario usuario) {
        try {
            this.usuJPA.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Usuario> traerUsuarios() {
        List<Usuario> usuariosB = new ArrayList<>();
        List<Usuario> usuarios = this.usuJPA.findUsuarioEntities();
        usuarios.stream().filter((usuario) -> (usuario.isBorrar() == false)).forEachOrdered(usuariosB::add);
        return usuariosB;
    }

    public Usuario buscarUsuario(int id) {
        return this.usuJPA.findUsuario(id);
    }

    
}
