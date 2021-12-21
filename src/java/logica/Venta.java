package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int num_venta;
    @Basic
    double total;
    private boolean borrar;
    @Temporal(TemporalType.DATE)
    private Date fecha_venta;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Empleado empleado;
    @ManyToOne
    private Servicio servicio;
    @ManyToOne
    private PaqueteTuristico paq_Turistico;
    @ManyToOne
    private MediosPago MedioPago;
    
    public Venta() {
    }

    public Venta(int num_venta, double total, Date fecha_venta, Cliente cliente, Empleado empleado, Servicio servicio, PaqueteTuristico paq_Turistico, MediosPago MedioPago) {
        this.num_venta = num_venta;
        this.total = total;
        this.fecha_venta = fecha_venta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
        this.paq_Turistico = paq_Turistico;
        this.MedioPago = MedioPago;
        this.borrar = false;
    }

    public Venta(Date fecha_venta, Cliente cliente, Empleado empleado, MediosPago MedioPago) {
        this.num_venta = 0;
        this.total = 0;
        this.fecha_venta = fecha_venta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = null;
        this.paq_Turistico = null;
        this.MedioPago = MedioPago;
        this.borrar = false;
    }

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public PaqueteTuristico getPaq_Turistico() {
        return paq_Turistico;
    }

    public void setPaq_Turistico(PaqueteTuristico paq_Turistico) {
        this.paq_Turistico = paq_Turistico;
    }

    public MediosPago getMedioPago() {
        return MedioPago;
    }

    public void setMedioPago(MediosPago MedioPago) {
        this.MedioPago = MedioPago;
    }
    
}
