package paqueteClientes;

import Pantallas.iMostrable;

/**
 * Clase abstracta que representa a un cliente de la tienda
 * Clase padre de ClienteRegistrado y ClienteInvitado
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public abstract class Cliente implements iMostrable {
    
    // Atributos comunes a todos los clientes
    protected String correo;
    protected String nombre;
    protected String apellidos;
    protected String direccion;
    
    /**
     * Constructor de Cliente
     * @param correo correo electrónico del cliente
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param direccion dirección del cliente
     */
    public Cliente(String correo, String nombre, String apellidos, String direccion) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }
    
    // Getters y Setters
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Devuelve el nombre completo del cliente
     * @return nombre completo (nombre + apellidos)
     */
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }
    
    /**
     * Implementación de IMostrable
     * Devuelve una cadena con la información básica del cliente
     * @return cadena formateada con los datos del cliente
     */
    @Override
    public String dameCadena() {
        return "Cliente: " + getNombreCompleto() + 
               " | Correo: " + correo + 
               " | Dirección: " + direccion;
    }
}