package david.hoyos.xpertgroup.dominio;

import david.hoyos.xpertgroup.dominio.excepcion.ExcepcionCoordenadaFueraDeRango;
import david.hoyos.xpertgroup.dominio.excepcion.ExcepcionFormatoValor;
import david.hoyos.xpertgroup.dominio.modelo.Coordenada;

public class ValidadorArgumento {

    private ValidadorArgumento() {
    }

    public static void validarFormatoNumerico(String valor, String mensaje) {
	try {
	    Integer.parseInt(valor);
	} catch (NumberFormatException numberFormatException) {
	    throw new ExcepcionFormatoValor(mensaje);
	}
    }

    public static void validarCoordenadaEstaEnMatriz(Coordenada coordenada, Integer tamanoMatriz, String mensaje) {
	if (coordenada.getX() > tamanoMatriz || coordenada.getY() > tamanoMatriz || coordenada.getZ() > tamanoMatriz) {
	    throw new ExcepcionCoordenadaFueraDeRango(mensaje);
	}

    }
}
