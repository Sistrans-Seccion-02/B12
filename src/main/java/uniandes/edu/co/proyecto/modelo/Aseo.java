package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="aseos")

public class Aseo extends Servicio {
    private String nombre_aseo;
    private String tipo_prenda;
    private String numero;
    private Integer costo;
    
    public Aseo(String nombre, Integer capacidad, String nombre_aseo, String tipo_prenda,
    String numero, Integer costo ) {
        super(nombre, capacidad);
        this.nombre_aseo = nombre_aseo;
        this.tipo_prenda = tipo_prenda;
        this.numero = numero;
        this.costo = costo;
    }

    public String getNombre_aseo() {
        return nombre_aseo;
    }

    public void setNombre_aseo(String nombre_aseo) {
        this.nombre_aseo = nombre_aseo;
    }

    public String getTipo_prenda() {
        return tipo_prenda;
    }

    public void setTipo_prenda(String tipo_prenda) {
        this.tipo_prenda = tipo_prenda;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
    
}