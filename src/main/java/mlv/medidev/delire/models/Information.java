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
@Table(name = "information")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Information.findAll", query = "SELECT i FROM Information i"),
    @NamedQuery(name = "Information.findByIfmId", query = "SELECT i FROM Information i WHERE i.ifmId = :ifmId"),
    @NamedQuery(name = "Information.findByIfmLname", query = "SELECT i FROM Information i WHERE i.ifmLname = :ifmLname"),
    @NamedQuery(name = "Information.findByIfmFname", query = "SELECT i FROM Information i WHERE i.ifmFname = :ifmFname"),
    @NamedQuery(name = "Information.findByIfmBirthday", query = "SELECT i FROM Information i WHERE i.ifmBirthday = :ifmBirthday"),
    @NamedQuery(name = "Information.findByIfmAddress", query = "SELECT i FROM Information i WHERE i.ifmAddress = :ifmAddress"),
    @NamedQuery(name = "Information.findByIfmZip", query = "SELECT i FROM Information i WHERE i.ifmZip = :ifmZip"),
    @NamedQuery(name = "Information.findByIfmCity", query = "SELECT i FROM Information i WHERE i.ifmCity = :ifmCity"),
    @NamedQuery(name = "Information.findByIfmPhone", query = "SELECT i FROM Information i WHERE i.ifmPhone = :ifmPhone")})
public class Information implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ifm_id")
    private Integer ifmId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ifm_lname")
    private String ifmLname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ifm_fname")
    private String ifmFname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ifm_birthday")
    @Temporal(TemporalType.DATE)
    private Date ifmBirthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ifm_address")
    private String ifmAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ifm_zip")
    private String ifmZip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "ifm_city")
    private String ifmCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "ifm_phone")
    private String ifmPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ifmId", fetch = FetchType.EAGER)
    private Collection<MedicalRecord> medicalRecordCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ifmId", fetch = FetchType.EAGER)
    private Collection<Staff> staffCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ifmId", fetch = FetchType.EAGER)
    private Collection<Doctor> doctorCollection;

    public Information() {
    }

    public Information(Integer ifmId) {
        this.ifmId = ifmId;
    }

    public Information(Integer ifmId, String ifmLname, String ifmFname, Date ifmBirthday, String ifmAddress, String ifmZip, String ifmCity, String ifmPhone) {
        this.ifmId = ifmId;
        this.ifmLname = ifmLname;
        this.ifmFname = ifmFname;
        this.ifmBirthday = ifmBirthday;
        this.ifmAddress = ifmAddress;
        this.ifmZip = ifmZip;
        this.ifmCity = ifmCity;
        this.ifmPhone = ifmPhone;
    }

    public Integer getIfmId() {
        return ifmId;
    }

    public void setIfmId(Integer ifmId) {
        this.ifmId = ifmId;
    }

    public String getIfmLname() {
        return ifmLname;
    }

    public void setIfmLname(String ifmLname) {
        this.ifmLname = ifmLname;
    }

    public String getIfmFname() {
        return ifmFname;
    }

    public void setIfmFname(String ifmFname) {
        this.ifmFname = ifmFname;
    }

    public Date getIfmBirthday() {
        return ifmBirthday;
    }

    public void setIfmBirthday(Date ifmBirthday) {
        this.ifmBirthday = ifmBirthday;
    }

    public String getIfmAddress() {
        return ifmAddress;
    }

    public void setIfmAddress(String ifmAddress) {
        this.ifmAddress = ifmAddress;
    }

    public String getIfmZip() {
        return ifmZip;
    }

    public void setIfmZip(String ifmZip) {
        this.ifmZip = ifmZip;
    }

    public String getIfmCity() {
        return ifmCity;
    }

    public void setIfmCity(String ifmCity) {
        this.ifmCity = ifmCity;
    }

    public String getIfmPhone() {
        return ifmPhone;
    }

    public void setIfmPhone(String ifmPhone) {
        this.ifmPhone = ifmPhone;
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

    @XmlTransient
    public Collection<Doctor> getDoctorCollection() {
        return doctorCollection;
    }

    public void setDoctorCollection(Collection<Doctor> doctorCollection) {
        this.doctorCollection = doctorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ifmId != null ? ifmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Information)) {
            return false;
        }
        Information other = (Information) object;
        if ((this.ifmId == null && other.ifmId != null) || (this.ifmId != null && !this.ifmId.equals(other.ifmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Information[ ifmId=" + ifmId + " ]";
    }
    
}
