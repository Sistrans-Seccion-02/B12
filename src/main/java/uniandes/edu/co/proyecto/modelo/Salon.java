package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="salones")
public class Salon extends Servicio {
    private Integer salon_id;
    private Integer servicio_id;
    private String tipo;
    private Integer costo_hora;
    private Integer costo_equipo;
    private Integer reserva_salon_id;

    public Salon (String nombre, Integer capacidad, Integer salon_id, Integer servicio_id, String tipo, Integer costo_hora, Integer cosot_equipo, Integer reserva_salon_id) {
        super(nombre,capacidad);
        this.salon_id = salon_id;
        this.servicio_id = servicio_id;
        this.tipo = tipo;
        this.costo_hora = costo_hora;
        this.costo_equipo = costo_equipo;
        this.reserva_salon_id = reserva_salon_id;
    }

    public Integer getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(Integer salon_id) {
        this.salon_id = salon_id;
    }

    public Integer getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(Integer servicio_id) {
        this.servicio_id = servicio_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCosto_hora() {
        return costo_hora;
    }

    public void setCosto_hora(Integer costo_hora) {
        this.costo_hora = costo_hora;
    }

    public Integer getCosto_equipo() {
        return costo_equipo;
    }

    public void setCosto_equipo(Integer costo_equipo) {
        this.costo_equipo = costo_equipo;
    }

    public Integer getReserva_salon_id() {
        return reserva_salon_id;
    }

    public void setReserva_salon_id(Integer reserva_salon_id) {
        this.reserva_salon_id = reserva_salon_id;
    }
}
