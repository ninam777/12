/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.PravnoLice;
import domen.Proizvod;
import domen.Racun;
import gui.komponente.TblModelProizvod;
import gui.komponente.TblModelStavkeRacuna;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author user
 */
public class FmRacun extends javax.swing.JDialog {

    /**
     * Creates new form FmRacun
     */
    public FmRacun(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centrirajFormu();
        postaviTabele();
        popuniComboPravnaLica();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBrojRacuna = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDatumRacuna = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jbtnSacuvajRacun = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRacun = new javax.swing.JTable();
        btnObrisiStavku = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblProizvodi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtProizvod = new javax.swing.JTextField();
        txtKolicina = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jbtnIzaberi = new javax.swing.JButton();
        jcbPravnoLice = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma: Racun");

        jLabel1.setText("Broj racuna:");

        jLabel2.setText("Datum racuna:");

        jbtnSacuvajRacun.setText("Sacuvaj racun");
        jbtnSacuvajRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajRacunActionPerformed(evt);
            }
        });

        jtblRacun.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblRacun);

        btnObrisiStavku.setText("Obrisi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jbtnSacuvajRacun)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnObrisiStavku)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisiStavku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jbtnSacuvajRacun)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Stavke racuna", jPanel1);

        jtblProizvodi.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblProizvodi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblProizvodiMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtblProizvodi);

        jLabel4.setText("Proizvod:");

        txtProizvod.setEnabled(false);

        jLabel6.setText("Kolicina:");

        jLabel7.setText("Cena:");

        txtCena.setEnabled(false);

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtProizvod, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtCena)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDodaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProizvod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodaj))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proizvodi", jPanel2);

        jLabel3.setText("Pravno lice:");

        jbtnIzaberi.setText("Izaberi");

        jcbPravnoLice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPravnoLiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBrojRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(txtDatumRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jcbPravnoLice, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnIzaberi)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBrojRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jbtnIzaberi)
                    .addComponent(jcbPravnoLice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbPravnoLiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPravnoLiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPravnoLiceActionPerformed

    private void jtblProizvodiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblProizvodiMousePressed
        Proizvod p = vratiIzabranProizvod();
        txtProizvod.setText(p.getNaziv());
        txtCena.setText(p.getCena() + "");
        txtKolicina.setText("1");

    }//GEN-LAST:event_jtblProizvodiMousePressed

    private Proizvod vratiIzabranProizvod() {
        int red = jtblProizvodi.getSelectedRow();
        TblModelProizvod tmp = (TblModelProizvod) jtblProizvodi.getModel();
        Proizvod p = tmp.vratiProizvod(red);
        return p;
    }

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        try {
            Proizvod p = vratiIzabranProizvod();
            int kolicina = Integer.parseInt(txtKolicina.getText().trim());
            TblModelStavkeRacuna tmsr = (TblModelStavkeRacuna) jtblRacun.getModel();
            tmsr.dodajStavku(p, kolicina);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnDodajActionPerformed

    private void jbtnSacuvajRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajRacunActionPerformed
        TblModelStavkeRacuna tmsr = (TblModelStavkeRacuna) jtblRacun.getModel();
        Racun r = tmsr.vratiRacun();
        try {
            if (r.getList_stavke().isEmpty()) {
                throw new Exception("Racun nema stavke");
            }
            r.setBrojRacuna(txtBrojRacuna.getText().trim());
            String sdatum = txtDatumRacuna.getText().trim();
            r.setDatum(new SimpleDateFormat("dd.MM.yyyy.").parse(sdatum));
            r.setPl((PravnoLice)jcbPravnoLice.getSelectedItem());
            
            Kontroler.vratiInstancuKontrolera().sacuvajRacun(r);
            JOptionPane.showMessageDialog(this, "Racun je sacuvan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_jbtnSacuvajRacunActionPerformed

    private void centrirajFormu() {
        setLocationRelativeTo(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnIzaberi;
    private javax.swing.JButton jbtnSacuvajRacun;
    private javax.swing.JComboBox jcbPravnoLice;
    private javax.swing.JTable jtblProizvodi;
    private javax.swing.JTable jtblRacun;
    private javax.swing.JTextField txtBrojRacuna;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtDatumRacuna;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtProizvod;
    // End of variables declaration//GEN-END:variables

    private void postaviTabele() {
        TblModelStavkeRacuna tmsr = new TblModelStavkeRacuna(new Racun());
        jtblRacun.setModel(tmsr);

        List<Proizvod> lp = Kontroler.vratiInstancuKontrolera().vratiSveProizvode();
        TblModelProizvod tmp = new TblModelProizvod(lp);
        jtblProizvodi.setModel(tmp);
    }

    private void popuniComboPravnaLica() {
        try {
            List<PravnoLice> pl = Kontroler.vratiInstancuKontrolera().vratiListuPravnihLica();
            jcbPravnoLice.setModel(new DefaultComboBoxModel(pl.toArray()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FmRacun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FmRacun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
