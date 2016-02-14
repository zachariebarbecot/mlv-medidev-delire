/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRlId", query = "SELECT r FROM Role r WHERE r.rlId = :rlId"),
    @NamedQuery(name = "Role.findByRlName", query = "SELECT r FROM Role r WHERE r.rlName = :rlName")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rl_id")
    private Integer rlId;
    @Size(max = 128)
    @Column(name = "rl_name")
    private String rlName;
    @OneToMany(mappedBy = "rlId", fetch = FetchType.EAGER)
    private Collection<MedicalRecord> medicalRecordCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rlId", fetch = FetchType.EAGER)
    private Collection<Staff> staffCollection;

    public Role() {
    }

    public Role(Integer rlId) {
        this.rlId = rlId;
    }

    public Integer getRlId() {
        return rlId;
    }

    public void setRlId(Integer rlId) {
        this.rlId = rlId;
    }

    public String getRlName() {
        return rlName;
    }

    public void setRlName(String rlName) {
        this.rlName = rlName;
    }

    @XmlTransient
    public Collection<MedicalRecord> getMedicalRecordCollection() {
        return medicalRecordCollection;
    }

    public void setMedicalRecordCollection(Collection<MedicalRecord> medicalRecordCollection) {
        this.medicalRecordCollection = medicalRecordCollection;
    }

    @XmlTransient
    public Collection<Staff> getStaffCollection() {
        return staffCollection;
    }

    public void setStaffCollection(Collection<Staff> staffCollection) {
        this.staffCollection = staffCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rlId != null ? rlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.rlId == null && other.rlId != null) || (this.rlId != null && !this.rlId.equals(other.rlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Role[ rlId=" + rlId + " ]";
    }
    
}
