package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class PaqueteTuristico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo_paquete;
    @Basic
    private String nombre;
    private double costo_paquete;
    private boolean borrar;
    @ManyToMany
    private List<Servicio> lista_servicios_incluidos;
    @OneToMany
    private List<Venta> lista_venta;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int codigo_paquete, String nombre, double costo_paquete, List<Servicio> lista_servicios_incluidos, List<Venta> lista_venta) {
        this.codigo_paquete = codigo_paquete;
        this.nombre = nombre;
        this.costo_paquete = costo_paquete;
        this.lista_servicios_incluidos = lista_servicios_incluidos;
        this.lista_venta = lista_venta;
        this.borrar = false;
    }

    public PaqueteTuristico(String nombre, double costo_paquete, List<Servicio> lista_servicios_incluidos) {
        this.codigo_paquete = 0;
        this.nombre = nombre;
        this.costo_paquete = costo_paquete;
        this.lista_servicios_incluidos = lista_servicios_incluidos;
        this.borrar = false;
    }

    public int getCodigo_paquete() {
        return codigo_paquete;
    }

    public void setCodigo_paquete(int codigo_paquete) {
        this.codigo_paquete = codigo_paquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getCosto_paquete() {
        return costo_paquete;
    }

    public void setCosto_paquete(double costo_paquete) {
        this.costo_paquete = costo_paquete;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    public List<Servicio> getLista_servicios_incluidos() {
        return lista_servicios_incluidos;
    }

    public void setLista_servicios_incluidos(List<Servicio> lista_servicios_incluidos) {
        this.lista_servicios_incluidos = lista_servicios_incluidos;
    }
    
    public List<Venta> getLista_venta() {
        return lista_venta;
    }

    public void setLista_venta(List<Venta> lista_venta) {
        this.lista_venta = lista_venta;
    }

}
