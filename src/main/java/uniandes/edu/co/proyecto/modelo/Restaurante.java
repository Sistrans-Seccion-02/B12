package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantes")

public class Restaurante extends Bar{

    public Restaurante(String nombre) {
        super(nombre);
    }
    
}
