package paquetePagos;

import Pantallas.iMostrable;

/**
 * Clase abstracta que define la estructura básica de cualquier método de pago.
 * Implementa iMostrable para estandarizar la impresión de datos[cite: 56].
 */
public abstract class MetodoPago implements iMostrable {
    
    protected String textoDescriptivo; // Texto descriptivo común para todos 

    public MetodoPago(String textoDescriptivo) {
        this.textoDescriptivo = textoDescriptivo;
    }

    public String getTextoDescriptivo() {
        return textoDescriptivo;
    }

    // El método dameCadena se deja como abstracto o se implementa parcialmente
    @Override
    public abstract String dameCadena();
}