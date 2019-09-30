package david.hoyos.xpertgroup.integracion.aplicacion.manejador;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import david.hoyos.xpertgroup.aplicacion.fabrica.FabricaCoordenada;
import david.hoyos.xpertgroup.aplicacion.fabrica.FabricaOperacion;
import david.hoyos.xpertgroup.aplicacion.manejador.ManejadorProcesarOperaciones;
import david.hoyos.xpertgroup.aplicacion.modelo.EntradaOperacion;
import david.hoyos.xpertgroup.dominio.servicio.ServicioProcesarOperaciones;

public class ManejadorProcesarOperacionesTest {

    private static final Integer[] CASOPRUEBAUNORESULTADO = { 4, 4, 27, 0, 1, 1 };
    FabricaCoordenada fabricaCoordenada = new FabricaCoordenada();
    FabricaOperacion fabricaOperacion = new FabricaOperacion(fabricaCoordenada);
    ServicioProcesarOperaciones servicioProcesarOperaciones = new ServicioProcesarOperaciones();
    ManejadorProcesarOperaciones manejadorProcesarOperaciones = new ManejadorProcesarOperaciones(fabricaOperacion,
	    servicioProcesarOperaciones);

    public static List<EntradaOperacion> casoPruebaUno() {
	List<EntradaOperacion> operacionesEntrada = new ArrayList<>();
	EntradaOperacion entradaOperacion = new EntradaOperacion();
	entradaOperacion.setTamanoMatriz(4);
	List<String> operaciones = new ArrayList<>();
	agregarOperaciones(operaciones, "UPDATE 2 2 2 4", "QUERY 1 1 1 3 3 3", "UPDATE 1 1 1 23", "QUERY 2 2 2 4 4 4",
		"QUERY 1 1 1 3 3 3");
	entradaOperacion.setOperaciones(operaciones);
	operacionesEntrada.add(entradaOperacion);

	EntradaOperacion entradaOperacion2 = new EntradaOperacion();
	entradaOperacion2.setTamanoMatriz(2);
	List<String> operaciones2 = new ArrayList<>();
	agregarOperaciones(operaciones2, "UPDATE 2 2 2 1", "QUERY 1 1 1 1 1 1", "QUERY 1 1 1 2 2 2",
		"QUERY 2 2 2 2 2 2");
	entradaOperacion2.setOperaciones(operaciones2);
	operacionesEntrada.add(entradaOperacion2);

	return operacionesEntrada;
    }

    public static List<String> agregarOperaciones(List<String> operacionesLista, String... operaciones) {
	for (String operacion : operaciones) {
	    operacionesLista.add(operacion);
	}
	return operacionesLista;
    }

    @Test
    public void testCasoDePruebaUno() {

	// Arrangement
	List<EntradaOperacion> operacionesEntrada = casoPruebaUno();

	// Act
	List<Integer> respuesta = manejadorProcesarOperaciones.ejecutar(operacionesEntrada);

	// Assert
	for (int iterador = 0; iterador < respuesta.size(); iterador++) {
	    Assert.assertTrue(respuesta.get(iterador) == CASOPRUEBAUNORESULTADO[iterador]);
	}
    }

}
