/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;

/**
 *
 * @author student1
 */
public class SacuvajPravnoLiceSO extends OpstaSO{

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        
        db.DBBroker.getInstance().sacuvaj(odo);
    }
    
    
}
