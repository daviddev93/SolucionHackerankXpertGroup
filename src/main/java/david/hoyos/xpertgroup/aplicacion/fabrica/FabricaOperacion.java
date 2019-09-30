package david.hoyos.xpertgroup.aplicacion.fabrica;

import org.springframework.stereotype.Component;
import david.hoyos.xpertgroup.dominio.modelo.Coordenada;
import david.hoyos.xpertgroup.dominio.modelo.Operacion;
import david.hoyos.xpertgroup.dominio.modelo.OperacionActualizacion;
import david.hoyos.xpertgroup.dominio.modelo.OperacionConsulta;

@Component
public class FabricaOperacion {
    
    private static final Integer[] XYZ = { 1, 2, 3 };
    private static final Integer[] X1Y1Z1 = { 1, 2, 3 };
    private static final Integer[] X2Y2Z2 = { 4, 5, 6 };
    private static final Integer INDICEVALOR = 4;
    private static final Integer INDICETIPOOPERACION = 0;
    
    private final FabricaCoordenada fabricaCoordenada;

    public FabricaOperacion(FabricaCoordenada fabricaCoordenada) {
	this.fabricaCoordenada = fabricaCoordenada;
    }

    /**
     * Metodo encargado de crear la operacion segun corresponda
     *
     * @param operacion
     * @param tamanoMatriz
     * @return
     *
     */
    public Operacion crear(String operacion, Integer tamanoMatriz) {

	String[] datosOperacion = operacion.split(" ");

	if (OperacionActualizacion.TIPOOPERACION.equals(datosOperacion[INDICETIPOOPERACION])) {
	    String valor = datosOperacion[INDICEVALOR];
	    Coordenada coordenadaReferencia = fabricaCoordenada.crear(datosOperacion, XYZ);
	    return new OperacionActualizacion(coordenadaReferencia, valor, tamanoMatriz);
	}

	else {
	    Coordenada coordenadaReferencia = fabricaCoordenada.crear(datosOperacion, X1Y1Z1);
	    Coordenada coordenadaFinal = fabricaCoordenada.crear(datosOperacion, X2Y2Z2);
	    return new OperacionConsulta(coordenadaReferencia, coordenadaFinal, tamanoMatriz);
	}
    }
}
