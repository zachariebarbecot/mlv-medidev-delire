/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mlv.medidev.delire.models.FunctionalUnit;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Stateless
public class FunctionalUnitFacade extends AbstractFacade<FunctionalUnit> {

    @PersistenceContext(unitName = "mrsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FunctionalUnitFacade() {
        super(FunctionalUnit.class);
    }
    
}
