package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="servicios")

public class Servicio {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_servicio;



    private String descripcion;
    private String nombre;
    //private Consumo consumosNumeroFactura; -> Falta hacer esta clase de Consumo

    public Servicio(String descripcion, String nombre)
    {   
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Servicio()
    {;}

    public Integer getId() {
        return id_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
