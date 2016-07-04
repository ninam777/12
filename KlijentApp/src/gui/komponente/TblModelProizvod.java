/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Proizvod;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student1
 */
public class TblModelProizvod extends AbstractTableModel{
    
    List<Proizvod> list_proizvodi;

    public TblModelProizvod(List<Proizvod> list_proizvodi) {
        this.list_proizvodi = list_proizvodi;
    }
    
    

    @Override
    public int getRowCount() {
        return list_proizvodi.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proizvod p = list_proizvodi.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getSifra();
            case 1: return p.getNaziv();
            case 2: return p.getCena();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
            case 0: return "Sifra";
            case 1: return "Naziv";
            case 2: return "Cena";
            default: return "N/A";
        }
    }

    public Proizvod vratiProizvod(int red) {
       return list_proizvodi.get(red);
        
    }
    
    
}
