package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

 @Embeddable 

public class TieneProductoSupermercadoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="Supermercado_id", referencedColumnName = "id")
    private Supermercado idSupermercado;

    @ManyToOne
    @JoinColumn(name="Producto_id", referencedColumnName = "id")
    private Producto idProducto;

    public TieneProductoSupermercadoPK(Supermercado idSupermercado, Producto idProducto) {
        super();
        this.idSupermercado = idSupermercado;
        this.idProducto = idProducto;
    }

    public Supermercado getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(Supermercado idSupermercado) {
        this.idSupermercado = idSupermercado;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

   
}
