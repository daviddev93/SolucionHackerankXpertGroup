package david.hoyos.xpertgroup.unitaria.dominio.servicio;

import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Test;
import david.hoyos.xpertgroup.dominio.excepcion.ExcepcionCoordenadaFueraDeRango;
import david.hoyos.xpertgroup.dominio.modelo.Coordenada;
import david.hoyos.xpertgroup.dominio.modelo.OperacionConsulta;

public class OperacionConsultaTest {
    
    @Test
    public void testCrearOperacionConsultaSeraExitoso() {
	//Arrangement
	Coordenada coordenadaReferencia = new Coordenada("4", "5", "6");
	Coordenada coordenadaFinal = new Coordenada("6", "6", "6");
	
	// Act
	OperacionConsulta operacionConsulta = new OperacionConsulta(coordenadaReferencia, coordenadaFinal,6);
	
	// Assert
	Assert.assertTrue(operacionConsulta.getCoordenadaFinal().getX()==6);
    }
    
    
    @Test
    public void testCrearOperacionConsultaSeEsperaExcepcion() {
	//Arrangement
	boolean excepcion = false;
	Coordenada coordenadaReferencia = new Coordenada("4", "5", "6");
	Coordenada coordenadaFinal = new Coordenada("6", "6", "6");
	
	try {
	// Act
	 new OperacionConsulta(coordenadaReferencia, coordenadaFinal,5);
	 fail();
	}
	catch(ExcepcionCoordenadaFueraDeRango e) {
	    excepcion = true;
	}
	// Assert
	Assert.assertTrue(excepcion);
    }
}
