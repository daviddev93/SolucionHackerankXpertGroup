package david.hoyos.xpertgroup.dominio.modelo;

import david.hoyos.xpertgroup.dominio.ValidadorArgumento;

public class OperacionConsulta extends Operacion{
    
    public static final String TIPOOPERACION = "QUERY";
    private static final String VALOR_COORDENADA_FUERA_DE_RANGO = "Una o mas coordenadas especificadas para la consulta"
	    	+ " no esta en el rango de la matriz";
    private Coordenada coordenadaFinal;
    
    public OperacionConsulta(Coordenada coordenadaReferencia,Coordenada coordenadaFinal,Integer tamanoMatriz) {
	ValidadorArgumento.validarCoordenadaEstaEnMatriz(coordenadaReferencia, tamanoMatriz, VALOR_COORDENADA_FUERA_DE_RANGO);
	super.setTipoOperacion(TIPOOPERACION);
	super.setCoordenadaReferencia(coordenadaReferencia);
	this.coordenadaFinal = coordenadaFinal;
    }
    
    public Coordenada getCoordenadaInicial() {
        return super.getCoordenadaReferencia();
    }
    
    public Coordenada getCoordenadaFinal() {
        return coordenadaFinal;
    }
    
}
