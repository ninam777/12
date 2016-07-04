/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student1
 */
public class TblModelStavkeRacuna extends AbstractTableModel {

    Racun racun;

    public TblModelStavkeRacuna(Racun racun) {
        this.racun = racun;
    }

    @Override
    public int getRowCount() {
        return racun.getList_stavke().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna sr = racun.getList_stavke().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sr.getRb();
            case 1:
                return sr.getProizvod();
            case 2:
                return sr.getKolicina();
            case 3:
                return sr.getCena();
            case 4:
                return sr.getIznos();
            default:
                return "N/A";
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Rb";
            case 1:
                return "Proizvod";
            case 2:
                return "Kolicina";
            case 3:
                return "Cena";
            case 4:
                return "Iznos";
            default:
                return "N/A";
        }

    }

    public void dodajStavku(Proizvod p, int kolicina) {
        StavkaRacuna sr = racun.vratiStavkuRacuna(p);
        if (sr != null) {
            sr.setKolicina(sr.getKolicina()+kolicina);
            sr.setIznos(sr.getKolicina()*sr.getCena());
        } else {
            sr = new StavkaRacuna();
            sr.setRb(racun.getList_stavke().size() + 1);
            sr.setProizvod(p);
            sr.setKolicina(kolicina);
            sr.setCena(p.getCena());
            sr.setIznos(sr.getKolicina() * sr.getCena());
            racun.getList_stavke().add(sr);

        }
        fireTableDataChanged();
    }

    public Racun vratiRacun() {
        return racun;
        
    }

}
