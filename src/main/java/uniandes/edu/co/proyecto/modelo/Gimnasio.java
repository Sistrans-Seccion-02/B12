/* 

package uniandes.edu.co.proyecto.modelo;


import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="gimnasios")

public class Gimnasio {
    @Id
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;
    

    private Date horario;
    private Integer capacidad;

    

    public Gimnasio(Servicio id_servicio, Date horario, Integer capacidad) {
        this.id_servicio = id_servicio;
        this.horario = horario;
        this.capacidad = capacidad;
    }

    public Gimnasio()
    {;}

    public Servicio getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    

    

}

*/







