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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findBySvcId", query = "SELECT s FROM Service s WHERE s.svcId = :svcId"),
    @NamedQuery(name = "Service.findBySvcName", query = "SELECT s FROM Service s WHERE s.svcName = :svcName")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "svc_id")
    private Integer svcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "svc_name")
    private String svcName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "svcId", fetch = FetchType.EAGER)
    private Collection<FunctionalUnit> functionalUnitCollection;
    @JoinColumn(name = "dvs_id", referencedColumnName = "dvs_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Division dvsId;

    public Service() {
    }

    public Service(Integer svcId) {
        this.svcId = svcId;
    }

    public Service(Integer svcId, String svcName) {
        this.svcId = svcId;
        this.svcName = svcName;
    }

    public Integer getSvcId() {
        return svcId;
    }

    public void setSvcId(Integer svcId) {
        this.svcId = svcId;
    }

    public String getSvcName() {
        return svcName;
    }

    public void setSvcName(String svcName) {
        this.svcName = svcName;
    }

    @XmlTransient
    public Collection<FunctionalUnit> getFunctionalUnitCollection() {
        return functionalUnitCollection;
    }

    public void setFunctionalUnitCollection(Collection<FunctionalUnit> functionalUnitCollection) {
        this.functionalUnitCollection = functionalUnitCollection;
    }

    public Division getDvsId() {
        return dvsId;
    }

    public void setDvsId(Division dvsId) {
        this.dvsId = dvsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svcId != null ? svcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.svcId == null && other.svcId != null) || (this.svcId != null && !this.svcId.equals(other.svcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Service[ svcId=" + svcId + " ]";
    }
    
}
