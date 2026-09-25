package Productos;

import java.util.ArrayList;

/**
 * Clase que representa un libro
 * Tiene un impuesto reducido del 10%
 * * @author Tu Nombre
 * @version 1.0
 */
public class Libro extends Producto {
    
    private String isbn;
    private String autor;
    private String editorial;

    /**
     * Constructor de Libro
     * @param codigo código interno
     * @param titulo (descripcion en la clase padre)
     * @param precioSinImpuestos precio base
     * @param isbn identificador internacional
     * @param autor escritor del libro
     * @param editorial casa de edición
     */
    public Libro(String codigo, String titulo, double precioSinImpuestos, 
                 String isbn, String autor, String editorial) {
        // Pasamos 10.0 como el porcentaje de impuesto para libros
        super(codigo, titulo, precioSinImpuestos, 10.0);
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }

    // Getters y Setters
    public String getIsbn() { return isbn; }
    public String getAutor() { return autor; }
    public String getEditorial() { return editorial; }

    /**
     * Implementación de dameCadena con formato de libro
     */
    @Override
    public String dameCadena() {
        return String.format("%s\t%s - %s\t%.2f€\t%.2f€ (%.0f%%)\t%.2f€\tISBN: %s\tEd: %s",
                codigo,
                descripcion, // Título
                autor,
                precioSinImpuestos,
                calcularImpuestos(),
                porcentajeImpuesto,
                calcularPrecioFinal(),
                isbn,
                editorial);
    }

    /**
     * Datos de prueba para el catálogo de libros
     */
    public static ArrayList<Libro> obtenerElementos() {
        ArrayList<Libro> lista = new ArrayList<>();
        
        lista.add(new Libro("LB001", "Don Quijote de la Mancha", 18.00, "978-8420412146", "Miguel de Cervantes", "Alfaguara"));
        lista.add(new Libro("LB002", "Cien años de soledad", 15.50, "978-0307474728", "Gabriel García Márquez", "Debolsillo"));
        lista.add(new Libro("LB003", "1984", 12.00, "978-8499890944", "George Orwell", "Lumen"));
        lista.add(new Libro("LB004", "El Principito", 9.50, "978-8478887194", "Antoine de Saint-Exupéry", "Salamandra"));
        lista.add(new Libro("LB005", "El Hobbit", 21.90, "978-8445077412", "J.R.R. Tolkien", "Minotauro"));
        
        return lista;
    }
}