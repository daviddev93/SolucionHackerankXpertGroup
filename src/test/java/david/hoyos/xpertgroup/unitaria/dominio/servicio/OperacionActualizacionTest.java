package david.hoyos.xpertgroup.unitaria.dominio.servicio;

import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Test;
import david.hoyos.xpertgroup.dominio.excepcion.ExcepcionCoordenadaFueraDeRango;
import david.hoyos.xpertgroup.dominio.excepcion.ExcepcionFormatoValor;
import david.hoyos.xpertgroup.dominio.modelo.Coordenada;
import david.hoyos.xpertgroup.dominio.modelo.OperacionActualizacion;

public class OperacionActualizacionTest {

    @Test
    public void testCrearOperacionActualizacionSeraExitoso() {
	// Arrangement
	Coordenada coordenadaReferencia = new Coordenada("4", "5", "6");

	// Act
	OperacionActualizacion operacionActualizacion = new OperacionActualizacion(coordenadaReferencia, "86", 6);

	// Assert
	Assert.assertTrue(operacionActualizacion.getValor()== 86);
    }

    @Test
    public void testCrearOperacionActualizacionSeraUnaExcepcionFormatoValor() {
	// Arrangement
	boolean excepcion = false;
	Coordenada coordenadaReferencia = new Coordenada("4", "5", "6");

	try {
	    // Act
	    new OperacionActualizacion(coordenadaReferencia, "xx", 6);
	    fail();
	} catch (ExcepcionFormatoValor e) {
	    excepcion = true;
	}
	// Assert
	Assert.assertTrue(excepcion);
    }
    
    @Test
    public void testCrearOperacionActualizacionSeraUnaExcepcionconYFueraDeRango() {
	// Arrangement
	boolean excepcion = false;
	Coordenada coordenadaReferencia = new Coordenada("2", "5", "6");

	try {
	    // Act
	    new OperacionActualizacion(coordenadaReferencia, "86", 3);
	    fail();
	} catch (ExcepcionCoordenadaFueraDeRango e) {
	    excepcion = true;
	}
	// Assert
	Assert.assertTrue(excepcion);
    }
    
    @Test
    public void testCrearOperacionActualizacionSeraUnaExcepcionconZFueraDeRango() {
	// Arrangement
	boolean excepcion = false;
	Coordenada coordenadaReferencia = new Coordenada("2", "3", "6");

	try {
	    // Act
	    new OperacionActualizacion(coordenadaReferencia, "86", 3);
	    fail();
	} catch (ExcepcionCoordenadaFueraDeRango e) {
	    excepcion = true;
	}
	// Assert
	Assert.assertTrue(excepcion);
    }
}
