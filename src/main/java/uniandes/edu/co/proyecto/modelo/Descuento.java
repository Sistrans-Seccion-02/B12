package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="descuentos")

public class Descuento {
    private Integer id;
    private Integer porcentaje;

    public Descuento(){;}

    public Descuento(Integer porcentaje)
    {
        this.porcentaje = porcentaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

}
