package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="reservasSalones")

public class Reservasalon {
    private Integer id;
    private Boolean usa_equipos;
    private String fecha;
    private Integer hora;
    private Integer duracion;
    private Integer limpieza;
    private Integer costo;

    public Reservasalon(){;}

    public Reservasalon(String nombre, Boolean usa_equipos, String fecha, Integer hora,
    Integer duracion, Integer limpieza, Integer costo)
    {
        this.usa_equipos = usa_equipos;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.limpieza = limpieza;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getUsa_equipos() {
        return usa_equipos;
    }

    public void setUsa_equipos(Boolean usa_equipos) {
        this.usa_equipos = usa_equipos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(Integer limpieza) {
        this.limpieza = limpieza;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
    
}
