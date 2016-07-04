/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Mesto;
import domen.PravnoLice;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student1
 */
public class TblModelPravnoLice extends AbstractTableModel {

    List<PravnoLice> lpl;

    public TblModelPravnoLice(List<PravnoLice> lpl) {
        this.lpl = lpl;
    }

    @Override
    public int getRowCount() {
        if (lpl == null) {
            return 0;
        }
        return lpl.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PravnoLice pl = lpl.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return pl.getNaziv();
            case 1:
                return pl.getMaticniBroj();
            case 2:
                return pl.getPib();
            case 3:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                return sdf.format(pl.getDatumOsnivanja());
            case 4:
                return pl.getMestoSediste();
            case 5:
                return pl.getOpstinaSediste() + " " + pl.getUlicaSediste();
            default:
                return "n/a";
        }

    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "Naziv";
            case 1:
                return "Maticni broj";
            case 2:
                return "PIB";
            case 3:
                return "Datum osnivanja";
            case 4:
                return "Mesto sediste";
            case 5:
                return "Adresa";
            default:
                return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0 || columnIndex == 4) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        if (columnIndex == 0) {
            PravnoLice pl = lpl.get(rowIndex);
            pl.setNaziv(aValue.toString());
        }

        if (columnIndex == 4) {
            Mesto m = (Mesto) aValue;
            PravnoLice pl = lpl.get(rowIndex);
            pl.setMestoSediste(m);
        }
    }

//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        if(columnIndex == 4) return Mesto.class;
//        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
//    }
    public void dodaj(PravnoLice pl) {
        lpl.add(pl);
        fireTableDataChanged();
    }

    public List<PravnoLice> vratiListuPL() {
        return lpl;
    }

}
