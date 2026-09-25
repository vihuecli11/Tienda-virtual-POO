package paquetePrincipal;

import java.util.Scanner;
import java.util.ArrayList;
import paqueteClientes.Cliente;
import paqueteClientes.ClienteRegistrado;
import paqueteClientes.ClienteInvitado;
import Productos.DiscodeMusica;
import Productos.Producto; 
import Productos.Alimentacion;
import Productos.Libro;
import paquetePagos.*; 

/**
 * Clase que gestiona la lógica de la Tienda Virtual
 */
public class TiendaVirtual {
    
    private Scanner scanner;
    private Cliente clienteActual;
    private ArrayList<ClienteRegistrado> usuariosRegistrados;
    private ArrayList<Producto> cestaCompra; 
    
    /**
     * Constructor de TiendaVirtual
     */
    public TiendaVirtual() {
        this.scanner = new Scanner(System.in);
        this.usuariosRegistrados = ClienteRegistrado.obtenerElementos();
        this.cestaCompra = new ArrayList<>();
    }
    
    /**
     * Muestra el mensaje de bienvenida e inicia la aplicación
     */
    public void iniciarBienvenida() {
        mostrarBienvenida();
        iniciar();
    }

    /**
     * Método público que inicia la aplicación y gestiona el menú principal
     */
    public void iniciar() {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenuPrincipal();
            String opcion = leerOpcion();
            
            switch (opcion.toUpperCase()) {
                case "R":
                    System.out.println("Has elegido: Usuario registrado");
                    loginUsuarioRegistrado();
                    break;
                case "A":
                    System.out.println("Has elegido: Alta de usuario");
                    registrarNuevoUsuario();
                    break;
                case "I":
                    System.out.println("Has elegido: Usuario invitado");
                    entradaComoInvitado();
                    break;
                case "S":
                    salir = true;
                    System.out.println("\n¡Gracias por visitar nuestra tienda! Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Lee una opción introducida por el usuario desde el scanner
     * @return la cadena de texto introducida sin espacios al inicio ni al final
     */
    private String leerOpcion() {
        return scanner.nextLine().trim();
    }
    
    /**
     * Muestra el mensaje de bienvenida de la tienda virtual
     */
    private void mostrarBienvenida() {
        System.out.println("/*********************************************/");
        System.out.println("/********** TIENDA VIRTUAL POO ***************/");
        System.out.println("/*********************************************/");
        System.out.println();
    }

    /**
     * Muestra las opciones del menú principal de acceso
     */
    private void mostrarMenuPrincipal() {
        System.out.println("-----------------------------------");
        System.out.println("(R) Usuario registrado");
        System.out.println("(A) Alta de usuario");
        System.out.println("(I) Usuario invitado");
        System.out.println("(S) Salir: Saldrá del programa");
        System.out.println("-----------------------------------");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Gestiona el menú de búsqueda de productos por categorías
     */
    private void buscarProducto() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- BÚSQUEDA DE PRODUCTOS ---");
            System.out.println("(1) Alimentación");
            System.out.println("(2) Libros");
            System.out.println("(3) Discos de música");
            System.out.println("(V) Volver al menú anterior");
            System.out.print("Seleccione tipo de producto: ");
            String opcion = leerOpcion().toUpperCase();

            switch (opcion) {
                
                case "1":
                	menuBusquedaAlimentacion();
                	break;
                case "2":
                    menuBusquedaLibros();
                    break;
                case "3":
                    menuBusquedaDiscos();
                    break;
                case "V":
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
     * Muestra el listado de discos disponibles y permite añadirlos a la cesta de compra
     */
    private void menuBusquedaDiscos() {
        ArrayList<DiscodeMusica> listaDiscos = DiscodeMusica.obtenerElementos();
        
        System.out.println("\n--- LISTADO DE DISCOS DISPONIBLES ---");
        System.out.println("ID\tDATOS DEL DISCO");
        for (int i = 0; i < listaDiscos.size(); i++) {
            System.out.println((i + 1) + ".\t" + listaDiscos.get(i).dameCadena());
        }
        System.out.println("0.\tCancelar y volver");
        
        System.out.print("\nSeleccione el número del disco que desea: ");
        try {
            int seleccion = Integer.parseInt(leerOpcion());
            
            if (seleccion > 0 && seleccion <= listaDiscos.size()) {
                DiscodeMusica discoElegido = listaDiscos.get(seleccion - 1);
                
                System.out.print("¿Cuántas unidades desea comprar?: ");
                int cantidad = Integer.parseInt(leerOpcion());
                
                if (cantidad > 0) {
                    for (int i = 0; i < cantidad; i++) {
                        this.cestaCompra.add(discoElegido);
                    }
                    System.out.println("¡Añadido correctamente a la cesta!");
                } else {
                    System.out.println("Cantidad no válida.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor, introduzca un número válido.");
        }
    }
    
    /**
     * Muestra el listado de productos de alimentación y permite añadirlos a la cesta
     */
    private void menuBusquedaAlimentacion() {
        ArrayList<Alimentacion> listaAli = Alimentacion.obtenerElementos();
        
        System.out.println("\n--- PRODUCTOS DE ALIMENTACIÓN ---");
        for (int i = 0; i < listaAli.size(); i++) {
            System.out.println((i + 1) + ".\t" + listaAli.get(i).dameCadena());
        }
        System.out.println("0.\tCancelar");
        
        System.out.print("\nSeleccione el producto: ");
        try {
            int seleccion = Integer.parseInt(leerOpcion());
            if (seleccion > 0 && seleccion <= listaAli.size()) {
                Alimentacion elegido = listaAli.get(seleccion - 1);
                System.out.print("Cantidad: ");
                int cantidad = Integer.parseInt(leerOpcion());
                
                for (int i = 0; i < cantidad; i++) {
                    this.cestaCompra.add(elegido);
                }
                System.out.println("¡Añadido!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Introduce un número.");
        }
    }
    
    /**
     * Muestra el catálogo de libros disponibles y permite añadirlos a la cesta
     */
    private void menuBusquedaLibros() {
        ArrayList<Libro> listaLibros = Libro.obtenerElementos();
        
        System.out.println("\n--- CATÁLOGO DE LIBROS ---");
        for (int i = 0; i < listaLibros.size(); i++) {
            System.out.println((i + 1) + ".\t" + listaLibros.get(i).dameCadena());
        }
        System.out.println("0.\tCancelar");
        
        System.out.print("\nSeleccione el libro que desea añadir: ");
        try {
            int seleccion = Integer.parseInt(leerOpcion());
            if (seleccion > 0 && seleccion <= listaLibros.size()) {
                Libro elegido = listaLibros.get(seleccion - 1);
                System.out.print("¿Cuántas unidades?: ");
                int cantidad = Integer.parseInt(leerOpcion());
                
                for (int i = 0; i < cantidad; i++) {
                    this.cestaCompra.add(elegido);
                }
                System.out.println("¡Añadido al carrito!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada numérica no válida.");
        }
    }

    /**
     * Lista los productos que están actualmente en la cesta de compra
     * y permite formalizar la compra o vaciar la cesta
     */
    private void listarProductosSeleccionados() {
        if (cestaCompra.isEmpty()) {
            System.out.println("\nLa cesta está vacía.");
            return;
        }

        System.out.println("\n--- PRODUCTOS EN TU CESTA ---");
        for (Producto p : cestaCompra) {
            System.out.println("- " + p.dameCadena());
        }

        System.out.println("\n(F) Formalizar compra");
        System.out.println("(R) Vaciar los productos seleccionados");
        System.out.println("(V) Volver al menú anterior");
        System.out.print("Seleccione una opción: ");
        String opcion = leerOpcion().toUpperCase();

        switch (opcion) {
            case "R":
                cestaCompra.clear();
                System.out.println("Cesta vaciada.");
                break;
            case "F":
                formalizarCompra();
                break;
            case "V":
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /**
     * Gestiona el proceso completo de formalización de la compra,
     * incluyendo opciones de envío, dirección, método de pago y confirmación
     */
    private void formalizarCompra() {
        System.out.println("\n--- PROCESO DE FORMALIZACIÓN DEL PEDIDO ---");
        
        System.out.println("Paso 1. Opción de envío:");
        System.out.println("(1) Entrega hoy (9,99€)");
        System.out.println("(2) Envío estándar (Gratis)");
        System.out.print("Seleccione una opción: ");
        String opcionEnvio = leerOpcion();
        
        double gastosEnvio = opcionEnvio.equals("1") ? 9.99 : 0.0;

        System.out.println("\nPaso 2. Dirección de envío:");
        System.out.println("Dirección actual: " + clienteActual.getDireccion());
        System.out.print("¿Desea usar esta dirección? (S/N): ");
        String usarActual = leerOpcion().toUpperCase();
        
        String direccionFinal;
        if (usarActual.equals("S")) {
            direccionFinal = clienteActual.getDireccion();
        } else {
            System.out.print("Introduzca la nueva dirección de envío: ");
            direccionFinal = leerOpcion();
        }

        System.out.println("\nPaso 3. Forma de pago:");
        MetodoPago pagoElegido = seleccionarMetodoPago();

        if (pagoElegido != null) {
            double subtotal = 0;
            for (Producto p : cestaCompra) {
                subtotal += p.calcularPrecioFinal();
            }
            
            double totalFinal = subtotal + gastosEnvio;

            System.out.println("\n" + "=".repeat(40));
            System.out.println("       RESUMEN DE SU PEDIDO");
            System.out.println("=".repeat(40));
            System.out.println("Cliente:    " + clienteActual.getNombreCompleto());
            System.out.println("Dirección:  " + direccionFinal);
            System.out.println("Envío:      " + (gastosEnvio > 0 ? "Express (9,99€)" : "Estándar (Gratis)"));
            System.out.println("Pago:       " + pagoElegido.dameCadena());
            System.out.println("-".repeat(40));
            System.out.printf("Subtotal:   %.2f€\n", subtotal);
            System.out.printf("Envío:      %.2f€\n", gastosEnvio);
            System.out.printf("TOTAL:      %.2f€\n", totalFinal);
            System.out.println("=".repeat(40));
            
            System.out.print("\n¿Confirmar pedido? (R) Realizar / (D) Descartar: ");
            if (leerOpcion().toUpperCase().equals("R")) {
                System.out.println("\n¡PEDIDO CONFIRMADO! Recibirá un correo en " + clienteActual.getCorreo());
                cestaCompra.clear();
            } else {
                System.out.println("\nPedido cancelado. Los productos siguen en la cesta.");
            }
        }
    }
    
    /**
     * Solicita al usuario que seleccione un método de pago y devuelve el objeto correspondiente
     * @return el método de pago seleccionado (PagoPayPal o PagoTarjeta), o null si la opción no es válida
     */
    private MetodoPago seleccionarMetodoPago() {
        System.out.println("(P) PayPal");
        System.out.println("(T) Tarjeta de crédito");
        System.out.print("Seleccione una opción: ");
        String tipo = leerOpcion().toUpperCase();

        if (tipo.equals("P")) {
            System.out.print("Introduzca código de usuario PayPal: ");
            String usu = leerOpcion();
            System.out.print("Fecha de alta (DD/MM/AAAA): ");
            String fecha = leerOpcion();
            return new PagoPayPal(usu, fecha);
            
        } else if (tipo.equals("T")) {
            System.out.print("Tipo (VISA, 4B, American Express...): ");
            String t = leerOpcion();
            System.out.print("Número de tarjeta (16 dígitos): ");
            String num = leerOpcion();
            System.out.print("Fecha caducidad (MM/AA): ");
            String cad = leerOpcion();
            System.out.print("CVC: ");
            int cvc = Integer.parseInt(leerOpcion());
            System.out.print("Nombre del titular: ");
            String tit = leerOpcion();
            return new PagoTarjeta(t, num, cad, cvc, tit);
        }
        
        System.out.println("Opción de pago no válida.");
        return null;
    }

    /**
     * Gestiona el proceso de inicio de sesión de un usuario registrado
     * mediante correo electrónico y contraseña
     */
    private void loginUsuarioRegistrado() {
        System.out.println("-----Inicio de sesion-----");
        System.out.println("Introduzca su correo electronico");
        String correo = leerOpcion();
        
        System.out.println("Introduzca su contraseña:");
        String password = leerOpcion();
        
        ClienteRegistrado usuarioEncontrado = buscarUsuarioPorCorreo(correo);
        
        if(usuarioEncontrado != null) {
            if(usuarioEncontrado.validarPassword(password)) {
                this.clienteActual = usuarioEncontrado;
                System.out.println("\nBienvenido de nuevo: " + usuarioEncontrado.getNombreCompleto() + ".");
                iniciarMenuPrincipalTienda();
            }
            else {
                System.out.println("Error: Conteaseña incorrecta.");
            }
        }
        else {
            System.out.println("Error: Correo no encontrado.");
        }
    }
    
    /**
     * Gestiona el proceso de registro de un nuevo usuario en el sistema
     * solicitando todos los datos necesarios y creando el objeto ClienteRegistrado
     */
    private void registrarNuevoUsuario() {
        System.out.println("\n-----Registro de nuevo usuario-----");
        String correo;
        ClienteRegistrado existente;
        
        do {
            System.out.println("Correo electronico: ");
            correo = leerOpcion(); 
            existente = buscarUsuarioPorCorreo(correo);
                
                if (existente != null) {
                    System.out.println("Ese correo ya esta en uso, por favor use otro.");
                }
        } while (existente != null);
        
        System.out.println("Nombre: ");
        String nombre = leerOpcion();
        System.out.println("Apellidos: ");
        String apellidos = leerOpcion();
        System.out.println("Direccion actual: ");
        String direccion = leerOpcion();
        System.out.println("Contraseña: ");
        String contraseña = leerOpcion();
        System.out.println("Fecha de nacimiento (DD/MM/AAAA): ");
        String fechaNacimiento = leerOpcion();
        
        ClienteRegistrado nuevoUsuario = new ClienteRegistrado(
                correo, nombre, apellidos, direccion, contraseña, fechaNacimiento
                );
        this.usuariosRegistrados.add(nuevoUsuario);
        this.clienteActual = nuevoUsuario;
        
        System.out.println("\n¡Registro completado!");
        iniciarMenuPrincipalTienda();
    }
    
    /**
     * Gestiona el acceso a la tienda como usuario invitado
     * solicitando los datos básicos necesarios
     */
    private void entradaComoInvitado() {
        System.out.println("----- Entrada como Invitado -----");
        System.out.print("Introduzca su correo electrónico: ");
        String correo = leerOpcion();
        System.out.print("Nombre: ");
        String nombre = leerOpcion();
        System.out.print("Apellidos: ");
        String apellidos = leerOpcion();
        System.out.print("Dirección de contacto: ");
        String direccion = leerOpcion();
        
        this.clienteActual = new ClienteInvitado(correo, nombre, apellidos, direccion);
        System.out.println("\nBienvenido/a a la tienda, " + nombre + ".");
        iniciarMenuPrincipalTienda();
    }
    
    /**
     * Muestra y gestiona el menú principal de la tienda una vez el usuario ha accedido,
     * permitiendo buscar productos, listar la cesta o volver al menú de inicio
     */
    private void iniciarMenuPrincipalTienda() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Menú Principal de la Tienda ---");
            System.out.println("Cliente: " + (clienteActual != null ? clienteActual.getNombreCompleto() : "Invitado"));
            System.out.println("(B) Buscar producto");
            System.out.println("(L) Listar productos seleccionados");
            System.out.println("(V) Volver al menú de inicio");
            System.out.print("Seleccione una opción: ");
            String opcion = leerOpcion();
            
            switch (opcion.toUpperCase()) {
                case "B":
                    buscarProducto();
                    break;
                case "L":
                    listarProductosSeleccionados();
                    break;
                case "V":
                    this.clienteActual = null;
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    
    /**
     * Busca un usuario registrado por su correo electrónico en la lista de usuarios
     * @param correo el correo electrónico a buscar
     * @return el ClienteRegistrado encontrado, o null si no existe
     */
    private ClienteRegistrado buscarUsuarioPorCorreo(String correo) {
        for (ClienteRegistrado usuario : this.usuariosRegistrados) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return usuario;
            }
        }
        return null;
    }
}