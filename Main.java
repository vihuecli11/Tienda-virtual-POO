package paquetePrincipal;

/**
 * Clase principal que inicia la aplicación
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class Main {
    
    /**
     * Método principal
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        TiendaVirtual tienda = new TiendaVirtual();
        tienda.iniciar();
    }
}