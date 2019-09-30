package david.hoyos.xpertgroup.dominio.modelo;

public class Operacion {
    
    private Coordenada coordenadaReferencia;
    private String tipoOperacion;

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    protected void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    protected Coordenada getCoordenadaReferencia() {
        return coordenadaReferencia;
    }
    
    protected void  setCoordenadaReferencia(Coordenada coordenadaReferencia) {
	this.coordenadaReferencia = coordenadaReferencia;
    }


}
