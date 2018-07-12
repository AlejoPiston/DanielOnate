/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Terapia;

/**
 *
 * @author Liz
 */
@Stateless
public class TerapiaFacade extends AbstractFacade<Terapia> implements TerapiaFacadeLocal {

    @PersistenceContext(unitName = "WebTerapiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerapiaFacade() {
        super(Terapia.class);
    }
    
}
