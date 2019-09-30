package david.hoyos.xpertgroup.unitaria.dominio.servicio;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import david.hoyos.xpertgroup.builder.CoordenadaConstructor;
import david.hoyos.xpertgroup.builder.OperacionActualizacionConstructor;
import david.hoyos.xpertgroup.builder.OperacionConsultaConstructor;
import david.hoyos.xpertgroup.dominio.modelo.Operacion;
import david.hoyos.xpertgroup.dominio.servicio.ServicioProcesarOperaciones;

public class ServicioProcesarOperacionesTest {

    ServicioProcesarOperaciones servicioProcesarOperaciones = new ServicioProcesarOperaciones();

    private static final Integer CASOPRUEBAUNORESULTADO = 40;
    private static final Integer[] CASOPRUEBADOSRESULTADO = { 20, 30, 10 };

    public List<Operacion> casoPruebaUno() {
	List<Operacion> operaciones = new ArrayList<>();
	Operacion operacion1 = new OperacionActualizacionConstructor().construir();
	Operacion operacion2 = new OperacionActualizacionConstructor()
		.conCoordenada(new CoordenadaConstructor().conX("1").conY("2").conZ("3").construir()).construir();
	Operacion operacion3 = new OperacionActualizacionConstructor()
		.conCoordenada(new CoordenadaConstructor().conX("2").conY("2").conZ("3").construir()).construir();
	Operacion operacion4 = new OperacionActualizacionConstructor()
		.conCoordenada(new CoordenadaConstructor().conX("1").conY("2").conZ("2").construir()).construir();
	Operacion operacion5 = new OperacionConsultaConstructor().construir();
	return agregarOperaciones(operaciones, operacion1, operacion2, operacion3, operacion4, operacion5);
    }

    public List<Operacion> casoPruebaDos() {
	List<Operacion> operaciones = new ArrayList<>();
	Operacion operacion1 = new OperacionActualizacionConstructor().construir();
	Operacion operacion2 = new OperacionActualizacionConstructor()
		.conCoordenada(new CoordenadaConstructor().conX("1").conY("2").conZ("3").construir()).construir();
	Operacion operacion3 = new OperacionConsultaConstructor().construir();
	Operacion operacion4 = new OperacionActualizacionConstructor()
		.conCoordenada(new CoordenadaConstructor().conX("1").conY("2").conZ("2").construir()).construir();
	Operacion operacion5 = new OperacionConsultaConstructor().construir();
	Operacion operacion6 = new OperacionActualizacionConstructor()
		.conCoordenada(new CoordenadaConstructor().conX("4").conY("4").conZ("4").construir()).construir();
	Operacion operacion7 = new OperacionConsultaConstructor()
		.conCoordenadaFinal(new CoordenadaConstructor().conX("3").construir()).construir();
	return agregarOperaciones(operaciones, operacion1, operacion2, operacion3, operacion4, operacion5, operacion6,
		operacion7);
    }

    public List<Operacion> agregarOperaciones(List<Operacion> operacionesLista, Operacion... operaciones) {
	for (Operacion operacion : operaciones) {
	    operacionesLista.add(operacion);
	}
	return operacionesLista;
    }

    @Test
    public void testCasoDePruebaUno() {

	// Arrangement
	List<Operacion> operaciones = casoPruebaUno();

	// Act
	List<Integer> respuesta = servicioProcesarOperaciones.procesarOperaciones(operaciones);

	// Assert
	Assert.assertTrue(respuesta.get(0) == CASOPRUEBAUNORESULTADO);
    }

    @Test
    public void testCasoDePruebaDos() {

	// Arrangement
	List<Operacion> operaciones = casoPruebaDos();

	// Act
	List<Integer> respuesta = servicioProcesarOperaciones.procesarOperaciones(operaciones);

	// Assert
	for (int iterador = 0; iterador < respuesta.size(); iterador++) {
	    Assert.assertTrue(respuesta.get(iterador) == CASOPRUEBADOSRESULTADO[iterador]);
	}
    }
}
