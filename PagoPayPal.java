package paquetePagos;

public class PagoPayPal extends MetodoPago {
    private String codigoUsuario;
    private String fechaAlta;

    public PagoPayPal(String codigoUsuario, String fechaAlta) {
        super("Pago a través de PayPal");
        this.codigoUsuario = codigoUsuario;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String dameCadena() {
        return String.format("%s (Usuario: %s, Alta: %s)", 
                textoDescriptivo, codigoUsuario, fechaAlta);
    }
}