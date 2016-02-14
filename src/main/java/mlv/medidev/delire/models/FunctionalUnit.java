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
@Table(name = "functional_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FunctionalUnit.findAll", query = "SELECT f FROM FunctionalUnit f"),
    @NamedQuery(name = "FunctionalUnit.findByFuId", query = "SELECT f FROM FunctionalUnit f WHERE f.fuId = :fuId"),
    @NamedQuery(name = "FunctionalUnit.findByFuName", query = "SELECT f FROM FunctionalUnit f WHERE f.fuName = :fuName")})
public class FunctionalUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fu_id")
    private Integer fuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fu_name")
    private String fuName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuId", fetch = FetchType.EAGER)
    private Collection<CareUnit> careUnitCollection;
    @JoinColumn(name = "svc_id", referencedColumnName = "svc_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Service svcId;

    public FunctionalUnit() {
    }

    public FunctionalUnit(Integer fuId) {
        this.fuId = fuId;
    }

    public FunctionalUnit(Integer fuId, String fuName) {
        this.fuId = fuId;
        this.fuName = fuName;
    }

    public Integer getFuId() {
        return fuId;
    }

    public void setFuId(Integer fuId) {
        this.fuId = fuId;
    }

    public String getFuName() {
        return fuName;
    }

    public void setFuName(String fuName) {
        this.fuName = fuName;
    }

    @XmlTransient
    public Collection<CareUnit> getCareUnitCollection() {
        return careUnitCollection;
    }

    public void setCareUnitCollection(Collection<CareUnit> careUnitCollection) {
        this.careUnitCollection = careUnitCollection;
    }

    public Service getSvcId() {
        return svcId;
    }

    public void setSvcId(Service svcId) {
        this.svcId = svcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fuId != null ? fuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunctionalUnit)) {
            return false;
        }
        FunctionalUnit other = (FunctionalUnit) object;
        if ((this.fuId == null && other.fuId != null) || (this.fuId != null && !this.fuId.equals(other.fuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.FunctionalUnit[ fuId=" + fuId + " ]";
    }
    
}
