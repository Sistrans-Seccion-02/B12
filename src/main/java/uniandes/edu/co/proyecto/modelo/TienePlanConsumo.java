package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiene_plan_consumo")

public class TienePlanConsumo {

    @EmbeddedId
    private TienePlanConsumoPK pk;
    public TienePlanConsumo(Hotel idHotel, PlanConsumo idPlanConsumo){
        this.pk = new TienePlanConsumoPK(idHotel, idPlanConsumo);
    }

    public TienePlanConsumo(){
        ;
    }

    public TienePlanConsumoPK getPk() {
        return pk;
    }

    public void setPk(TienePlanConsumoPK pk) {
        this.pk = pk;
    }
    
    
}