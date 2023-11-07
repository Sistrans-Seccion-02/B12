/* 

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="productos")

public class Producto {

    @Id
    private Integer codigo;

    private String nombre;
    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "id_bar", referencedColumnName = "id_servicio")
    private Bar idBar;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id_servicio")
    private Restaurante idRestaurante;

    @ManyToOne
    @JoinColumn(name = "id_supermercado", referencedColumnName = "id_servicio")
    private Supermercado idSupermercado;

    @ManyToOne
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_servicio")
    private Tienda idTienda;

    public Producto(Integer codigo, String nombre, Integer precio, Bar idBar, Restaurante idRestaurante,
            Supermercado idSupermercado, Tienda idTienda) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.idBar = idBar;
        this.idRestaurante = idRestaurante;
        this.idSupermercado = idSupermercado;
        this.idTienda = idTienda;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Bar getIdBar() {
        return idBar;
    }

    public void setIdBar(Bar idBar) {
        this.idBar = idBar;
    }

    public Restaurante getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Restaurante idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public Supermercado getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(Supermercado idSupermercado) {
        this.idSupermercado = idSupermercado;
    }

    public Tienda getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Tienda idTienda) {
        this.idTienda = idTienda;
    }

    

    


    
}


*/