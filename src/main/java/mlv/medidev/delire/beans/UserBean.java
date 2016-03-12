/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mlv.medidev.delire.facades.StaffFacade;
import mlv.medidev.delire.models.Staff;

/**
 *
 * @author khalil
 */
@Named(value = "user")
@SessionScoped
public class UserBean implements Serializable {

    private Staff user;
    private String username;
    private String password;
    @EJB
    private StaffFacade stfFacade;

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

    /**
     * Methode login permettant de se connecter au service medidev
     *
     * @return la page index
     */
    public String login() {
        if (user == null) {
            if (username != null && password != null) {
                Staff tmp = stfFacade.findByStfUsername(username);
                if (tmp != null) {
                    if (password.equals(tmp.getStfPassword())) {
                        user = tmp;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Connexion réussie", null));
                        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                        return "toMedicalRecord";
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mauvais password", null));
                        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mauvais username", null));
                    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                }
                this.username = password = null;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Champs vides", null));
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Déjà connecté", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
        return "toIndex";
    }

    /**
     * Méthode logout permettant de se déconnecter
     *
     * @return la page index
     */
    public String logout() {
        if (user != null) {
            user = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Déconnexion réussie", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Déjà déconnecté", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
        return "toIndex";
    }

    public Staff getUser() {
        return user;
    }

    public void setUser(Staff user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
