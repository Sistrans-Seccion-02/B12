package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="internet")

public class Internet extends Servicio {
    private Integer costo_diario;
    
    public Internet(String nombre, Integer capacidad, Integer costo_diario) {
        super(nombre, capacidad);
        this.costo_diario = costo_diario;
    }

    public Integer getCosto_diario() {
        return costo_diario;
    }

    public void setCosto_diario(Integer costo_diario) {
        this.costo_diario = costo_diario;
    }
    
}