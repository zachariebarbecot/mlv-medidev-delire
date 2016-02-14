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
@Table(name = "division")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d"),
    @NamedQuery(name = "Division.findByDvsId", query = "SELECT d FROM Division d WHERE d.dvsId = :dvsId"),
    @NamedQuery(name = "Division.findByDvsName", query = "SELECT d FROM Division d WHERE d.dvsName = :dvsName")})
public class Division implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dvs_id")
    private Integer dvsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dvs_name")
    private String dvsName;
    @JoinColumn(name = "hpt_id", referencedColumnName = "hpt_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Hospital hptId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dvsId", fetch = FetchType.EAGER)
    private Collection<Service> serviceCollection;

    public Division() {
    }

    public Division(Integer dvsId) {
        this.dvsId = dvsId;
    }

    public Division(Integer dvsId, String dvsName) {
        this.dvsId = dvsId;
        this.dvsName = dvsName;
    }

    public Integer getDvsId() {
        return dvsId;
    }

    public void setDvsId(Integer dvsId) {
        this.dvsId = dvsId;
    }

    public String getDvsName() {
        return dvsName;
    }

    public void setDvsName(String dvsName) {
        this.dvsName = dvsName;
    }

    public Hospital getHptId() {
        return hptId;
    }

    public void setHptId(Hospital hptId) {
        this.hptId = hptId;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dvsId != null ? dvsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Division)) {
            return false;
        }
        Division other = (Division) object;
        if ((this.dvsId == null && other.dvsId != null) || (this.dvsId != null && !this.dvsId.equals(other.dvsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Division[ dvsId=" + dvsId + " ]";
    }
    
}
