package david.hoyos.xpertgroup.dominio.excepcion;

public class ExcepcionCoordenadaFueraDeRango extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ExcepcionCoordenadaFueraDeRango(String mensaje) {
        super(mensaje);
    }
}
