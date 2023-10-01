package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiendas")
public class Tienda extends Supermercado {

    private String tipo_tienda;

    public Tienda(String nombre, String tipo_tienda) {
        super(nombre);
        this.tipo_tienda = tipo_tienda;
    }

    public String getTipoTienda() {
        return tipo_tienda;
    }

    public void setTipoTienda(String tipo_tienda) {
        this.tipo_tienda = tipo_tienda;
    }
    
}
