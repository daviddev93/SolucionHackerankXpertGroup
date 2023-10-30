package david.hoyos.xpertgroup.dominio.modelo;

import david.hoyos.xpertgroup.dominio.ValidadorArgumento;

public class Coordenada {

    private static final String VALOR_COORDENADA_NO_VALIDO = "El valor para la Coordenada debe ser numerico";
    private Integer x;
    private Integer y;
    private Integer z;

    public Coordenada(String x, String y, String z) {
        System.out.println("Changed something else in master");
	ValidadorArgumento.validarFormatoNumerico(x, VALOR_COORDENADA_NO_VALIDO);
	ValidadorArgumento.validarFormatoNumerico(y, VALOR_COORDENADA_NO_VALIDO);
	ValidadorArgumento.validarFormatoNumerico(z, VALOR_COORDENADA_NO_VALIDO);
	this.x = Integer.parseInt(x);
	this.y = Integer.parseInt(y);
	this.z = Integer.parseInt(z);
    }

    /**
     * Metodo Encargado de establecer si un bloque pertenece a la Submatriz
     * 
     * @param coordenadaXYZ
     * @param coordenadaX1Y1Z1
     * @param coordenadaX2Y2Z2
     * @return boolean
     */
    public static boolean coordenadaEstaEnSubmatriz(Coordenada coordenadaXYZ, Coordenada coordenadaX1Y1Z1,
	    Coordenada coordenadaX2Y2Z2) {
	return ((coordenadaXYZ.x >= coordenadaX1Y1Z1.x && coordenadaXYZ.x <= coordenadaX2Y2Z2.x)
		&& (coordenadaXYZ.y >= coordenadaX1Y1Z1.y && coordenadaXYZ.x <= coordenadaX2Y2Z2.y)
		&& (coordenadaXYZ.z >= coordenadaX1Y1Z1.z && coordenadaXYZ.z <= coordenadaX2Y2Z2.z));
    }

    public Integer getX() {
	return x;
    }

    public Integer getY() {
	return y;
    }

    public Integer getZ() {
	return z;
    }

}
