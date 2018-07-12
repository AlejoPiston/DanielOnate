/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Local;
import modelos.Terapia;

/**
 *
 * @author Liz
 */
@Local
public interface TerapiaFacadeLocal {

    void create(Terapia terapia);

    void edit(Terapia terapia);

    void remove(Terapia terapia);

    Terapia find(Object id);

    List<Terapia> findAll();

    List<Terapia> findRange(int[] range);

    int count();
    
}
