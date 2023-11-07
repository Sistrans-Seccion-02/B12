package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")
public class Habitacion {
    @Id//EmbeddedId si fuera llave compuesta, y se crea la clase etc.
    private Integer numero;

    @OneToOne
    @JoinColumn(name = "tiposhabitacion_nombre", referencedColumnName = "nombre")
    private TipoHabitacion tipoHabitacion;


    public Habitacion(Integer numero, TipoHabitacion tipo)
    {
        this.numero = numero;
        this.tipoHabitacion = tipo;
    }

    public Habitacion()
    {;}

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    


    
}
