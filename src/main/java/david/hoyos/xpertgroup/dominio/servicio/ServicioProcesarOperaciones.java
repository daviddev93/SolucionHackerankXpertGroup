package david.hoyos.xpertgroup.dominio.servicio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import david.hoyos.xpertgroup.dominio.modelo.Coordenada;
import david.hoyos.xpertgroup.dominio.modelo.Operacion;
import david.hoyos.xpertgroup.dominio.modelo.OperacionActualizacion;
import david.hoyos.xpertgroup.dominio.modelo.OperacionConsulta;

@Component
public class ServicioProcesarOperaciones {

    

    /**
     * Metodo encargado de procesar las operaciones de las matrices
     * 
     * @param tamañoMatriz
     * @param operaciones
     * @return List<Integer>
     */
    public List<Integer> procesarOperaciones(List<Operacion> operaciones) {
	List<Integer> resultadoConsultas = new ArrayList<>();
	List<OperacionActualizacion> actualizacionesRealizadas = new ArrayList<>();

	for (Operacion operacion : operaciones) {
	    if (OperacionActualizacion.TIPOOPERACION.equals(operacion.getTipoOperacion())) {
		OperacionActualizacion actualizacionBloque = (OperacionActualizacion) operacion;
		actualizacionesRealizadas.add(actualizacionBloque);
	    } else {
		Integer consulta = procesarQuerySuma(operacion,actualizacionesRealizadas);
		resultadoConsultas.add(consulta);
	    }
	}
	return resultadoConsultas;
    }

    /**
     * Metodo encargado de Sumar todos los valores de los bloques en un rango
     * determinado
     * 
     * @param datosOperacion
     * @param actualizacionesRealizadas
     * @return Integer
     */
    private Integer procesarQuerySuma(Operacion operacion, List<OperacionActualizacion> actualizacionesRealizadas) {
	OperacionConsulta operacionConsulta = (OperacionConsulta) operacion;
	Coordenada coordenadaX1Y1Z1 = operacionConsulta.getCoordenadaInicial();
	Coordenada coordenadaX2Y2Z2 = operacionConsulta.getCoordenadaFinal();

	return actualizacionesRealizadas.stream()
		.filter(operacionActualizacion -> Coordenada.coordenadaEstaEnSubmatriz(
			operacionActualizacion.getCoordenada(), coordenadaX1Y1Z1, coordenadaX2Y2Z2))
		.mapToInt(OperacionActualizacion::getValor).sum();
    }
}
