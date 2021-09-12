package javeriana.ms.restador.model;

public class Operacion {
    private String tipoOperacion;
    private String fecha;
    private String user;

    public Operacion() {
    }

    public Operacion(String tipoOperacion, String fecha, String user) {
        this.tipoOperacion = tipoOperacion;
        this.fecha = fecha;
        this.user = user;
    }

    public String getTipo() {
        return tipoOperacion;
    }

    public void setTipo(String tipo) {
        this.tipoOperacion = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
