package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")

public class Cliente extends Usuario {

    public Cliente(){
    }

    public Cliente(String nombre, String email, String tipo) {
        super(nombre, email, tipo);
    }
    
}
