package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteles")


public class Hotel {
    private Integer id;
    private String nombre;
    private String ciudad;
    private String pais;
    private String direccion;
    private Integer capacidad;
    private Integer estrellas;

    public Hotel(){;}

    public Hotel(String nombre, String ciudad, String pais, String direccion, Integer capacidad, Integer estrellas)
    {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.estrellas = estrellas;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    @Override
    public String toString()
    {
        return this.nombre+"|"+this.ciudad+"|"+this.pais+"|"+this.direccion+"|"+this.capacidad+"|"+this.estrellas;
    }
}
