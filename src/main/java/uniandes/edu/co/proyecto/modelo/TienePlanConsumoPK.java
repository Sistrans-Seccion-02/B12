package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

 @Embeddable 

public class TienePlanConsumoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="Hotel_id", referencedColumnName = "id")
    private Hotel idHotel;

    @ManyToOne
    @JoinColumn(name="Plan_Consumo_id", referencedColumnName = "id")
    private PlanConsumo idPlanConsumo;

    public TienePlanConsumoPK(Hotel idHotel, PlanConsumo idPlanConsumo) {
        super();
        this.idHotel = idHotel;
        this.idPlanConsumo = idPlanConsumo;
    }

    public Hotel getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Hotel idHotel) {
        this.idHotel = idHotel;
    }

    public PlanConsumo getIdPlanConsumo() {
        return idPlanConsumo;
    }

    public void setIdPlanConsumo(PlanConsumo idPlanConsumo) {
        this.idPlanConsumo = idPlanConsumo;
    }

   
}