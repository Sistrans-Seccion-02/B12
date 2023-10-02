package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

 @Embeddable 

public class TieneConsumoEmpleadoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="Empleado_id", referencedColumnName = "id")
    private Empleado idEmpleado;

    @ManyToOne
    @JoinColumn(name="Consumo_id", referencedColumnName = "id")
    private Consumo idConsumo;

    public TieneConsumoEmpleadoPK(Empleado idEmpleado, Consumo idConsumo) {
        super();
        this.idEmpleado = idEmpleado;
        this.idConsumo = idConsumo;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Consumo getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(Consumo idConsumo) {
        this.idConsumo = idConsumo;
    }

   
}