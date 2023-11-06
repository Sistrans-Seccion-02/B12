package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="consumibles")


public class Consumible {
    private Integer id;
    private String consumible;
    private Integer valor;

    public Consumible(){;}

    public Consumible(String consumible, Integer valor)
    {
        this.consumible = consumible;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsumible() {
        return consumible;
    }

    public void setConsumible(String consumible) {
        this.consumible = consumible;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString()
    {
        return this.consumible+"|"+this.valor;
    }
    
}
