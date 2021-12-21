package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo_servicio;
    @Basic
    private String nombre;
    private String descripcion_breve;
    private String destino_servicio;
    @Temporal(TemporalType.DATE)
    private Date fecha_servicio;
    private double costo_servicio;
    private boolean borrar;
    @OneToMany
    private List<Venta> lista_venta;
    @ManyToMany
    private List<PaqueteTuristico> lista_paquete;

    public Servicio() {
    }

    public Servicio(int codigo_servicio, String nombre, String descripcion_breve, String destino_servicio, Date fecha_servicio, double costo_servicio, List<Venta> lista_venta, List<PaqueteTuristico> lista_paquete) {
        this.codigo_servicio = codigo_servicio;
        this.nombre = nombre;
        this.descripcion_breve = descripcion_breve;
        this.destino_servicio = destino_servicio;
        this.fecha_servicio = fecha_servicio;
        this.costo_servicio = costo_servicio;
        this.lista_venta = lista_venta;
        this.lista_paquete = lista_paquete;
        this.borrar = false;
    }

    public Servicio(String nombre, String descripcion_breve, String destino_servicio, Date fecha_servicio, double costo_servicio) {
        this.codigo_servicio = 0;
        this.nombre = nombre;
        this.descripcion_breve = descripcion_breve;
        this.destino_servicio = destino_servicio;
        this.fecha_servicio = fecha_servicio;
        this.costo_servicio = costo_servicio;
        this.borrar = false;
    }

    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(int codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion_breve() {
        return descripcion_breve;
    }

    public void setDescripcion_breve(String descripcion_breve) {
        this.descripcion_breve = descripcion_breve;
    }

    public String getDestino_servicio() {
        return destino_servicio;
    }

    public void setDestino_servicio(String destino_servicio) {
        this.destino_servicio = destino_servicio;
    }

    public Date getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(Date fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public double getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(double costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    public List<Venta> getLista_venta() {
        return lista_venta;
    }

    public void setLista_venta(List<Venta> lista_venta) {
        this.lista_venta = lista_venta;
    }

    public List<PaqueteTuristico> getLista_paquete() {
        return lista_paquete;
    }

    public void setLista_paquete(List<PaqueteTuristico> lista_paquete) {
        this.lista_paquete = lista_paquete;
    }
    
}
