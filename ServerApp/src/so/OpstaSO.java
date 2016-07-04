/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student1
 */
public abstract class OpstaSO {

    public void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        try {
            proveriPreduslov(odo);
            izvrsiKonkretnuOperaciju(odo);
            potvrdi();
        } catch (Exception ex) {
            ponisti();
            Logger.getLogger(OpstaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greska kod izvrsenja SO" + ex.getMessage());

        }

    }

    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
    }

    protected abstract void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception;

    private void potvrdi() throws Exception {
        db.DBBroker.getInstance().potvrdiTransakciju();
    }

    private void ponisti() throws Exception {
        db.DBBroker.getInstance().ponistiTransakciju();
    }

}
