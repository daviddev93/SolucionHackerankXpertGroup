package david.hoyos.xpertgroup.dominio.excepcion;

public class ExcepcionFormatoValor extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionFormatoValor(String mensaje) {
        super(mensaje);
    }
}
