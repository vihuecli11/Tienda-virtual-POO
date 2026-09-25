package Productos;

import Pantallas.iMostrable;

/**
 * Clase abstracta que representa un producto de la tienda
 * Clase padre de Alimentacion, Libro y DiscoMusica
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public abstract class Producto implements iMostrable {
    
    // Atributos comunes a todos los productos
    protected String codigo;
    protected String descripcion;
    protected double precioSinImpuestos;
    protected double porcentajeImpuesto;
    
    /**
     * Constructor de Producto
     * @param codigo código del producto
     * @param descripcion descripción del producto
     * @param precioSinImpuestos precio sin impuestos
     * @param porcentajeImpuesto porcentaje de impuesto (por defecto 21%)
     */
    public Producto(String codigo, String descripcion, double precioSinImpuestos, double porcentajeImpuesto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioSinImpuestos = precioSinImpuestos;
        this.porcentajeImpuesto = porcentajeImpuesto;
    }
    
    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }
    
 
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getPrecioSinImpuestos() {
        return precioSinImpuestos;
    }
    
    public void setPrecioSinImpuestos(double precioSinImpuestos) {
        this.precioSinImpuestos = precioSinImpuestos;
    }
    
    public double getPorcentajeImpuesto() {
        return porcentajeImpuesto;
    }
    
    public void setPorcentajeImpuesto(double porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }
    
    /**
     * Calcula el importe de los impuestos
     * @return importe de impuestos
     */
    public double calcularImpuestos() {
        return precioSinImpuestos * (porcentajeImpuesto / 100.0);
    }
    
    /**
     * Calcula el precio final con impuestos incluidos
     * @return precio final
     */
    public double calcularPrecioFinal() {
        return precioSinImpuestos + calcularImpuestos();
    }
    
    /**
     * Implementación de IMostrable
     * Devuelve una cadena con la información básica del producto
     * @return cadena formateada con los datos del producto
     */
    @Override
    public String dameCadena() {
        return String.format("%s\t%s\t%.2f€\t%.2f€ (%.0f%%)\t%.2f€",
                codigo,
                descripcion,
                precioSinImpuestos,
                calcularImpuestos(),
                porcentajeImpuesto,
                calcularPrecioFinal());
    }
}