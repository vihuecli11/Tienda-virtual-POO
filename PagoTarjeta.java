package paquetePagos;

public class PagoTarjeta extends MetodoPago {
    private String tipoTarjeta; // VISA, 4B, Euro600 o American Express 
    private String numeroTarjeta;
    private String fechaCaducidad;
    private int cvc;
    private String titular;

    public PagoTarjeta(String tipoTarjeta, String numeroTarjeta, String fechaCaducidad, int cvc, String titular) {
        super("Pago con Tarjeta de Crédito");
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
        this.cvc = cvc;
        this.titular = titular;
    }

    @Override
    public String dameCadena() {
        // Formateamos para mostrar solo los últimos 4 dígitos por seguridad
        String ultimosDigitos = numeroTarjeta.substring(numeroTarjeta.length() - 4);
        return String.format("%s: %s (**** **** **** %s), Titular: %s, Exp: %s", 
                textoDescriptivo, tipoTarjeta, ultimosDigitos, titular, fechaCaducidad);
    }
}