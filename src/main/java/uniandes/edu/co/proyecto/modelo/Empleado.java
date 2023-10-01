package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")

public class Empleado extends Usuario {

    public Empleado(){
    }

    public Empleado(String nombre, String email, String tipo) {
        super(nombre, email, tipo);
    }
    
}
