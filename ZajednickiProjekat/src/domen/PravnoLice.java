/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author student1
 */
public class PravnoLice extends OpstiDomenskiObjekat implements Serializable {
    
    private String naziv;
    private String maticniBroj; // mora biti 8 cifara
    private String pib;         // mora imati 9 cifara
    private Date datumOsnivanja;
    private Mesto mestoSediste;
    private String opstinaSediste;
    private String ulicaSediste;
    private String brojSediste;

    public PravnoLice(String naziv, String maticniBroj, String pib, Date datumOsnivanja, Mesto mestoSediste, String opstinaSediste, String ulicaSediste, String brojSediste) {
        this.naziv = naziv;
        this.maticniBroj = maticniBroj;
        this.pib = pib;
        this.datumOsnivanja = datumOsnivanja;
        this.mestoSediste = mestoSediste;
        this.opstinaSediste = opstinaSediste;
        this.ulicaSediste = ulicaSediste;
        this.brojSediste = brojSediste;
    }

    public PravnoLice() {
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

    /**
     * @return the maticniBroj
     */
    public String getMaticniBroj() {
        return maticniBroj;
    }

    /**
     * @param maticniBroj the maticniBroj to set
     */
    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    /**
     * @return the pib
     */
    public String getPib() {
        return pib;
    }

    /**
     * @param pib the pib to set
     */
    public void setPib(String pib) {
        this.pib = pib;
    }

    /**
     * @return the datumOsnivanja
     */
    public Date getDatumOsnivanja() {
        return datumOsnivanja;
    }

    /**
     * @param datumOsnivanja the datumOsnivanja to set
     */
    public void setDatumOsnivanja(Date datumOsnivanja) {
        this.datumOsnivanja = datumOsnivanja;
    }

    /**
     * @return the mestoSediste
     */
    public Mesto getMestoSediste() {
        return mestoSediste;
    }

    /**
     * @param mestoSediste the mestoSediste to set
     */
    public void setMestoSediste(Mesto mestoSediste) {
        this.mestoSediste = mestoSediste;
    }

    /**
     * @return the opstinaSediste
     */
    public String getOpstinaSediste() {
        return opstinaSediste;
    }

    /**
     * @param opstinaSediste the opstinaSediste to set
     */
    public void setOpstinaSediste(String opstinaSediste) {
        this.opstinaSediste = opstinaSediste;
    }

    /**
     * @return the ulicaSediste
     */
    public String getUlicaSediste() {
        return ulicaSediste;
    }

    /**
     * @param ulicaSediste the ulicaSediste to set
     */
    public void setUlicaSediste(String ulicaSediste) {
        this.ulicaSediste = ulicaSediste;
    }

    /**
     * @return the brojSediste
     */
    public String getBrojSediste() {
        return brojSediste;
    }

    /**
     * @param brojSediste the brojSediste to set
     */
    public void setBrojSediste(String brojSediste) {
        this.brojSediste = brojSediste;
    }

    @Override
    public String toString() {
        return  "naziv=" + naziv + ", maticniBroj=" + maticniBroj;
    }

    @Override
    public String vratiNazivTabele() {
        return "pravnolice";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(datumOsnivanja);
        
        return "("+"'"+maticniBroj+"',"+"'"+naziv+"','"+pib+"','"+
                datum+"',"+getMestoSediste().getPtt()+",'"+
                getOpstinaSediste()+"','"+getUlicaSediste()+"','"+
                getBrojSediste()+"'"+")";
    }
    
    
    
}
