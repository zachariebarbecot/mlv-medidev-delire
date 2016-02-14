/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.beans;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import mlv.medidev.delire.dao.*;
import mlv.medidev.delire.models.*;
/**
 *
 * @author khalil
 */
@Named("staffBean")
@RequestScoped
public class StaffBean {
    private String username;
    private String password;
    private Integer role;
    private String msge="";
    IStaffDAO dao = new StaffDAOImpl();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getMsge() {
        return msge;
    }

    public void setMsge(String msge) {
        this.msge = msge;
    }
    
   public String validate() {
		List<Staff> list = dao.getStaffsByRole(role);
		for (Staff cd : list) {
			if (cd.getStfUsername().equals(username)
					&& cd.getStfPassword().equals(password)) {
				msge = "weeeeeeeelll";
				return "success";
			}
		}
		msge = "erreur de connexion ";
		return "failure";
	}
}