package uniandes.edu.co.proyecto.modeloMongo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "clientes")
public class Cliente {

    @Id
    private Integer id;

    @Field
    private String nombre;

    @Field 
    private String apellido;

    @Field 
    private List<String> datosAdicionales;

    @DBRef
    private Habitacion habitacion;

    public Cliente(Integer id, String nombre, String apellido, List<String> datosAdicionales) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.datosAdicionales = datosAdicionales;
    }

    public Cliente(Integer id, String nombre, String apellido, List<String> datosAdicionales, Habitacion habitacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.datosAdicionales = datosAdicionales;
        this.habitacion = habitacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getDatosAdicionales() {
        return datosAdicionales;
    }

    public void setDatosAdicionales(List<String> datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    
    
}
