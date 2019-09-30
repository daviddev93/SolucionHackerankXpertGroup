package david.hoyos.xpertgroup.dominio.modelo;

import david.hoyos.xpertgroup.dominio.ValidadorArgumento;

public class OperacionActualizacion extends Operacion {

    public static final String TIPOOPERACION = "UPDATE";
    private static final String VALOR_UPDATE_NO_VALIDO = "El valor para la actualizacion de la matriz debe ser numerico";
    private static final String VALOR_COORDENADA_FUERA_DE_RANGO = "la coordenada especificada para la actualizacion"
    	+ " no esta en el rango de la matriz";

    private Integer valor;

    public OperacionActualizacion(Coordenada coordenadaReferencia, String valor, Integer tamanoMatriz) {
	ValidadorArgumento.validarFormatoNumerico(valor, VALOR_UPDATE_NO_VALIDO);
	ValidadorArgumento.validarCoordenadaEstaEnMatriz(coordenadaReferencia, tamanoMatriz,
		VALOR_COORDENADA_FUERA_DE_RANGO);
	super.setTipoOperacion(TIPOOPERACION);
	super.setCoordenadaReferencia(coordenadaReferencia);
	this.valor = Integer.parseInt(valor);
    }

    public Coordenada getCoordenada() {
	return super.getCoordenadaReferencia();
    }

    public Integer getValor() {
	return valor;
    }
}
