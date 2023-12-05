package uniandes.edu.co.proyecto.modeloMongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "llegadaSalidas")

public class LLegadaSalida {
    @Id
    private Integer id;

    @Field
    private Date fecha;

    @Field
    private String tipo;

    @DBRef
    private Reserva reserva;

    

    public LLegadaSalida(Integer id, Date fecha, String tipo) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    

    public LLegadaSalida(Integer id, Date fecha, String tipo, Reserva reserva) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.reserva = reserva;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    
    
}
