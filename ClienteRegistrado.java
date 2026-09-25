package paqueteClientes;

import java.util.ArrayList;

/**
 * Clase que representa a un cliente registrado en la tienda
 * Tiene información adicional como contraseña, fecha de nacimiento,
 * historial de pedidos, formas de pago y direcciones guardadas
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class ClienteRegistrado extends Cliente {
	    
	    // Atributos específicos de cliente registrado
	    private String password;
	    private String fechaNacimiento;
	    private ArrayList<Object> pedidosRealizados;    // TODO: Cambiar a ArrayList<Pedido>
	    private ArrayList<Object> formasPago;           // TODO: Cambiar a ArrayList<MetodoPago>
	    private ArrayList<String> direccionesEnvio;
	    
	    /**
	     * Constructor de ClienteRegistrado
	     * @param correo correo electrónico del cliente
	     * @param nombre nombre del cliente
	     * @param apellidos apellidos del cliente
	     * @param direccion dirección principal del cliente
	     * @param password contraseña del cliente
	     * @param fechaNacimiento fecha de nacimiento (DD/MM/AAAA)
	     */
	    public ClienteRegistrado(String correo, String nombre, String apellidos, 
	                            String direccion, String password, String fechaNacimiento) {
	        super(correo, nombre, apellidos, direccion);
	        this.password = password;
	        this.fechaNacimiento = fechaNacimiento;
	        this.pedidosRealizados = new ArrayList<>();
	        this.formasPago = new ArrayList<>();
	        this.direccionesEnvio = new ArrayList<>();
	        
	        // Agregar la dirección principal a la lista de direcciones
	        this.direccionesEnvio.add(direccion);
	    }
	    
	    // Getters y Setters
	    public String getPassword() {
	        return password;
	    }
	    
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    public String getFechaNacimiento() {
	        return fechaNacimiento;
	    }
	    
	    public void setFechaNacimiento(String fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }
	    
	    public ArrayList<Object> getPedidosRealizados() {
	        return pedidosRealizados;
	    }
	    
	    public ArrayList<Object> getFormasPago() {
	        return formasPago;
	    }
	    
	    public ArrayList<String> getDireccionesEnvio() {
	        return direccionesEnvio;
	    }
	    
	    /**
	     * Valida si la contraseña proporcionada es correcta
	     * @param password contraseña a validar
	     * @return true si la contraseña es correcta
	     */
	    public boolean validarPassword(String password) {
	        return this.password.equals(password);
	    }
	    
	    /**
	     * Agrega un pedido al historial del cliente
	     * @param pedido pedido a agregar
	     */
	    public void agregarPedido(Object pedido) {  // TODO: Cambiar a Pedido
	        this.pedidosRealizados.add(pedido);
	    }
	    
	    /**
	     * Agrega una forma de pago a las formas guardadas
	     * @param metodoPago método de pago a agregar
	     */
	    public void agregarFormaPago(Object metodoPago) {  // TODO: Cambiar a MetodoPago
	        this.formasPago.add(metodoPago);
	    }
	    
	    /**
	     * Agrega una dirección de envío a las direcciones guardadas
	     * @param direccion dirección a agregar
	     */
	    public void agregarDireccionEnvio(String direccion) {
	        if (!this.direccionesEnvio.contains(direccion)) {
	            this.direccionesEnvio.add(direccion);
	        }
	    }
	    
	    /**
	     * Devuelve el número de pedidos realizados por el cliente
	     * @return número de pedidos
	     */
	    public int getNumeroPedidos() {
	        return pedidosRealizados.size();
	    }
	    
	    /**
	     * Implementación específica de dameCadena para clientes registrados
	     * Muestra información adicional sobre el cliente
	     * @return cadena formateada con toda la información del cliente
	     */
	    @Override
	    public String dameCadena() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("[REGISTRADO] ").append(super.dameCadena());
	        sb.append("\n   Fecha de nacimiento: ").append(fechaNacimiento);
	        sb.append("\n   Pedidos realizados: ").append(getNumeroPedidos());
	        sb.append("\n   Formas de pago guardadas: ").append(formasPago.size());
	        sb.append("\n   Direcciones guardadas: ").append(direccionesEnvio.size());
	        return sb.toString();
	    }
	    
	    /**
	     * Método estático para obtener una lista de usuarios registrados de prueba
	     * Este método simula la carga de datos desde una base de datos
	     * @return ArrayList con usuarios de prueba
	     */
	    public static ArrayList<ClienteRegistrado> obtenerElementos() {
	        ArrayList<ClienteRegistrado> usuarios = new ArrayList<>();
	        
	        // Crear 5 usuarios de prueba
	        usuarios.add(new ClienteRegistrado(
	            "juan.perez@gmail.com",
	            "Juan",
	            "Pérez García",
	            "Calle Mayor 123, 28001 Madrid",
	            "pass123",
	            "15/05/1990"
	        ));
	        
	        usuarios.add(new ClienteRegistrado(
	            "maria.lopez@hotmail.com",
	            "María",
	            "López Martínez",
	            "Av. Constitución 45, 41001 Sevilla",
	            "maria456",
	            "22/08/1985"
	        ));
	        
	        usuarios.add(new ClienteRegistrado(
	            "carlos.ruiz@yahoo.es",
	            "Carlos",
	            "Ruiz Fernández",
	            "Rambla Catalunya 78, 08008 Barcelona",
	            "carlos789",
	            "10/12/1992"
	        ));
	        
	        usuarios.add(new ClienteRegistrado(
	            "ana.garcia@outlook.com",
	            "Ana",
	            "García Sánchez",
	            "Gran Vía 234, 46002 Valencia",
	            "ana2023",
	            "03/03/1988"
	        ));
	        
	        usuarios.add(new ClienteRegistrado(
	            "pedro.martin@gmail.com",
	            "Pedro",
	            "Martín Rodríguez",
	            "Calle Real 56, 03001 Alicante",
	            "pedro321",
	            "28/11/1995"
	        ));
	        
	        return usuarios;
	    }
}
