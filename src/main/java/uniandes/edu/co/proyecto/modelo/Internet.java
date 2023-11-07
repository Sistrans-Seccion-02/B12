/* 
package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="internets")


public class Internet {

    @Id
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;
    
    private String capacidad;
    private Integer costo;


    public Internet(Servicio id_servicio, String capacidad, Integer costo) {
        this.id_servicio = id_servicio;
        this.capacidad = capacidad;
        this.costo = costo;
    }

    public Internet()
    {;}

    public Servicio getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    
}

*/
