/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gemacron
 */
@Entity
@Table(name = "View_DatosDetallePagoOnline")
@NamedQueries({
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findAll", query = "SELECT v FROM ViewDatosDetallePagoOnline v"),
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findByIdentificador", query = "SELECT v FROM ViewDatosDetallePagoOnline v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findByCodArticulo", query = "SELECT v FROM ViewDatosDetallePagoOnline v WHERE v.codArticulo = :codArticulo"),
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findByDescripcion", query = "SELECT v FROM ViewDatosDetallePagoOnline v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findByPrecio", query = "SELECT v FROM ViewDatosDetallePagoOnline v WHERE v.precio = :precio"),
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findByCantidad", query = "SELECT v FROM ViewDatosDetallePagoOnline v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findByTotal", query = "SELECT v FROM ViewDatosDetallePagoOnline v WHERE v.total = :total"),
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findByIva", query = "SELECT v FROM ViewDatosDetallePagoOnline v WHERE v.iva = :iva"),
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findByTimbrado", query = "SELECT v FROM ViewDatosDetallePagoOnline v WHERE v.timbrado = :timbrado"),
    @NamedQuery(name = "ViewDatosDetallePagoOnline.findByVencimientoTimbrado", query = "SELECT v FROM ViewDatosDetallePagoOnline v WHERE v.vencimientoTimbrado = :vencimientoTimbrado")})
public class ViewDatosDetallePagoOnline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Identificador")
    private int identificador;
    @Basic(optional = false)
    @Column(name = "CodArticulo")
    private int codArticulo;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "Total")
    private BigDecimal total;
    @Column(name = "Iva")
    private BigDecimal iva;
    @Column(name = "Timbrado")
    private Long timbrado;
    @Column(name = "VencimientoTimbrado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vencimientoTimbrado;

    public ViewDatosDetallePagoOnline() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public Long getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(Long timbrado) {
        this.timbrado = timbrado;
    }

    public Date getVencimientoTimbrado() {
        return vencimientoTimbrado;
    }

    public void setVencimientoTimbrado(Date vencimientoTimbrado) {
        this.vencimientoTimbrado = vencimientoTimbrado;
    }
    
}
