/* 

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="tiendas")

public class Tienda {
    @Id
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    public Tienda(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Tienda() 
    {;}

    public Servicio getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    
  
    
}

*/
