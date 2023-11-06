package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")


public class Habitacion {
    private Integer numero;
    private String tipo;
    private Integer costo;
    private Integer capacidad;

    public Habitacion(){;}

    public Habitacion(Integer numero, String tipo, Integer costo, Integer capacidad)
    {
        this.numero = numero;
        this.tipo = tipo;
        this.costo = costo;
        this.capacidad = capacidad;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString()
    {
        return this.numero+"|"+this.tipo+"|"+this.costo+"|"+this.capacidad;
    }
    
}
