package uniandes.edu.co.proyecto.modeloMongo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "TipoHabitaciones")
public class TipoHabitacion {

    @Id
    private String id;

    @Field("nombre")
    private String nombre; 

    // Constructor vacio para el uso de Spring
    public TipoHabitacion(){}

    // Constructor con solo el nombre del tipo de habitacion
    public TipoHabitacion(String nombre){
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}