/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author student1
 */
public class Racun implements Serializable{
    String brojRacuna;
    Date datum;
    PravnoLice pl;
    List<StavkaRacuna> list_stavke;

    public Racun() {
        list_stavke = new LinkedList<>();
    }

    public Racun(String brojRacuna, Date datum, PravnoLice pl, List<StavkaRacuna> list_stavke) {
        this.brojRacuna = brojRacuna;
        this.datum = datum;
        this.pl = pl;
        this.list_stavke = list_stavke;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public PravnoLice getPl() {
        return pl;
    }

    public void setPl(PravnoLice pl) {
        this.pl = pl;
    }

    public List<StavkaRacuna> getList_stavke() {
        return list_stavke;
    }

    public void setList_stavke(List<StavkaRacuna> list_stavke) {
        this.list_stavke = list_stavke;
    }

    public StavkaRacuna vratiStavkuRacuna(Proizvod p) {
        for (StavkaRacuna sr : list_stavke) {
            if(sr.getProizvod()==p)return sr;
        }
        return null;
    }
    
    
}
