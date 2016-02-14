/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Entity
@Table(name = "report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByRptId", query = "SELECT r FROM Report r WHERE r.rptId = :rptId"),
    @NamedQuery(name = "Report.findByRptContent", query = "SELECT r FROM Report r WHERE r.rptContent = :rptContent"),
    @NamedQuery(name = "Report.findByRptCreated", query = "SELECT r FROM Report r WHERE r.rptCreated = :rptCreated")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rpt_id")
    private Integer rptId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "rpt_content")
    private String rptContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rpt_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rptCreated;
    @ManyToMany(mappedBy = "reportCollection", fetch = FetchType.EAGER)
    private Collection<MedicalRecord> medicalRecordCollection;
    @ManyToMany(mappedBy = "reportCollection", fetch = FetchType.EAGER)
    private Collection<Attachement> attachementCollection;

    public Report() {
    }

    public Report(Integer rptId) {
        this.rptId = rptId;
    }

    public Report(Integer rptId, String rptContent, Date rptCreated) {
        this.rptId = rptId;
        this.rptContent = rptContent;
        this.rptCreated = rptCreated;
    }

    public Integer getRptId() {
        return rptId;
    }

    public void setRptId(Integer rptId) {
        this.rptId = rptId;
    }

    public String getRptContent() {
        return rptContent;
    }

    public void setRptContent(String rptContent) {
        this.rptContent = rptContent;
    }

    public Date getRptCreated() {
        return rptCreated;
    }

    public void setRptCreated(Date rptCreated) {
        this.rptCreated = rptCreated;
    }

    @XmlTransient
    public Collection<MedicalRecord> getMedicalRecordCollection() {
        return medicalRecordCollection;
    }

    public void setMedicalRecordCollection(Collection<MedicalRecord> medicalRecordCollection) {
        this.medicalRecordCollection = medicalRecordCollection;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rptId != null ? rptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.rptId == null && other.rptId != null) || (this.rptId != null && !this.rptId.equals(other.rptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Report[ rptId=" + rptId + " ]";
    }
    
}
