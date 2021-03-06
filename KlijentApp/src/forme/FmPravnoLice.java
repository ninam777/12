/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Mesto;
import domen.PravnoLice;
import gui.komponente.TblModelPravnoLice;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.Util;

import kontroler.Kontroler;

/**
 *
 * @author student1
 */
public class FmPravnoLice extends javax.swing.JDialog {

    /**
     * Creates new form FmPravnoLice
     */
    public FmPravnoLice(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediFormu();
//        popuniComboMesto();
//        postaviModelTabele();
    }
//    public FmPravnoLice(java.awt.Frame parent, boolean modal, PravnoLice pl) {
//        super(parent, modal);
//        initComponents();
//        
//        popuniComboMesto();
//        prikaziPravnoLice(pl);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxt_naziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxt_maticniBroj = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxt_PIB = new javax.swing.JTextField();
        jtxt_datumOsnivanja = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jpnl_sediste = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboMesto = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jtxt_opstinaSediste = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxt_ulicaSediste = new javax.swing.JTextField();
        jtxt_brojSediste = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbtn_DodajNovoMesto = new javax.swing.JButton();
        jbtn_izaberiMesto = new javax.swing.JButton();
        jbtn_Sacuvaj = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registracija pravnog lica");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Naziv:");

        jLabel2.setText("Maticni broj:");

        jLabel3.setText("PIB:");

        jLabel4.setText("Datum osnivanja:");

        jpnl_sediste.setBorder(javax.swing.BorderFactory.createTitledBorder("Sediste"));

        jLabel5.setText("Mesto:");

        jComboMesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Opstina:");

        jLabel7.setText("Ulica:");

        jLabel8.setText("Broj:");

        jbtn_DodajNovoMesto.setText("+");

        jbtn_izaberiMesto.setText("Izaberi");

        javax.swing.GroupLayout jpnl_sedisteLayout = new javax.swing.GroupLayout(jpnl_sediste);
        jpnl_sediste.setLayout(jpnl_sedisteLayout);
        jpnl_sedisteLayout.setHorizontalGroup(
            jpnl_sedisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl_sedisteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl_sedisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnl_sedisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxt_brojSediste)
                    .addGroup(jpnl_sedisteLayout.createSequentialGroup()
                        .addComponent(jComboMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_izaberiMesto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jbtn_DodajNovoMesto))
                    .addComponent(jtxt_opstinaSediste)
                    .addComponent(jtxt_ulicaSediste))
                .addContainerGap())
        );
        jpnl_sedisteLayout.setVerticalGroup(
            jpnl_sedisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl_sedisteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl_sedisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_DodajNovoMesto)
                    .addComponent(jbtn_izaberiMesto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnl_sedisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxt_opstinaSediste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnl_sedisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxt_ulicaSediste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnl_sedisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxt_brojSediste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtn_Sacuvaj.setText("Sacuvaj");
        jbtn_Sacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_SacuvajActionPerformed(evt);
            }
        });

        jLabel9.setText("dd.mm.yyyy.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(468, 468, 468)
                        .addComponent(jbtn_Sacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_naziv, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_maticniBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_PIB, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_datumOsnivanja, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addComponent(jpnl_sediste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxt_naziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxt_maticniBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxt_PIB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxt_datumOsnivanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnl_sediste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_Sacuvaj)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_SacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_SacuvajActionPerformed
        try {
            String nazivPravnogLica = jtxt_naziv.getText().trim();
            String pib = jtxt_PIB.getText().trim();
            String maticni = jtxt_maticniBroj.getText().trim();
            String sDatum = jtxt_datumOsnivanja.getText().trim();
            String ulica = jtxt_ulicaSediste.getText().trim();
            String opstina = jtxt_opstinaSediste.getText().trim();
            String broj = jtxt_brojSediste.getText().trim();
            Mesto sedisteMesto = (Mesto) jComboMesto.getSelectedItem();

            PravnoLice pl = kreirajObjekatPravnoLice(nazivPravnogLica, pib, maticni, sDatum, opstina, ulica, broj, sedisteMesto);

//            KolekcijaPravnoLice kpl = new KolekcijaPravnoLice();
//            kpl.sacuvajPravnoLice(pl);
            Kontroler kontroler = Kontroler.vratiInstancuKontrolera();

            int rezim = Kontroler.vratiInstancuKontrolera().getAktivanSK();
            if (rezim == Util.SK_UNOS_PL) {
                kontroler.sacuvajPravnoLice(pl);
            }
            if (rezim == Util.SK_IZMENA_PL) {
                kontroler.azurirajPravnoLice(pl);
            }

            //kontroler.sacuvajPravnoLice(pl);
            JOptionPane.showMessageDialog(this, "Objekat je sacuvan!");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(this, "Pravno lice nije kreirano");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jbtn_SacuvajActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_formWindowActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboMesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbtn_DodajNovoMesto;
    private javax.swing.JButton jbtn_Sacuvaj;
    private javax.swing.JButton jbtn_izaberiMesto;
    private javax.swing.JPanel jpnl_sediste;
    private javax.swing.JTextField jtxt_PIB;
    private javax.swing.JTextField jtxt_brojSediste;
    private javax.swing.JTextField jtxt_datumOsnivanja;
    private javax.swing.JTextField jtxt_maticniBroj;
    private javax.swing.JTextField jtxt_naziv;
    private javax.swing.JTextField jtxt_opstinaSediste;
    private javax.swing.JTextField jtxt_ulicaSediste;
    // End of variables declaration//GEN-END:variables

    private void popuniComboMesto() {
        jComboMesto.removeAllItems();

        List<Mesto> listaMesta = Kontroler.vratiInstancuKontrolera().vratiListuMesta();       //Util.vratiListuMesta();

        for (Mesto mesto : listaMesta) {
            jComboMesto.addItem(mesto);
        }
    }

    private PravnoLice kreirajObjekatPravnoLice(String nazivPravnogLica, String pib, String maticni, String sDatum, String opstina, String ulica, String broj, Mesto sedisteMesto) throws Exception {
        PravnoLice pl = new PravnoLice();
        if (nazivPravnogLica == null || nazivPravnogLica.isEmpty()) {
            throw new Exception("Naziv pravnog lica nije unet!!!");
        }
        pl.setNaziv(nazivPravnogLica);
        pl.setMaticniBroj(maticni);
        pl.setPib(pib);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        try {
            Date datumOsnivanja = sdf.parse(sDatum);
            pl.setDatumOsnivanja(datumOsnivanja);
        } catch (ParseException pe) {
            throw new Exception("Datum nije unet u odgovarajucem formatu!!!");
        }
        pl.setOpstinaSediste(opstina);
        pl.setMestoSediste(sedisteMesto);
        pl.setUlicaSediste(ulica);
        pl.setBrojSediste(broj);
        return pl;
    }

    private void prikaziPravnoLice(PravnoLice pl) {
        jtxt_naziv.setText(pl.getNaziv());
        jtxt_maticniBroj.setText(pl.getMaticniBroj());
        jtxt_PIB.setText(pl.getPib());
        jtxt_datumOsnivanja.setText(new SimpleDateFormat("dd.MM.yyyy.").format(pl.getDatumOsnivanja()));
        jtxt_opstinaSediste.setText(pl.getOpstinaSediste());
        jtxt_brojSediste.setText(pl.getBrojSediste());
        jtxt_ulicaSediste.setText(pl.getUlicaSediste());
        jComboMesto.setSelectedItem(pl.getMestoSediste());
    }

    private void srediFormu() {
        centrirajFormu();

        int rezim = Kontroler.vratiInstancuKontrolera().getAktivanSK();
        if (rezim == Util.SK_UNOS_PL) {
            popuniComboMesto();
        }
        if (rezim == Util.SK_IZMENA_PL) {
            popuniComboMesto();
            srediFormuRezimIzmena();
            PravnoLice pl = (PravnoLice) Kontroler.vratiInstancuKontrolera().getMapa().get("pl_izabran");
            prikaziPravnoLice(pl);
        }
    }

    private void srediFormuRezimIzmena() {
        jtxt_maticniBroj.setEditable(false);
    }

    private void centrirajFormu() {
        setLocationRelativeTo(null);
    }
}
