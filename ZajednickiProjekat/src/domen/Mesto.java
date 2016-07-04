/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student1
 */
public class Mesto extends OpstiDomenskiObjekat implements Serializable{
    
    private long ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(long ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }
    
    /**
     * @return the ptt
     */
    public long getPtt() {
        return ptt;
    }

    /**
     * @param ptt the ptt to set
     */
    public void setPtt(long ptt) {
        this.ptt = ptt;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return getPtt() + ", " + getNaziv();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mesto) {
            Mesto m = (Mesto) obj;
            if (getPtt() == m.getPtt()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        
        try {
            
            while(rs.next()){
                long ptt = rs.getLong("ptt");
                String naziv = rs.getString("naziv");
                Mesto m = new Mesto(ptt, naziv);
                lista.add(m);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
}
