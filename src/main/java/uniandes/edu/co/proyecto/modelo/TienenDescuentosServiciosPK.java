package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

 @Embeddable 

public class TienenDescuentosServiciosPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="Descuento_id", referencedColumnName = "id")
    private Descuento idDescuento;

    @ManyToOne
    @JoinColumn(name="Servicio_id", referencedColumnName = "id")
    private Servicio idServicio;

    public TienenDescuentosServiciosPK(Descuento idDescuento, Servicio idServicio) {
        super();
        this.idDescuento = idDescuento;
        this.idServicio = idServicio;
    }

    public Descuento getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Descuento idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

   
}