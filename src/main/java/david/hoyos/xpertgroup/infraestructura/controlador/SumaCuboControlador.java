package david.hoyos.xpertgroup.infraestructura.controlador;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import david.hoyos.xpertgroup.aplicacion.manejador.ManejadorProcesarOperaciones;
import david.hoyos.xpertgroup.aplicacion.modelo.EntradaOperacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/operaciones")
@Api(tags = { "Controlador operaciones" })
public class SumaCuboControlador {

    private final ManejadorProcesarOperaciones manejadorProcesarOperaciones;

    @Autowired
    public SumaCuboControlador(ManejadorProcesarOperaciones manejadorProcesarOperaciones) {
	this.manejadorProcesarOperaciones = manejadorProcesarOperaciones;
    }

    @SuppressWarnings("rawtypes")
    @PostMapping
    @ApiOperation("ejecutar Operaciones")
    public ResponseEntity ejecutarOperaciones(@RequestBody List<EntradaOperacion> operaciones) {
        System.out.println("changing for another one benefit");
	List<Integer> respuesta = new ArrayList<>();
	try {
	    respuesta = manejadorProcesarOperaciones.ejecutar(operaciones);
	    return ResponseEntity.status(HttpStatus.OK).body(respuesta);
	} catch (Exception e) {
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
    }
}
