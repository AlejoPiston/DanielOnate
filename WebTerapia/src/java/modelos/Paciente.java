/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import static modelos.Terapia_.fecha;

/**
 *
 * @author Liz
 */
@Entity
@Table(name = "PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByPacienteid", query = "SELECT p FROM Paciente p WHERE p.pacienteid = :pacienteid")
    , @NamedQuery(name = "Paciente.findByCedula", query = "SELECT p FROM Paciente p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Paciente.findByFechanacimiento", query = "SELECT p FROM Paciente p WHERE p.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Paciente.findByEstatura", query = "SELECT p FROM Paciente p WHERE p.estatura = :estatura")
    , @NamedQuery(name = "Paciente.findByPeso", query = "SELECT p FROM Paciente p WHERE p.peso = :peso")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PACIENTEID")
    private Integer pacienteid;
    @Size(max = 15)
    @Column(name = "CEDULA")
    private String cedula;
    @Size(max = 35)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "ESTATURA")
    private Integer estatura;
    @Column(name = "PESO")
    private Integer peso;
    @OneToMany(mappedBy = "paciente")
    private List<Terapia> terapias;

    public Paciente() {
    }

    public Paciente(Integer pacienteid) {
        this.pacienteid = pacienteid;
    }
    
    public String getEdad(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        LocalDate fecha = LocalDate.parse(getNacimiento(),fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fecha, ahora);
        return String.valueOf(periodo.getYears());
    }
    
    public Integer getPacienteid() {
        return pacienteid;
    }

    public void setPacienteid(Integer pacienteid) {
        this.pacienteid = pacienteid;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanacimiento() {
      return fechanacimiento;
    }

 
    public String getNacimiento() {
      DateFormat df= new SimpleDateFormat("dd/MMM/yyyy");
      return df.format(fechanacimiento);
    }
 
    public String getFecha() {
      DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
      return df.format(fechanacimiento);
    }         
     
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
    public String getAltura(){
        float a = (float)(estatura*0.01);
        return Float.toString(a).concat("m");
    }

    public Integer getEstatura() {
        return estatura;
    }

       
    public void setEstatura(Integer estatura) {
        this.estatura = estatura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    @XmlTransient
    public List<Terapia> getTerapiaList() {
        return terapias;
    }

    public void setTerapiaList(List<Terapia> terapiaList) {
        this.terapias = terapiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacienteid != null ? pacienteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pacienteid == null && other.pacienteid != null) || (this.pacienteid != null && !this.pacienteid.equals(other.pacienteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Paciente[ pacienteid=" + pacienteid + " ]";
    }
    
}
