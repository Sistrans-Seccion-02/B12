package uniandes.edu.co.proyecto.modeloMongo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "consumos")
public class Consumo {
    @Id
    private Integer id;

    @Field
    private Date fecha;

    @Field 
    private Integer costo;

    @Field
    private String descripcion;

    @DBRef
    private List<Servicio> servicios;

    @DBRef
    private Habitacion habitacionId;

    public Consumo(Integer id, Date fecha, Integer costo, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public Consumo(Integer id, Date fecha, Integer costo, String descripcion, List<Servicio> servicios,
            Habitacion habitacionId) {
        this.id = id;
        this.fecha = fecha;
        this.costo = costo;
        this.descripcion = descripcion;
        this.servicios = servicios;
        this.habitacionId = habitacionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Habitacion getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Habitacion habitacionId) {
        this.habitacionId = habitacionId;
    }

    
    
}
