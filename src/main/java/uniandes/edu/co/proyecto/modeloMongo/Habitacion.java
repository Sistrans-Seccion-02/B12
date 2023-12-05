package uniandes.edu.co.proyecto.modeloMongo;

/* import java.util.Date;
import java.util.List; */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
/* import org.springframework.data.mongodb.core.mapping.DBRef; */
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "habitaciones")

public class Habitacion {
    @Id
    private String id;

    @Field("numero")
    private Integer numero;

    @DBRef
    private TipoHabitacion tipoHabitacion;

    @Field("estado")
    private String estado;

    public Habitacion(){}

    public Habitacion(Integer numero, String estado, Boolean minibar, Boolean cafetera, Integer diasEstadia, String idHotel){

        this.numero = numero;
        this.estado = estado;
    }

    // Constructor con todos los atributos de reserva y una lista de consumos
    public Habitacion(Integer numero, TipoHabitacion tipoHabitacion, String estado){
        
        this.numero = numero;
        this.tipoHabitacion = tipoHabitacion;
        this.estado = estado;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public Habitacion orElse(Object object) {
        return null;
    }

    

}