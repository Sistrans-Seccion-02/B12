package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="spas")

public class SPA extends Servicio {
    
    public SPA(String nombre, Integer capacidad, Integer profundidad) {
        super(nombre, capacidad);
    }
    
}