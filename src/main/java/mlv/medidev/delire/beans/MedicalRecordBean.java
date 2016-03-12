package mlv.medidev.delire.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import mlv.medidev.delire.facades.DiseaseFacade;
import mlv.medidev.delire.facades.DoctorFacade;
import mlv.medidev.delire.facades.InformationFacade;
import mlv.medidev.delire.facades.MedicalRecordFacade;
import mlv.medidev.delire.facades.RoleFacade;
import mlv.medidev.delire.models.Disease;
import mlv.medidev.delire.models.Doctor;
import mlv.medidev.delire.models.Information;
import mlv.medidev.delire.models.MedicalRecord;
import mlv.medidev.delire.models.Role;

/**
 *
 * @author khalil
 */
@Named(value = "medicalrecord")
@ConversationScoped
public class MedicalRecordBean implements Serializable {

    private MedicalRecord med;
    private Information info;
    private Doctor doctor;
    private Role role;
    private Disease disease;

    @Inject
    private UserBean user;

    @EJB
    private MedicalRecordFacade medicalFacade;
    @EJB
    private DoctorFacade doctorFacade;
    @EJB
    private InformationFacade infoFacade;
    @EJB
    private RoleFacade roleFacade;
    @EJB
    private DiseaseFacade diseaseFacade;

    @PostConstruct
    public void init() {
        List<MedicalRecord> list = medicalFacade.findMedicalRecordByRole(user.getUser().getRlId());
        if (list != null || !list.isEmpty()) {
            this.med = list.get(0);
        }
    }

    public Disease getDisease() {
        return disease;
    }

    public MedicalRecord getMed() {
        return med;
    }

    public Information getInfo() {
        return info;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Role getRole() {
        return role;
    }

    public void setMed(MedicalRecord med) {
        this.med = med;
    }

    public void setInfo(Information info) {
        this.info = info;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public MedicalRecordBean() {
    }

    //ajouter dans un premier moment les informations
    public String createInformationForMedicalRecord() {
        if (info.getIfmFname() != null || info.getIfmLname() != null
                || info.getIfmBirthday() != null || info.getIfmAddress() != null
                || info.getIfmCity() != null || info.getIfmPhone() != null) {
            infoFacade.create(info);
            return "toCreateDoctorPage";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Impossible de créer les informations", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "rester_sur_page_add_infos";
        }
    }
    // apres dans une seul pge on va ajouter les deux objet doctor (status) et role(name)  

    public String createDoctorAndRoleForMedicalRecord() {
        if (role.getRlName() != null) {
            doctor.setIfmId(info);
            doctorFacade.create(doctor);
            roleFacade.create(role);
            diseaseFacade.create(disease); //#{medialBean.disease.dssName}
            return "toCreateDoctorPage"; // se mettre dans page index(page apres création du MEDICALRECORD
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Impossible de créer les informations", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "rester_sur_page_create_role_doctor";
        }
    }
}

/* public String createMedicalRecord(){
        if (med.get != null || address != null || zip != 0 || city != null) {
           
            return "toIndex";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Impossible de créer un hopital", null));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "toCreateHospital";
        }
        return "success";
    }*/
