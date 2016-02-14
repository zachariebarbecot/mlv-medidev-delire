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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Entity
@Table(name = "doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByDtrId", query = "SELECT d FROM Doctor d WHERE d.dtrId = :dtrId"),
    @NamedQuery(name = "Doctor.findByDtrStatus", query = "SELECT d FROM Doctor d WHERE d.dtrStatus = :dtrStatus")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dtr_id")
    private Integer dtrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtr_status")
    private int dtrStatus;
    @OneToMany(mappedBy = "dtrId", fetch = FetchType.EAGER)
    private Collection<MedicalRecord> medicalRecordCollection;
    @JoinColumn(name = "ifm_id", referencedColumnName = "ifm_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Information ifmId;

    public Doctor() {
    }

    public Doctor(Integer dtrId) {
        this.dtrId = dtrId;
    }

    public Doctor(Integer dtrId, int dtrStatus) {
        this.dtrId = dtrId;
        this.dtrStatus = dtrStatus;
    }

    public Integer getDtrId() {
        return dtrId;
    }

    public void setDtrId(Integer dtrId) {
        this.dtrId = dtrId;
    }

    public int getDtrStatus() {
        return dtrStatus;
    }

    public void setDtrStatus(int dtrStatus) {
        this.dtrStatus = dtrStatus;
    }

    @XmlTransient
    public Collection<MedicalRecord> getMedicalRecordCollection() {
        return medicalRecordCollection;
    }

    public void setMedicalRecordCollection(Collection<MedicalRecord> medicalRecordCollection) {
        this.medicalRecordCollection = medicalRecordCollection;
    }

    public Information getIfmId() {
        return ifmId;
    }

    public void setIfmId(Information ifmId) {
        this.ifmId = ifmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtrId != null ? dtrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.dtrId == null && other.dtrId != null) || (this.dtrId != null && !this.dtrId.equals(other.dtrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Doctor[ dtrId=" + dtrId + " ]";
    }
    
}
