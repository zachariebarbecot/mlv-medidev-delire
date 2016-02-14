/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.models;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Entity
@Table(name = "care_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CareUnit.findAll", query = "SELECT c FROM CareUnit c"),
    @NamedQuery(name = "CareUnit.findByCuId", query = "SELECT c FROM CareUnit c WHERE c.cuId = :cuId"),
    @NamedQuery(name = "CareUnit.findByCuName", query = "SELECT c FROM CareUnit c WHERE c.cuName = :cuName")})
public class CareUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cu_id")
    private Integer cuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cu_name")
    private String cuName;
    @JoinColumn(name = "fu_id", referencedColumnName = "fu_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private FunctionalUnit fuId;

    public CareUnit() {
    }

    public CareUnit(Integer cuId) {
        this.cuId = cuId;
    }

    public CareUnit(Integer cuId, String cuName) {
        this.cuId = cuId;
        this.cuName = cuName;
    }

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public String getCuName() {
        return cuName;
    }

    public void setCuName(String cuName) {
        this.cuName = cuName;
    }

    public FunctionalUnit getFuId() {
        return fuId;
    }

    public void setFuId(FunctionalUnit fuId) {
        this.fuId = fuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuId != null ? cuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CareUnit)) {
            return false;
        }
        CareUnit other = (CareUnit) object;
        if ((this.cuId == null && other.cuId != null) || (this.cuId != null && !this.cuId.equals(other.cuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.CareUnit[ cuId=" + cuId + " ]";
    }
    
}
