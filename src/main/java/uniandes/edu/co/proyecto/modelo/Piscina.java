package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="piscinas")

public class Piscina {

    @EmbeddedId
    private PiscinaPK id_servicio;

    private String horario;
    private Integer capacidad;
    private Integer profundidad;
    
    

    public Piscina(Servicio id_servicio, String horario, Integer capacidad, Integer profundidad) {
        this.id_servicio = new PiscinaPK(id_servicio);
        this.horario = horario;
        this.capacidad = capacidad;
        this.profundidad = profundidad;
    }

    public Piscina()
    {;}

	public PiscinaPK getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(PiscinaPK id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(Integer profundidad) {
		this.profundidad = profundidad;
	}


  
}
