/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mlv.medidev.delire.models.MedicalRecord;
import mlv.medidev.delire.models.Role;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Stateless
public class MedicalRecordFacade extends AbstractFacade<MedicalRecord> {

    @PersistenceContext(unitName = "mrsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicalRecordFacade() {
        super(MedicalRecord.class);
    }

    public MedicalRecord findMedicalRecordByMdrId(Object mrdId) {
        Query q = em.createNamedQuery("MedicalRecord.findByMdrId", MedicalRecord.class);
        q.setParameter("mdrId", mrdId);
        return (MedicalRecord) q.getSingleResult();
    }
    
     public List<MedicalRecord> findMedicalRecordByRole(Role role) {
        Query q = em.createNamedQuery("MedicalRecord.findByRlId", MedicalRecord.class);
        q.setParameter("rlId", role);
        List<MedicalRecord> list = q.getResultList();
        if(list == null || list.isEmpty()){
            return null;
        }
        return list;
    }
}
