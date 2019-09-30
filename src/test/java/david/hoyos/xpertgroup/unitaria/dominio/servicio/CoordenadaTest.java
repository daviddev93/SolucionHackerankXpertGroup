package david.hoyos.xpertgroup.unitaria.dominio.servicio;


import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Test;
import david.hoyos.xpertgroup.dominio.excepcion.ExcepcionFormatoValor;
import david.hoyos.xpertgroup.dominio.modelo.Coordenada;

public class CoordenadaTest {

    @Test
    public void testCrearCoordenadaSeraExitoso() {

	// Act
	Coordenada coordenada = new Coordenada("4", "5", "6");

	// Assert
	Assert.assertTrue(coordenada.getX() == 4);
    }

    @Test
    public void testCrearCoordenadaSeEsperaExcepcion() {

	boolean excepcion = false;

	try {
	    // Act
	    new Coordenada("y", "5", "6");
	    fail();
	} catch (ExcepcionFormatoValor e) {
	    excepcion = true;
	}

	// Assert
	Assert.assertTrue(excepcion);
    }
}
