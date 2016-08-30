/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logika.Kontroler;
import model.ModelTabeleServer;
import niti.NitOsvezi;
import pomocneKlase.PrikazKlasa;
import server.PokretanjeServera;

/**
 *
 * @author student1
 */
public class ServerForma extends javax.swing.JFrame {

    /**
     * Creates new form ServerForma
     */
    public ServerForma() {
        initComponents();
        pokreniServer();
        srediTabelu();
//        popuniCB();
        NitOsvezi no = new NitOsvezi(this);
        no.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtTabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabela;
    // End of variables declaration//GEN-END:variables

    private void pokreniServer() {
        PokretanjeServera ps = new PokretanjeServera();
        ps.start();
    }

    public void srediTabelu() {

        ArrayList<PrikazKlasa> lista = Kontroler.getInstanca().vratiPrikaz();
        ArrayList<PrikazKlasa> filtriranaLista = lista;

//        
        ModelTabeleServer mts = new ModelTabeleServer(filtriranaLista);
        jtTabela.setModel(mts);
    }
    
//    *COMBOBOX
//    private void popuniCB() {
//        List<Predmet> lpr = Kontroler.getInstanca().vratiListuPredmeta();
//
//        cbPredmet.removeAllItems();
//
//        for (Predmet p : lpr) {
//            cbPredmet.addItem(p);
//        }
//    }
}



//FILTERI

//  *CHECK BOX + COMBO BOX
//if(chbFiltriranje.isSelected()){
//            int ispRok = ((IspitniRok) cbIspitniRok.getSelectedItem()).getIspitniRokID();
//            int pred = ((Predmet) cbPredmet.getSelectedItem()).getPredmetID();
//            
//            lista = Kontroler.getInstanca().vratiPrikaz(pred, ispRok);
//        }


//  *CHECK BOX, da je na isti datum
//if (jCheckBox1.isSelected()) {
//
//            Date datum = null;
//            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//            try {
//                datum = sdf.parse(jtfDatum.getText());
//            } catch (ParseException ex) {
//
//            }
//
//            ArrayList<Racun> listaRacuna = Kontroler.getInstanca().vratiListuRacuna();
//
//            if (datum == null) {
//                modifLista = lista;
//            } else {
//                for (PrikazKlasa pk : lista) {
//                    for(Racun r : listaRacuna){
//                        if(r.getKlijent().getKlijentID()==pk.getKlijent().getKlijentID() && datum.equals(r.getDatum())){
//                            modifLista.add(pk);
//                        }
//                    }
//                }
//            }
//            ModelTabeleServer mts = new ModelTabeleServer(modifLista);
//            jtTabela.setModel(mts);
//        } else {
//            ModelTabeleServer mts = new ModelTabeleServer(lista);
//            jtTabela.setModel(mts);
//
//        }


//  *DA SE NALAZI IZMEDJU 2 DATUMA
//if (lista != null) {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//
//            Date datumOd = null;
//            Date datumDo = null;
//
//            ArrayList<PrikazKlasa> filtriranaLista = new ArrayList<>();
//
//            try {
//                datumOd = sdf.parse(jtfDatumOd.getText());
//            } catch (ParseException ex) {
//            }
//
//            try {
//                datumDo = sdf.parse(jtfDatumDo.getText());
//            } catch (ParseException ex) {
//            }
//
//            if (datumOd == null && datumDo == null) {
//                filtriranaLista = lista;
//
//            } else if (datumOd != null && datumDo != null) {
//                for (PrikazKlasa pk : lista) {
//                    if (pk.getProjekat().getDatumOd().after(datumOd) && pk.getProjekat().getDatumDo().before(datumDo)) {
//                        filtriranaLista.add(pk);
//                    }
//                }
//            } else if (datumOd != null && datumDo == null) {
//                for (PrikazKlasa pk : lista) {
//                    if (pk.getProjekat().getDatumOd().after(datumOd)) {
//                        filtriranaLista.add(pk);
//                    }
//                }
//            } else if (datumOd == null && datumDo != null) {
//                for (PrikazKlasa pk : lista) {
//                    if (pk.getProjekat().getDatumDo().before(datumDo)) {
//                        filtriranaLista.add(pk);
//
//                    }
//                }
//            }
//
//        }

//*SORT za 2 kolone, ako je potrebno samo za jednu izbrisi od drugog ifa nadalje
//private void sort(ArrayList<PrikazKlasa> lista) {
//        PrikazKlasa pom;
//
//        for (int i = 0; i < lista.size() - 1; i++) {
//            for (int j = i + 1; j < lista.size(); j++) {
//                if (lista.get(i).getBrProdPrim() <= lista.get(j).getBrProdPrim()) {
//                    pom = lista.get(i);
//                    lista.set(i, lista.get(j));
//                    lista.set(j, pom);
//                    if (lista.get(i).getBrProdPrim() == lista.get(j).getBrProdPrim()) {
//                        if (lista.get(i).getPrihod() < lista.get(j).getPrihod()) {
//                            pom = lista.get(i);
//                            lista.set(i, lista.get(j));
//                            lista.set(j, pom);
//                        }
//                    }
//                }
//            }
//        }
//
//    }
