/* 

package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.*;

@Entity
@Table(name="supermercados")


public class Supermercado {

    @Id
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    public Supermercado(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Supermercado() 
    {;}

    public Servicio getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    
}

*/
