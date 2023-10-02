package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Tienen_Descuentos_Servicios")

public class TienenDescuentosServicios {

    @EmbeddedId
    private TienenDescuentosServicios pk;
    public TienenDescuentosServicios(Servicio idServicio, Descuento idDescuento){
        this.pk = new TienenDescuentosServicios(idServicio, idDescuento);
    }

    public TienenDescuentosServicios(){
        ;
    }

    public TienenDescuentosServicios getPk() {
        return pk;
    }

    public void setPk(TienenDescuentosServicios pk) {
        this.pk = pk;
    }
    
    
}