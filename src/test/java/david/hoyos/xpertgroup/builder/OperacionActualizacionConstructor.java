package david.hoyos.xpertgroup.builder;

import david.hoyos.xpertgroup.dominio.modelo.Coordenada;
import david.hoyos.xpertgroup.dominio.modelo.OperacionActualizacion;

public class OperacionActualizacionConstructor {

    private static final Integer TAMANOMATRIZ = 4;
    private static final String VALOR = "10";

    private Integer tamanoMatriz;
    private String valor;
    private Coordenada coordenada;

    public OperacionActualizacionConstructor() {
	this.tamanoMatriz = TAMANOMATRIZ;
	this.valor = VALOR;
	this.coordenada = new CoordenadaConstructor().construir();
    }

    public OperacionActualizacionConstructor conTamanoMatriz(String tamanoMatriz) {
	this.tamanoMatriz = TAMANOMATRIZ;
	return this;
    }

    public OperacionActualizacionConstructor conValor(String valor) {
	this.valor = valor;
	return this;
    }

    public OperacionActualizacionConstructor conCoordenada(Coordenada coordenada) {
	this.coordenada = coordenada;
	return this;
    }

    public OperacionActualizacion construir() {
	return new OperacionActualizacion(this.coordenada, this.valor, this.tamanoMatriz);
    }

}
