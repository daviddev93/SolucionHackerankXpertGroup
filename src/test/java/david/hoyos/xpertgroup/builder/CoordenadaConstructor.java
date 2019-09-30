package david.hoyos.xpertgroup.builder;

import david.hoyos.xpertgroup.dominio.modelo.Coordenada;

public class CoordenadaConstructor {

    private static final String X = "1";
    private static final String Y = "1";
    private static final String Z = "1";

    private String x;
    private String y;
    private String z;

    public CoordenadaConstructor() {
	this.x = X;
	this.y = Y;
	this.z = Z;
    }

    public CoordenadaConstructor conX(String x) {
	this.x = x;
	return this;
    }

    public CoordenadaConstructor conY(String y) {
	this.y = y;
	return this;
    }

    public CoordenadaConstructor conZ(String z) {
	this.z = z;
	return this;
    }

    public Coordenada construir() {
	return new Coordenada(this.x, this.y, this.z);
    }

}
