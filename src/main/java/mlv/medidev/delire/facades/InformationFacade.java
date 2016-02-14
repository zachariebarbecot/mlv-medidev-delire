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
import mlv.medidev.delire.models.Information;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Stateless
public class InformationFacade extends AbstractFacade<Information> {

    @PersistenceContext(unitName = "mrsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InformationFacade() {
        super(Information.class);
    }

    public Information findInformationdByIfmId(Object ifmId) {
        Query q = em.createNamedQuery("Information.findByIfmId", Information.class);
        q.setParameter("ifmId", ifmId);
        return (Information) q.getSingleResult();
    }
}
