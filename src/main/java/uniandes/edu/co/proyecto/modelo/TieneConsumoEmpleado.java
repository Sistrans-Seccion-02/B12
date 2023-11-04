package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiene_Consumo_Empleado")

public class TieneConsumoEmpleado {

    @EmbeddedId
    private TieneConsumoEmpleadoPK pk;
    public TieneConsumoEmpleado(Empleado idEmpleado, Consumo idConsumo){
        this.pk = new TieneConsumoEmpleadoPK(idEmpleado, idConsumo);
    }

    public TieneConsumoEmpleado(){
        ;
    }

    public TieneConsumoEmpleadoPK getPk() {
        return pk;
    }

    public void setPk(TieneConsumoEmpleadoPK pk) {
        this.pk = pk;
    }
    
    
}