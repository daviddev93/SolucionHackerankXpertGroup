package david.hoyos.xpertgroup.aplicacion.manejador;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import david.hoyos.xpertgroup.aplicacion.fabrica.FabricaOperacion;
import david.hoyos.xpertgroup.aplicacion.modelo.EntradaOperacion;
import david.hoyos.xpertgroup.dominio.modelo.Operacion;
import david.hoyos.xpertgroup.dominio.servicio.ServicioProcesarOperaciones;

@Component
public class ManejadorProcesarOperaciones {

    private final FabricaOperacion fabricaoperacion;
    private final ServicioProcesarOperaciones servicioProcesarOperaciones;

    public ManejadorProcesarOperaciones(FabricaOperacion fabricaoperacion,
	    ServicioProcesarOperaciones servicioProcesarOperaciones) {
	this.fabricaoperacion = fabricaoperacion;
	this.servicioProcesarOperaciones = servicioProcesarOperaciones;
    }

    /**
     * 
     *Metodo encargado de orquestar el procesamiento de las operaciones en la
     *matriz
     * @param entradaOperaciones
     * @return
     *
     */
    
    public List<Integer> ejecutar(List<EntradaOperacion> entradaOperaciones) {
	List<Integer> resultadoConsultas = new ArrayList<>();
	entradaOperaciones.forEach(entradaOperacion -> {
	    List<Operacion> operacionesMatriz = new ArrayList<>();
	    entradaOperacion.getOperaciones().forEach(operacion -> {
		Operacion objetoOperacion = this.fabricaoperacion.crear(operacion, entradaOperacion.getTamanoMatriz());
		operacionesMatriz.add(objetoOperacion);
	    });
	    List<Integer> resultado = servicioProcesarOperaciones.procesarOperaciones(operacionesMatriz);
	    resultadoConsultas.addAll(resultado);
	});
	return resultadoConsultas;
    }

}
