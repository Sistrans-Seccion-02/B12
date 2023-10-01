package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planes")

public class PlanConsumo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Integer noches;
    private Integer costo;

    public PlanConsumo(){;}

    public PlanConsumo(String nombre, Integer noches, Integer costo)
    {
        this.nombre = nombre;
        this.noches = noches;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNoches() {
        return noches;
    }

    public void setNoches(Integer noches) {
        this.noches = noches;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @Override
    public String toString()
    {
        return this.nombre+"|"+this.noches+"|"+this.costo;
    }
    
}
