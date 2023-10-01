package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="prestamos")

public class Prestamo extends Servicio {
    private Integer valor;
    private String estado;
    
    public Prestamo(String nombre, Integer capacidad, Integer valor, String estado) {
        super(nombre, capacidad);
        this.valor = valor;
        this.estado = estado;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}