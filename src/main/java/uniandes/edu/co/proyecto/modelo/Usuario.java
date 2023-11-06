package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")

public class Usuario {
    private Integer id;
    private String nombre;
    private String email;
    private String tipo;


    public Usuario(){;}

    public Usuario(String nombre, String email, String tipo)
    {
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return this.nombre+"|"+this.email+"|"+this.tipo;
    }
    
}
