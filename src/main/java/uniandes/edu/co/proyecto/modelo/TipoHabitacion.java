package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tiposhabitacion")
public  class TipoHabitacion {
    @Id
    private String nombre;
    private Integer capacidad;
    private Integer costo;

    public TipoHabitacion(String nombre, Integer capacidad, Integer costo)
    {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costo = costo;
    }

    public TipoHabitacion()
    {;}

    public String getNombre() {
        return nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

 
    

    
}
