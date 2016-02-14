/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mlv.medidev.delire.facades.DivisionFacade;
import mlv.medidev.delire.models.Division;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Named(value = "division")
@RequestScoped
public class DivisionBean {

    private Object id;
    private String name;
    private Division division;

    @EJB
    private DivisionFacade dvsFacade;

    /**
     * Creates a new instance of DivisionBean
     */
    public DivisionBean() {
    }

    public String createDivision() {
        if (name != null) {
            division = new Division();
            division.setDvsName(name);
            dvsFacade.create(division);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Impossible de créer une division", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "toCreateDivision";
        }
        return "toIndex";
    }

    public String FindDivisionById() {
        division = dvsFacade.find(id);
        if (division == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cet division n'existe pas", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "toSearch";
        }
        return "toDivision";
    }
}
