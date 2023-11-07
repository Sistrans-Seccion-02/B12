package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class PiscinaPK implements Serializable{
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private Servicio id_servicio;

	public PiscinaPK(Servicio id_servicio) {
        super();
		this.id_servicio = id_servicio;
	}

	public Servicio getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Servicio id_servicio) {
		this.id_servicio = id_servicio;
	}

    
	
}
