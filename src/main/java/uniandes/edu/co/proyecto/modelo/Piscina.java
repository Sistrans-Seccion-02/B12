package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="piscinas")

public class Piscina extends Servicio {
    private Integer profundidad;
    
    public Piscina(String nombre, Integer capacidad, Integer profundidad) {
        super(nombre, capacidad);
        this.profundidad = profundidad;
    }
    
    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }
    
}