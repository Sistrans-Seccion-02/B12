package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="consumos")
public class Consumo {
    @Id
    private Integer numero_factura;
    private Integer costo;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "habitaciones_numero", referencedColumnName = "numero")
    private Habitacion habitacion;
    //TODO toca hacer que referencia a la factura
    //private --- facturas_numero;

    public Consumo()
    {;}

    public Consumo(Integer numero_factura, Integer costo, Date fecha, Habitacion habitacion)
    {
        this.numero_factura = numero_factura;
        this.costo = costo;
        this.fecha = fecha;
        this.habitacion = habitacion;
    }

    public Integer getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(Integer numero_factura) {
        this.numero_factura = numero_factura;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    





    
}
