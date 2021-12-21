package logica;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MediosPago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_medio;
    @Basic
    private String medioPago;
    private double comision;
    private boolean borrar;
    @OneToMany
    private List<Venta> lista_venta;

    public MediosPago() {
    }

    public MediosPago(int id_medio, String medioPago, double comision, List<Venta> lista_venta) {
        this.id_medio = id_medio;
        this.medioPago = medioPago;
        this.comision = comision;
        this.lista_venta = lista_venta;
        this.borrar = false;
    }

    public MediosPago(String medioPago, double comision) {
        this.id_medio = 0;
        this.medioPago = medioPago;
        this.comision = comision;
        this.lista_venta = null;
        this.borrar = false;
    }

    public int getId_medio() {
        return id_medio;
    }

    public void setId_medio(int id_medio) {
        this.id_medio = id_medio;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
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
    
}
