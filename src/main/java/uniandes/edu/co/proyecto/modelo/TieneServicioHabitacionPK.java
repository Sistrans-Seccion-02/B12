package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

 @Embeddable 

public class TieneServicioHabitacionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="Habitacion_id", referencedColumnName = "id")
    private Habitacion idHabitacion;

    @ManyToOne
    @JoinColumn(name="Servicio_Habitacion_id", referencedColumnName = "id")
    private ServicioHabitacion idServicioHabitacion;

    public TieneServicioHabitacionPK(Habitacion idHabitacion, ServicioHabitacion idServicioHabitacion) {
        super();
        this.idHabitacion = idHabitacion;
        this.idServicioHabitacion = idServicioHabitacion;
    }

    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public ServicioHabitacion getIdServicioHabitacion() {
        return idServicioHabitacion;
    }

    public void setIdServicioHabitacion(ServicioHabitacion idServicioHabitacion) {
        this.idServicioHabitacion = idServicioHabitacion;
    }

   
}
