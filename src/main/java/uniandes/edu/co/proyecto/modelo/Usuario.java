package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    private Integer numero_documento;
    private String tipo_documento;
    private String email;
    private String nombre;
    private Date fecha_entrada;
    private Date fecha_salida;



    @OneToOne
    @JoinColumn(name = "tiposusuario_nombre", referencedColumnName = "nombre")
    private TipoUsuario tipoUsuario;

    @OneToOne
    @JoinColumn(name = "planesconsumo_nombre", referencedColumnName = "nombre")
    private PlanConsumo planConsumo;


    public Usuario(Integer numero_documento, TipoUsuario tiposusuario_nombre, PlanConsumo planesconsumo_nombre, String email, String tipo_documento, String nombre, Date fecha_entrada, Date fecha_salida)
    {
        this.numero_documento = numero_documento;
        this.tipo_documento = tipo_documento;
        this.email = email;
        this.nombre = nombre;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.tipoUsuario = tiposusuario_nombre;
        this.planConsumo = planesconsumo_nombre;
    }

    public Usuario()
    {;}

    public Integer getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(Integer numero_documento) {
        this.numero_documento = numero_documento;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tiposusuario_nombre) {
        this.tipoUsuario = tiposusuario_nombre;
    }

    public PlanConsumo getPlanConsumo() {
        return planConsumo;
    }

    public void setPlanConsumo(PlanConsumo planesconsumo_nombre) {
        this.planConsumo = planesconsumo_nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo_Documento() {
        return tipo_documento;
    }

    public void setTipo_Documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaEntrada() {
        return fecha_entrada;
    }

    public void setFechaEntrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFechaSalida() {
        return fecha_salida;
    }

    public void setFechaSalida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

       

}
