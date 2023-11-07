/* 

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="salasconferencias")

public class SalaConferencia {
    @Id
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    private Integer costo;
    private Integer capacidad;

    
    public SalaConferencia(Servicio id_servicio, Integer costo, Integer capacidad) {
        this.id_servicio = id_servicio;
        this.costo = costo;
        this.capacidad = capacidad;
    }

    public SalaConferencia() 
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


    public Integer getCapacidad() {
        return capacidad;
    }


    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    

    
}

*/
