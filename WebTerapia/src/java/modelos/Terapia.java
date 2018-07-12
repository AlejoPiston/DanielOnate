/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Liz
 */
@Entity
@Table(name = "TERAPIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terapia.findAll", query = "SELECT t FROM Terapia t")
    , @NamedQuery(name = "Terapia.findByTerapiaid", query = "SELECT t FROM Terapia t WHERE t.terapiaid = :terapiaid")
    , @NamedQuery(name = "Terapia.findByFecha", query = "SELECT t FROM Terapia t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Terapia.findByObservacion", query = "SELECT t FROM Terapia t WHERE t.observacion = :observacion")
    , @NamedQuery(name = "Terapia.findByResponsable", query = "SELECT t FROM Terapia t WHERE t.responsable = :responsable")
    , @NamedQuery(name = "Terapia.findByRealizada", query = "SELECT t FROM Terapia t WHERE t.realizada = :realizada")})
public class Terapia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TERAPIAID")
    private Integer terapiaid;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 255)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 10)
    @Column(name = "RESPONSABLE")
    private String responsable;
    @Column(name = "REALIZADA")
    private Boolean realizada;
    @JoinColumn(name = "PACIENTEID", referencedColumnName = "PACIENTEID")
    @ManyToOne
    private Paciente paciente;

    public Terapia() {
    }

    public Terapia(Integer terapiaid) {
        this.terapiaid = terapiaid;
    }

    public Integer getTerapiaid() {
        return terapiaid;
    }

    public void setTerapiaid(Integer terapiaid) {
        this.terapiaid = terapiaid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    public Paciente getPacienteid() {
        return paciente;
    }

    public void setPacienteid(Paciente pacienteid) {
        this.paciente = pacienteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (terapiaid != null ? terapiaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terapia)) {
            return false;
        }
        Terapia other = (Terapia) object;
        if ((this.terapiaid == null && other.terapiaid != null) || (this.terapiaid != null && !this.terapiaid.equals(other.terapiaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Terapia[ terapiaid=" + terapiaid + " ]";
    }
    
}
