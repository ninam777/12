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
public class StavkaRacuna implements Serializable{
    
    private int rb;
    private Proizvod proizvod;
    private int kolicina;
    private double cena;
    private double iznos;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int rb, Proizvod proizvod, int kolicina, double cena, double iznos) {
        this.rb = rb;
        this.proizvod = proizvod;
        this.kolicina = kolicina;
        this.cena = cena;
        this.iznos = iznos;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
    
}
