/* 

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="restaurantes")


public class Restaurante {
    @Id
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    private Integer capacidad;
    private String estilo;


    public Restaurante(Servicio id_servicio, Integer capacidad, String estilo) {
        this.id_servicio = id_servicio;
        this.capacidad = capacidad;
        this.estilo = estilo;
    }

    public Restaurante()
    {;}

    public Servicio getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }


    
    
}

*/
