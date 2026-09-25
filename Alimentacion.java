package Productos;

import java.util.ArrayList;

/**
 * Clase que representa un producto de alimentación
 * Tiene un impuesto superreducido del 4%
 * * @author Tu Nombre
 * @version 1.0
 */
public class Alimentacion extends Producto {
    
    private String fechaCaducidad;

    /**
     * Constructor de Alimentacion
     * @param codigo código del producto
     * @param descripcion nombre del producto
     * @param precioSinImpuestos precio base
     * @param fechaCaducidad en formato DD/MM/AAAA
     */
    public Alimentacion(String codigo, String descripcion, double precioSinImpuestos, String fechaCaducidad) {
        // Pasamos 4.0 como el porcentaje de impuesto específico para alimentación
        super(codigo, descripcion, precioSinImpuestos, 4.0);
        this.fechaCaducidad = fechaCaducidad;
    }

    // Getter y Setter
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * Implementación de dameCadena siguiendo el estilo de tus discos
     */
    @Override
    public String dameCadena() {
        return String.format("%s\t%s\t%.2f€\t%.2f€ (%.0f%%)\t%.2f€\tCaducidad: %s",
                codigo,
                descripcion,
                precioSinImpuestos,
                calcularImpuestos(),
                porcentajeImpuesto,
                calcularPrecioFinal(),
                fechaCaducidad);
    }

    /**
     * Método estático con datos de prueba
     */
    public static ArrayList<Alimentacion> obtenerElementos() {
        ArrayList<Alimentacion> lista = new ArrayList<>();
        
        lista.add(new Alimentacion( "AL001",
					        		"Leche Entera 1L",
					        		0.90,
					        		"20/12/2025"));
        lista.add(new Alimentacion( "AL002",
					        		"Docena Huevos XL",
					        		2.50,
					        		"15/05/2025"));
        lista.add(new Alimentacion( "AL003",
					        		"Pan de Molde",
					        		1.20,
					        		"10/04/2025"));
        lista.add(new Alimentacion( "AL004",
					        		"Arroz Extra 1kg",
					        		1.80,
					        		"01/01/2027"));
        lista.add(new Alimentacion( "AL005",
					        		"Aceite de Oliva",
					        		8.50,
					        		"30/06/2026"));
        
        return lista;
    }
}