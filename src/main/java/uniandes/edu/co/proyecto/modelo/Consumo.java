package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Consumos")


public class Consumo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String Consumo;
    private Integer valor;

    public Consumo(){;}

    public Consumo(String Consumo, Integer valor)
    {
        this.Consumo = Consumo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsumo() {
        return Consumo;
    }

    public void setConsumo(String Consumo) {
        this.Consumo = Consumo;
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
        return this.Consumo+"|"+this.valor;
    }
    
}