package paqueteClientes;

/**
 * Clase que representa a un cliente invitado (no registrado)
 * Solo tiene los datos básicos necesarios para realizar una compra
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class ClienteInvitado extends Cliente {
    
    /**
     * Constructor de ClienteInvitado
     * @param correo correo electrónico del cliente
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param direccion dirección del cliente
     */
    public ClienteInvitado(String correo, String nombre, String apellidos, String direccion) {
        super(correo, nombre, apellidos, direccion);
    }
    
    /**
     * Implementación específica de dameCadena para clientes invitados
     * @return cadena formateada indicando que es un cliente invitado
     */
    @Override
    public String dameCadena() {
        return "[INVITADO] " + super.dameCadena();
    }
}