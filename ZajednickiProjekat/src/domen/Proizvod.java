/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author student1
 */
public class Proizvod implements Serializable{

    private int sifra;
    private String naziv;
    private double cena;

    public Proizvod() {
    }

    public Proizvod(int sifra, String naziv, double cena) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Proizvod) {
            Proizvod p = (Proizvod) obj;
            if (getSifra() == p.getSifra()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
