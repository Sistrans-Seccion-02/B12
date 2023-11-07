/* 
package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="lavanderias")

public class Lavanderia {

    @Id
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    private Integer costo;

    public Lavanderia(Servicio id_servicio, Integer costo) {
        this.id_servicio = id_servicio;
        this.costo = costo;
    }

    public Lavanderia() 
    {;}

    public Servicio getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

   
}

*/
