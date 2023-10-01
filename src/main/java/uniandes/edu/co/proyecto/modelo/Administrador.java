package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")

public class Administrador extends Usuario {

    public Administrador(){
    }

    public Administrador(String nombre, String email, String tipo) {
        super(nombre, email, tipo);
    }
    
}
