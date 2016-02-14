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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Entity
@Table(name = "medical_record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicalRecord.findAll", query = "SELECT m FROM MedicalRecord m"),
    @NamedQuery(name = "MedicalRecord.findByMdrId", query = "SELECT m FROM MedicalRecord m WHERE m.mdrId = :mdrId"),
    @NamedQuery(name = "MedicalRecord.findByMdrCreated", query = "SELECT m FROM MedicalRecord m WHERE m.mdrCreated = :mdrCreated"),
    @NamedQuery(name = "MedicalRecord.findByMdrLastModification", query = "SELECT m FROM MedicalRecord m WHERE m.mdrLastModification = :mdrLastModification"),
    @NamedQuery(name = "MedicalRecord.findByMdrLastConsultation", query = "SELECT m FROM MedicalRecord m WHERE m.mdrLastConsultation = :mdrLastConsultation"),
    @NamedQuery(name = "MedicalRecord.findByMdrLastBackup", query = "SELECT m FROM MedicalRecord m WHERE m.mdrLastBackup = :mdrLastBackup")})
public class MedicalRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mdr_id")
    private Integer mdrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdr_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdrCreated;
    @Column(name = "mdr_last_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdrLastModification;
    @Column(name = "mdr_last_consultation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdrLastConsultation;
    @Column(name = "mdr_last_backup")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdrLastBackup;
    @JoinTable(name = "rpt_mdr", joinColumns = {
        @JoinColumn(name = "mdr_id", referencedColumnName = "mdr_id")}, inverseJoinColumns = {
        @JoinColumn(name = "rpt_id", referencedColumnName = "rpt_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Report> reportCollection;
    @ManyToMany(mappedBy = "medicalRecordCollection", fetch = FetchType.EAGER)
    private Collection<Disease> diseaseCollection;
    @JoinColumn(name = "dtr_id", referencedColumnName = "dtr_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor dtrId;
    @JoinColumn(name = "ifm_id", referencedColumnName = "ifm_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Information ifmId;
    @JoinColumn(name = "rl_id", referencedColumnName = "rl_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Role rlId;

    public MedicalRecord() {
    }

    public MedicalRecord(Integer mdrId) {
        this.mdrId = mdrId;
    }

    public MedicalRecord(Integer mdrId, Date mdrCreated) {
        this.mdrId = mdrId;
        this.mdrCreated = mdrCreated;
    }

    public Integer getMdrId() {
        return mdrId;
    }

    public void setMdrId(Integer mdrId) {
        this.mdrId = mdrId;
    }

    public Date getMdrCreated() {
        return mdrCreated;
    }

    public void setMdrCreated(Date mdrCreated) {
        this.mdrCreated = mdrCreated;
    }

    public Date getMdrLastModification() {
        return mdrLastModification;
    }

    public void setMdrLastModification(Date mdrLastModification) {
        this.mdrLastModification = mdrLastModification;
    }

    public Date getMdrLastConsultation() {
        return mdrLastConsultation;
    }

    public void setMdrLastConsultation(Date mdrLastConsultation) {
        this.mdrLastConsultation = mdrLastConsultation;
    }

    public Date getMdrLastBackup() {
        return mdrLastBackup;
    }

    public void setMdrLastBackup(Date mdrLastBackup) {
        this.mdrLastBackup = mdrLastBackup;
    }

    @XmlTransient
    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    @XmlTransient
    public Collection<Disease> getDiseaseCollection() {
        return diseaseCollection;
    }

    public void setDiseaseCollection(Collection<Disease> diseaseCollection) {
        this.diseaseCollection = diseaseCollection;
    }

    public Doctor getDtrId() {
        return dtrId;
    }

    public void setDtrId(Doctor dtrId) {
        this.dtrId = dtrId;
    }

    public Information getIfmId() {
        return ifmId;
    }

    public void setIfmId(Information ifmId) {
        this.ifmId = ifmId;
    }

    public Role getRlId() {
        return rlId;
    }

    public void setRlId(Role rlId) {
        this.rlId = rlId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mdrId != null ? mdrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalRecord)) {
            return false;
        }
        MedicalRecord other = (MedicalRecord) object;
        if ((this.mdrId == null && other.mdrId != null) || (this.mdrId != null && !this.mdrId.equals(other.mdrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.MedicalRecord[ mdrId=" + mdrId + " ]";
    }
    
}
