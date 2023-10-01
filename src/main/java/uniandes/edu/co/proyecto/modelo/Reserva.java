package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")

public class Reserva {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String fecha_entrada;
    private String fecha_salida;
    private Integer personas;
    private String check_in;
    private String check_out;
    private Boolean paz_salvo;

    public Reserva(){;}

    public Reserva(String fecha_entrada, String fecha_salida, Integer personas, String check_in, String check_out, Boolean paz_salvo)
    {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.personas = personas;
        this.check_in = check_in;
        this.check_out = check_out;
        this.paz_salvo = paz_salvo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Integer getPersonas() {
        return personas;
    }

    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public Boolean getPaz_salvo() {
        return paz_salvo;
    }

    public void setPaz_salvo(Boolean paz_salvo) {
        this.paz_salvo = paz_salvo;
    }

    @Override
    public String toString()
    {
        return this.fecha_entrada+"|"+this.fecha_salida+"|"+this.personas+"|"+this.check_in+"|"+this.check_out+"|"+this.paz_salvo;
    }
    
}
