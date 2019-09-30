package david.hoyos.xpertgroup.aplicacion.modelo;

import java.util.List;
import javax.validation.constraints.NotNull;


public class EntradaOperacion {
    
    @NotNull
    private Integer tamanoMatriz;
    private List<String> operaciones;
    
    
    public Integer getTamanoMatriz() {
        return tamanoMatriz;
    }
    public void setTamanoMatriz(Integer tamanoMatriz) {
        this.tamanoMatriz = tamanoMatriz;
    }
    public List<String> getOperaciones() {
        return operaciones;
    }
    public void setOperaciones(List<String> operaciones) {
        this.operaciones = operaciones;
    }
    
}
