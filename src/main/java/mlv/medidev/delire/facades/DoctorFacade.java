/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mlv.medidev.delire.models.Doctor;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Stateless
public class DoctorFacade extends AbstractFacade<Doctor> {

    @PersistenceContext(unitName = "mrsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DoctorFacade() {
        super(Doctor.class);
    }

    public Doctor findDoctorByDtrId(Object dtrId) {
        Query q = em.createNamedQuery("Doctor.findByDtrId", Doctor.class);
        q.setParameter("dtrId", dtrId);
        return (Doctor) q.getSingleResult();
    }

    public Doctor findDoctorByDtrStatus(int dtrStatus) {
        Query q = em.createNamedQuery("Doctor.findByDtrStatus", Doctor.class);
        q.setParameter("dtrStatus", dtrStatus);
        return (Doctor) q.getSingleResult();
    }
}
