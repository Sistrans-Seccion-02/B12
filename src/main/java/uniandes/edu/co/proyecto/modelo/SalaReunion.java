/* 

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="salasreuniones")

public class SalaReunion {
    @Id
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    private Integer costo;
    private Integer capacidad;
    private Boolean equipo_extra;


    public SalaReunion(Servicio id_servicio, Integer costo, Integer capacidad, Boolean equipo_extra) {
        this.id_servicio = id_servicio;
        this.costo = costo;
        this.capacidad = capacidad;
        this.equipo_extra = equipo_extra;
    }

    public SalaReunion() 
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

    public Boolean getEquipo_extra() {
        return equipo_extra;
    }

    public void setEquipo_extra(Boolean equipo_extra) {
        this.equipo_extra = equipo_extra;
    }
  
    
}

*/
