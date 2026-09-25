package Productos;

import java.util.ArrayList;

/**
 * Clase que representa un disco de música
 * Tiene el impuesto general del 21%
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class DiscodeMusica extends Producto {
    
    /**
     * Enumeración de géneros musicales disponibles
     */
    public enum Genero {
        NAVIDAD,
        POP,
        REGGAETON,
        DANCE
    }
    
    private String artista;
    private Genero genero;
    
    /**
     * Constructor de DiscoMusica
     * @param codigo código del producto
     * @param descripcion descripción del disco (nombre del álbum)
     * @param precioSinImpuestos precio sin impuestos
     * @param artista nombre del artista o grupo
     * @param genero género musical
     */
    public DiscodeMusica(String codigo, String descripcion, double precioSinImpuestos, 
                       String artista, Genero genero) {
        super(codigo, descripcion, precioSinImpuestos, 21.0); // Impuesto del 21%
        this.artista = artista;
        this.genero = genero;
    }
    
    // Getters y Setters
    public String getArtista() {
        return artista;
    }
    
    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    public Genero getGenero() {
        return genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    /**
     * Implementación específica de dameCadena para discos de música
     * @return cadena formateada con los datos del disco
     */
    @Override
    public String dameCadena() {
        return String.format("%s\t%s - %s\t%.2f€\t%.2f€ (%.0f%%)\t%.2f€\tGénero: %s",
                codigo,
                descripcion,
                artista,
                precioSinImpuestos,
                calcularImpuestos(),
                porcentajeImpuesto,
                calcularPrecioFinal(),
                genero);
    }
    
    /**
     * Método estático para obtener discos de música de prueba
     * @return ArrayList con discos de prueba
     */
    public static ArrayList<DiscodeMusica> obtenerElementos() {
        ArrayList<DiscodeMusica> discos = new ArrayList<>();
        
        discos.add(new DiscodeMusica(
            "DS001",
            "Thriller",
            14.99,
            "Michael Jackson",
            Genero.POP
        ));
        
        discos.add(new DiscodeMusica(
            "DS002",
            "Energia",
            16.50,
            "J balvin",
            Genero.REGGAETON
        ));
        
        discos.add(new DiscodeMusica(
            "DS003",
            "Discovery",
            13.99,
            "Daft Punk",
            Genero.DANCE
        ));
        
        discos.add(new DiscodeMusica(
            "DS004",
            "The chrismas album",
            9.99,
            "Human Nature",
            Genero.NAVIDAD
        ));
        
        discos.add(new DiscodeMusica(
            "DS005",
            "YHLQMDLG",
            17.99,
            "BAD BUNNY",
            Genero.REGGAETON
        ));
        
        return discos;
    }
}