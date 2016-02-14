/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Entity
@Table(name = "disease")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disease.findAll", query = "SELECT d FROM Disease d"),
    @NamedQuery(name = "Disease.findByDssId", query = "SELECT d FROM Disease d WHERE d.dssId = :dssId"),
    @NamedQuery(name = "Disease.findByDssName", query = "SELECT d FROM Disease d WHERE d.dssName = :dssName")})
public class Disease implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dss_id")
    private Integer dssId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dss_name")
    private String dssName;
    @JoinTable(name = "dss_mdr", joinColumns = {
        @JoinColumn(name = "dss_id", referencedColumnName = "dss_id")}, inverseJoinColumns = {
        @JoinColumn(name = "mdr_id", referencedColumnName = "mdr_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<MedicalRecord> medicalRecordCollection;

    public Disease() {
    }

    public Disease(Integer dssId) {
        this.dssId = dssId;
    }

    public Disease(Integer dssId, String dssName) {
        this.dssId = dssId;
        this.dssName = dssName;
    }

    public Integer getDssId() {
        return dssId;
    }

    public void setDssId(Integer dssId) {
        this.dssId = dssId;
    }

    public String getDssName() {
        return dssName;
    }

    public void setDssName(String dssName) {
        this.dssName = dssName;
    }

    @XmlTransient
    public Collection<MedicalRecord> getMedicalRecordCollection() {
        return medicalRecordCollection;
    }

    public void setMedicalRecordCollection(Collection<MedicalRecord> medicalRecordCollection) {
        this.medicalRecordCollection = medicalRecordCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dssId != null ? dssId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disease)) {
            return false;
        }
        Disease other = (Disease) object;
        if ((this.dssId == null && other.dssId != null) || (this.dssId != null && !this.dssId.equals(other.dssId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Disease[ dssId=" + dssId + " ]";
    }
    
}
