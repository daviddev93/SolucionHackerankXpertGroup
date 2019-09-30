package david.hoyos.xpertgroup.integracion.infraestructura.controlador;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import david.hoyos.xpertgroup.aplicacion.manejador.ManejadorProcesarOperaciones;
import david.hoyos.xpertgroup.aplicacion.modelo.EntradaOperacion;
import david.hoyos.xpertgroup.dominio.excepcion.ExcepcionCoordenadaFueraDeRango;
import david.hoyos.xpertgroup.infraestructura.controlador.SumaCuboControlador;
import david.hoyos.xpertgroup.integracion.aplicacion.manejador.ManejadorProcesarOperacionesTest;

@RunWith(SpringRunner.class)
@WebMvcTest(SumaCuboControlador.class)
public class SumaCuboControladorTest {

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    ManejadorProcesarOperaciones manejadorProcesarOperaciones;

    @Test
    public void testMetodoSoloEscuchaPeticionesPost() throws JsonProcessingException, Exception {
	// arrange
	List<EntradaOperacion> operacionesEntrada = ManejadorProcesarOperacionesTest.casoPruebaUno();

	// act - assert
	mocMvc.perform(put("/operaciones").contentType(MediaType.APPLICATION_JSON_UTF8)
		.content(objectMapper.writeValueAsString(operacionesEntrada))).andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void testMetodoSeDevuelveBadRquestPorValidacionDesdeCapaDeNegocio()
	    throws JsonProcessingException, Exception {

	// arrange
	when(manejadorProcesarOperaciones.ejecutar(Mockito.any())).thenThrow(new ExcepcionCoordenadaFueraDeRango(""));
	List<EntradaOperacion> operacionesEntrada = ManejadorProcesarOperacionesTest.casoPruebaUno();

	// act - assert
	mocMvc.perform(post("/operaciones").contentType(MediaType.APPLICATION_JSON_UTF8)
		.content(objectMapper.writeValueAsString(operacionesEntrada))).andExpect(status().isBadRequest());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void testMetodoResuelveLaPeticionDeManeraExitosa() throws JsonProcessingException, Exception {
	// arrange
	List<EntradaOperacion> operacionesEntrada = ManejadorProcesarOperacionesTest.casoPruebaUno();

	// act - assert
	mocMvc.perform(post("/operaciones").contentType(MediaType.APPLICATION_JSON_UTF8)
		.content(objectMapper.writeValueAsString(operacionesEntrada))).andExpect(status().isOk());

	Class<ArrayList<EntradaOperacion>> listClass = (Class<ArrayList<EntradaOperacion>>) (Class) ArrayList.class;
	ArgumentCaptor<ArrayList<EntradaOperacion>> argument = ArgumentCaptor.forClass(listClass);

	verify(manejadorProcesarOperaciones, Mockito.times(1)).ejecutar(argument.capture());
	assertThat(argument.getAllValues().get(0).get(0).getTamanoMatriz()).isEqualTo(4);
    }

    @Test
    public void testMetodoRespondeBadRequestAJsonInvalidos() throws JsonProcessingException, Exception {

	// act - assert
	mocMvc.perform(post("/operaciones").contentType(MediaType.APPLICATION_JSON_UTF8)
		.content(objectMapper.writeValueAsString("json"))).andExpect(status().isBadRequest());
    }
}
