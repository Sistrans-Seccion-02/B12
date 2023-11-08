package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Consumos")
public class ConsumoHabitacion {
    @Id
    private Integer numeroHabitacion;
    private Double costo;

    
    public ConsumoHabitacion(Integer numeroHabitacion, Double costo) {
        this.numeroHabitacion = numeroHabitacion;
        this.costo = costo;
    }


    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }


    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }


    public Double getCosto() {
        return costo;
    }


    public void setCosto(Double costo) {
        this.costo = costo;
    }

    
}
