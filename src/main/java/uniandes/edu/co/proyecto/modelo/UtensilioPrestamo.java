/* 

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="utensiliosprestamo")

public class UtensilioPrestamo {

    @Id
    @OneToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    private Boolean prestado;
    private Boolean devuelto;
    private Boolean mal_estado;
    private Integer costo_extra;


    public UtensilioPrestamo(Servicio id_servicio, Boolean prestado, Boolean devuelto, Boolean mal_estado,
            Integer costo_extra) {
        this.id_servicio = id_servicio;
        this.prestado = prestado;
        this.devuelto = devuelto;
        this.mal_estado = mal_estado;
        this.costo_extra = costo_extra;
    }

    public UtensilioPrestamo() 
    {;}

    public Servicio getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public Boolean getMal_estado() {
        return mal_estado;
    }

    public void setMal_estado(Boolean mal_estado) {
        this.mal_estado = mal_estado;
    }

    public Integer getCosto_extra() {
        return costo_extra;
    }

    public void setCosto_extra(Integer costo_extra) {
        this.costo_extra = costo_extra;
    }

    


    
}

*/
