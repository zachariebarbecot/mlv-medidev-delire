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
@Table(name = "attachement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attachement.findAll", query = "SELECT a FROM Attachement a"),
    @NamedQuery(name = "Attachement.findByAtcId", query = "SELECT a FROM Attachement a WHERE a.atcId = :atcId"),
    @NamedQuery(name = "Attachement.findByAtcType", query = "SELECT a FROM Attachement a WHERE a.atcType = :atcType"),
    @NamedQuery(name = "Attachement.findByAtcLink", query = "SELECT a FROM Attachement a WHERE a.atcLink = :atcLink")})
public class Attachement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "atc_id")
    private Integer atcId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "atc_type")
    private int atcType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "atc_link")
    private String atcLink;
    @JoinTable(name = "rpt_atc", joinColumns = {
        @JoinColumn(name = "atc_id", referencedColumnName = "atc_id")}, inverseJoinColumns = {
        @JoinColumn(name = "rpt_id", referencedColumnName = "rpt_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Report> reportCollection;

    public Attachement() {
    }

    public Attachement(Integer atcId) {
        this.atcId = atcId;
    }

    public Attachement(Integer atcId, int atcType, String atcLink) {
        this.atcId = atcId;
        this.atcType = atcType;
        this.atcLink = atcLink;
    }

    public Integer getAtcId() {
        return atcId;
    }

    public void setAtcId(Integer atcId) {
        this.atcId = atcId;
    }

    public int getAtcType() {
        return atcType;
    }

    public void setAtcType(int atcType) {
        this.atcType = atcType;
    }

    public String getAtcLink() {
        return atcLink;
    }

    public void setAtcLink(String atcLink) {
        this.atcLink = atcLink;
    }

    @XmlTransient
    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atcId != null ? atcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attachement)) {
            return false;
        }
        Attachement other = (Attachement) object;
        if ((this.atcId == null && other.atcId != null) || (this.atcId != null && !this.atcId.equals(other.atcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Attachement[ atcId=" + atcId + " ]";
    }
    
}
