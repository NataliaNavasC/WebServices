package WSClient.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Paseo {
    private int ID;
    private String nombre;
    private String lugarSalida;
    private String lugarLlegada;
    private String fecha;

    public Paseo() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugarSalida() {
        return lugarSalida;
    }

    public void setLugarSalida(String lugarSalida) {
        this.lugarSalida = lugarSalida;
    }

    public String getLugarLlegada() {
        return lugarLlegada;
    }

    public void setLugarLlegada(String lugarLlegada) {
        this.lugarLlegada = lugarLlegada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Paseo{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", lugarSalida='" + lugarSalida + '\'' +
                ", lugarLlegada='" + lugarLlegada + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
