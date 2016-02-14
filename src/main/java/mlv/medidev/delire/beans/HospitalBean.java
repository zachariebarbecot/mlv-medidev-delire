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
import mlv.medidev.delire.facades.HospitalFacade;
import mlv.medidev.delire.models.Hospital;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Named(value = "hospital")
@RequestScoped
public class HospitalBean {

    private Object id;
    private String name;
    private String address;
    private int zip;
    private String city;
    private Hospital hospital;
    @EJB
    private HospitalFacade hptFacade;

    /**
     * Creates a new instance of HospitalBean
     */
    public HospitalBean() {
    }

    /**
     * Methode permettant de créer un hopital
     *
     * @return La page a afficher
     */
    public String createHospital() {
        if (name != null || address != null || zip != 0 || city != null) {
            hospital = new Hospital();
            hospital.setHptName(name);
            hospital.setHptAddress(address);
            hospital.setHptZip(zip);
            hospital.setHptCity(city);
            hptFacade.create(hospital);
            return "toIndex";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Impossible de créer un hopital", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "toCreateHospital";
        }
    }

    /**
     * Methode permettant de chercher un hopital via son id
     *
     * @return La page a afficher
     */
    public String FindHospitalById() {
        hospital = hptFacade.find(id);
        if (hospital == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cet hopital n'existe pas", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "toSearch";
        }
        return "toHospital";
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

}
