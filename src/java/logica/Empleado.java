package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Empleado extends Persona implements Serializable{
    @Basic
    private String cargo;
    private double sueldo;
    private boolean borrar;
    @OneToMany
    private List<Venta> lista_venta;
    
    public Empleado() {
    }

    public Empleado(String cargo, double sueldo, List<Venta> lista_venta, int id_persona, String nombre, String apellido, String direccion, String dni, Date fecha_nac, String nacionalidad, String celular, String email) {
        super(id_persona, nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.lista_venta = lista_venta;
        this.borrar = false;
    }

    public Empleado(String cargo, double sueldo, String nombre, String apellido, String direccion, String dni, Date fecha_nac, String nacionalidad, String celular, String email) {
        super(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.lista_venta = null;
        this.borrar = false;
    }
                            
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public List<Venta> getLista_venta() {
        return lista_venta;
    }

    public void setLista_venta(List<Venta> lista_venta) {
        this.lista_venta = lista_venta;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    @Override
    public void setId_persona(int id_persona) {
        super.setId_persona(id_persona); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId_persona() {
        return super.getId_persona(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public Date getFecha_nac() {
        return fecha_nac;
    }

    @Override
    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String getCelular() {
        return celular;
    }

    @Override
    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
  
}
