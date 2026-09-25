package Pantallas;

/**
 * Interfaz para estandarizar la impresión por pantalla de objetos.
 * Todas las clases que implementen esta interfaz deben proporcionar
 * su propia implementación del método dameCadena() para formatear
 * sus datos como String.
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public interface iMostrable {
    
    /**
     * Devuelve una representación en formato String del objeto
     * para ser mostrado por pantalla.
     * Cada clase que implemente esta interfaz debe definir
     * cómo quiere formatear sus datos.
     * 
     * @return cadena formateada con los datos del objeto
     */
    String dameCadena();
}