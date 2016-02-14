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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Entity
@Table(name = "hospital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h"),
    @NamedQuery(name = "Hospital.findByHptId", query = "SELECT h FROM Hospital h WHERE h.hptId = :hptId"),
    @NamedQuery(name = "Hospital.findByHptName", query = "SELECT h FROM Hospital h WHERE h.hptName = :hptName"),
    @NamedQuery(name = "Hospital.findByHptAddress", query = "SELECT h FROM Hospital h WHERE h.hptAddress = :hptAddress"),
    @NamedQuery(name = "Hospital.findByHptZip", query = "SELECT h FROM Hospital h WHERE h.hptZip = :hptZip"),
    @NamedQuery(name = "Hospital.findByHptCity", query = "SELECT h FROM Hospital h WHERE h.hptCity = :hptCity")})
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hpt_id")
    private Integer hptId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "hpt_name")
    private String hptName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "hpt_address")
    private String hptAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hpt_zip")
    private int hptZip;
    @Size(max = 128)
    @Column(name = "hpt_city")
    private String hptCity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hptId", fetch = FetchType.EAGER)
    private Collection<Division> divisionCollection;

    public Hospital() {
    }

    public Hospital(Integer hptId) {
        this.hptId = hptId;
    }

    public Hospital(Integer hptId, String hptName, String hptAddress, int hptZip) {
        this.hptId = hptId;
        this.hptName = hptName;
        this.hptAddress = hptAddress;
        this.hptZip = hptZip;
    }

    public Integer getHptId() {
        return hptId;
    }

    public void setHptId(Integer hptId) {
        this.hptId = hptId;
    }

    public String getHptName() {
        return hptName;
    }

    public void setHptName(String hptName) {
        this.hptName = hptName;
    }

    public String getHptAddress() {
        return hptAddress;
    }

    public void setHptAddress(String hptAddress) {
        this.hptAddress = hptAddress;
    }

    public int getHptZip() {
        return hptZip;
    }

    public void setHptZip(int hptZip) {
        this.hptZip = hptZip;
    }

    public String getHptCity() {
        return hptCity;
    }

    public void setHptCity(String hptCity) {
        this.hptCity = hptCity;
    }

    @XmlTransient
    public Collection<Division> getDivisionCollection() {
        return divisionCollection;
    }

    public void setDivisionCollection(Collection<Division> divisionCollection) {
        this.divisionCollection = divisionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hptId != null ? hptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.hptId == null && other.hptId != null) || (this.hptId != null && !this.hptId.equals(other.hptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Hospital[ hptId=" + hptId + " ]";
    }
    
}
