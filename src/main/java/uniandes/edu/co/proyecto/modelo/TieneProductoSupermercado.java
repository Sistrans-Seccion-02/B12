package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiene_producto_supermercado")

public class TieneProductoSupermercado {

    @EmbeddedId
    private TieneProductoSupermercadoPK pk;
    public TieneProductoSupermercado(Supermercado idSupermercado, Producto idProducto){
        this.pk = new TieneProductoSupermercadoPK(idSupermercado, idProducto);
    }

    public TieneProductoSupermercado(){
        ;
    }

    public TieneProductoSupermercadoPK getPk() {
        return pk;
    }

    public void setPk(TieneProductoSupermercadoPK pk) {
        this.pk = pk;
    }
    
    
}