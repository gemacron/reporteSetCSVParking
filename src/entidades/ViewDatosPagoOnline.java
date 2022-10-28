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
 * @author EGLOBALT
 */
@Entity
@Table(name = "View_DatosPagoOnline")
@NamedQueries({
    @NamedQuery(name = "ViewDatosPagoOnline.findAll", query = "SELECT v FROM ViewDatosPagoOnline v"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByIdentificador", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByIdCliente", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.idCliente = :idCliente"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByNombreCliente", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByModulo", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.modulo = :modulo"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByFechaPago", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.fechaPago = :fechaPago"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByValorPago", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.valorPago = :valorPago"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByFactura", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.factura = :factura"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByTipoVehiculo", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.tipoVehiculo = :tipoVehiculo"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByEsPagoMensualidad", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.esPagoMensualidad = :esPagoMensualidad"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByConvenio", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.convenio = :convenio"),
    @NamedQuery(name = "ViewDatosPagoOnline.findByMedioPago", query = "SELECT v FROM ViewDatosPagoOnline v WHERE v.medioPago = :medioPago")})
public class ViewDatosPagoOnline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Identificador")
    private int identificador;
    @Column(name = "Id_Cliente")
    private String idCliente;
    @Basic(optional = false)
    @Column(name = "Nombre_Cliente")
    private String nombreCliente;
    @Column(name = "Modulo")
    private String modulo;
    @Basic(optional = false)
    @Column(name = "FechaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ValorPago")
    private BigDecimal valorPago;
    @Basic(optional = false)
    @Column(name = "Factura")
    private String factura;
    @Column(name = "TipoVehiculo")
    private String tipoVehiculo;
    @Basic(optional = false)
    @Column(name = "EsPagoMensualidad")
    private String esPagoMensualidad;
    @Column(name = "Convenio")
    private String convenio;
    @Column(name = "MedioPago")
    private String medioPago;

    public ViewDatosPagoOnline() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getEsPagoMensualidad() {
        return esPagoMensualidad;
    }

    public void setEsPagoMensualidad(String esPagoMensualidad) {
        this.esPagoMensualidad = esPagoMensualidad;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }
    
}
