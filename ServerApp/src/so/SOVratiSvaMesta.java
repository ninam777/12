/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author student1
 */
public class SOVratiSvaMesta extends OpstaSO{
    
    private List<OpstiDomenskiObjekat> lm;

    public List<OpstiDomenskiObjekat> getLm() {
        return lm;
    }

    
    

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lm = db.DBBroker.getInstance().vratiSve(odo);
    }
    
}
