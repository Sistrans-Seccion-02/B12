package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "recepcionistas")

public class Recepcionista extends Usuario {

    public Recepcionista(){
    }

    public Recepcionista(String nombre, String email, String tipo) {
        super(nombre, email, tipo);
    }
    
}
