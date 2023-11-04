package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiene_servivio_habitacion")

public class TieneServicioHabitacion {

    @EmbeddedId
    private TieneServicioHabitacionPK pk;
    public TieneServicioHabitacion(Habitacion idHabitacion, ServicioHabitacion idServicioHabitacion){
        this.pk = new TieneServicioHabitacionPK(idHabitacion, idServicioHabitacion);
    }

    public TieneServicioHabitacion(){
        ;
    }

    public TieneServicioHabitacionPK getPk() {
        return pk;
    }

    public void setPk(TieneServicioHabitacionPK pk) {
        this.pk = pk;
    }
    
    
}
