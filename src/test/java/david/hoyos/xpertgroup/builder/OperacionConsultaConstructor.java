package david.hoyos.xpertgroup.builder;

import david.hoyos.xpertgroup.dominio.modelo.Coordenada;
import david.hoyos.xpertgroup.dominio.modelo.OperacionConsulta;

public class OperacionConsultaConstructor {
    
    private static final Integer TAMANOMATRIZ = 4;
    
    private Integer tamanoMatriz;
    private Coordenada coordenadaReferencia;
    private Coordenada coordenadaFinal;
    
    public OperacionConsultaConstructor() {
	this.tamanoMatriz = TAMANOMATRIZ;
	this.coordenadaReferencia = new CoordenadaConstructor().construir();
	this.coordenadaFinal = new CoordenadaConstructor().conX("4").conY("4").conZ("4").construir();
    }
    
    public OperacionConsultaConstructor conTamanoMatriz(Integer tamanoMatriz) {
	this.tamanoMatriz = tamanoMatriz;
	return this;
    }
    
    public OperacionConsultaConstructor conCoordenadaReferencia(Coordenada coordenadaReferencia) {
	this.coordenadaReferencia = coordenadaReferencia;
	return this;
    }
    
    public OperacionConsultaConstructor conCoordenadaFinal(Coordenada coordenadaFinal) {
	this.coordenadaFinal = coordenadaFinal;
	return this;
    }
    
    public OperacionConsulta construir() {
	return new OperacionConsulta(this.coordenadaReferencia, this.coordenadaFinal, this.tamanoMatriz);
    }

}
