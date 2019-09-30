package david.hoyos.xpertgroup.aplicacion.fabrica;

import org.springframework.stereotype.Component;
import david.hoyos.xpertgroup.dominio.modelo.Coordenada;

@Component
public class FabricaCoordenada {
    
    /**
     * Metodo encargado de crear un objeto coordenada
     * 
     * @param datosOperacion
     * @param indicesCoordenadas
     * @return Coordenada
     */
    public Coordenada crear(String[] datosOperacion, Integer[] indicesCoordenadas) {
	String x =datosOperacion[indicesCoordenadas[0]];
	String y = datosOperacion[indicesCoordenadas[1]];
	String z =datosOperacion[indicesCoordenadas[2]];
	return new Coordenada(x, y, z);
    }
}
