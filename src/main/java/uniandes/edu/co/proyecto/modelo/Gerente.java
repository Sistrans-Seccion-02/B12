package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gerentes")

public class Gerente extends Usuario {

    public Gerente(){
    }

    public Gerente(String nombre, String email, String tipo) {
        super(nombre, email, tipo);
    }
    
}
