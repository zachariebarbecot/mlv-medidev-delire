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
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStfId", query = "SELECT s FROM Staff s WHERE s.stfId = :stfId"),
    @NamedQuery(name = "Staff.findByStfUsername", query = "SELECT s FROM Staff s WHERE s.stfUsername = :stfUsername"),
    @NamedQuery(name = "Staff.findByStfPassword", query = "SELECT s FROM Staff s WHERE s.stfPassword = :stfPassword")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stf_id")
    private Integer stfId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "stf_username")
    private String stfUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "stf_password")
    private String stfPassword;
    @JoinColumn(name = "ifm_id", referencedColumnName = "ifm_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Information ifmId;
    @JoinColumn(name = "rl_id", referencedColumnName = "rl_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role rlId;

    public Staff() {
    }

    public Staff(Integer stfId) {
        this.stfId = stfId;
    }

    public Staff(Integer stfId, String stfUsername, String stfPassword) {
        this.stfId = stfId;
        this.stfUsername = stfUsername;
        this.stfPassword = stfPassword;
    }

    public Integer getStfId() {
        return stfId;
    }

    public void setStfId(Integer stfId) {
        this.stfId = stfId;
    }

    public String getStfUsername() {
        return stfUsername;
    }

    public void setStfUsername(String stfUsername) {
        this.stfUsername = stfUsername;
    }

    public String getStfPassword() {
        return stfPassword;
    }

    public void setStfPassword(String stfPassword) {
        this.stfPassword = stfPassword;
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
        hash += (stfId != null ? stfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.stfId == null && other.stfId != null) || (this.stfId != null && !this.stfId.equals(other.stfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mlv.medidev.delire.models.Staff[ stfId=" + stfId + " ]";
    }
    
}
