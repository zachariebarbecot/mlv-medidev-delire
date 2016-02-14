/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlv.medidev.delire.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mlv.medidev.delire.models.Report;

/**
 *
 * @author Zacharie BARBECOT <z.barbecot@gmail.com>
 */
@Stateless
public class ReportFacade extends AbstractFacade<Report> {

    @PersistenceContext(unitName = "mrsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportFacade() {
        super(Report.class);
    }
    
}
