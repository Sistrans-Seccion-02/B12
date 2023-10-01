package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios_habitacion")

public class ServicioHabitacion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String tipo_servicio;
    private Boolean contratado;

    public ServicioHabitacion(String tipo_servicio, Boolean contratado)
    {
        this.tipo_servicio = tipo_servicio;
        this.contratado = contratado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoServicio() {
        return tipo_servicio;
    }

    public void setTipoServicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public Boolean getContratado() {
        return contratado;
    }

    public void setContratado(Boolean contratado) {
        this.contratado = contratado;
    }

    @Override
    public String toString()
    {
        return this.tipo_servicio+"|"+this.contratado;
    }
    
}
