/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapp;

import db.DBKonekcija;
import domen.Mesto;
import domen.PravnoLice;
import dto.KlijentTransferObjekat;
import dto.ServerTransferObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student1
 */
public class ServerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ServerApp sa = new ServerApp();
        sa.pokreniServer();
    }

    private void pokreniServer() throws Exception {
        ServerSocket ss = new ServerSocket(9010);
        System.out.println("Server je pokrenut.");
        while (true) {
            Socket ks = ss.accept();
            System.out.println("Klijent se povezao.");
            NitKlijent nit = new NitKlijent(ks);
        }

        //obradiZahteve(ks);
    }

    private void obradiZahteve(Socket ks) throws IOException, ClassNotFoundException {
        db.DBKonekcija dbKonekcija = new DBKonekcija();

        while (true) {
            ObjectInputStream in = new ObjectInputStream(ks.getInputStream());
            KlijentTransferObjekat kto = (KlijentTransferObjekat) in.readObject();
            int operacija = kto.getOperacija();
            switch (operacija) {
                case util.Util.OPERACIJA_VRATI_SVA_MESTA: {
                    ObjectOutputStream out = new ObjectOutputStream(ks.getOutputStream());
                    List<Mesto> mesta = dbKonekcija.vratiListuMesta();
                    ServerTransferObjekat sto = new ServerTransferObjekat();
                    sto.setRezultat(mesta);
                    sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                    out.writeObject(sto);
                }
                break;
                case util.Util.OPERACIJA_SACUVAJ_PL:
                    PravnoLice pl = (PravnoLice) kto.getParametar();
                     {
                        ObjectOutputStream out = new ObjectOutputStream(ks.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            dbKonekcija.sacuvajPravnoLice(pl);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);

                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.writeObject(sto);
                    }

                    break;
                case util.Util.OPERACIJA_AZURIRAJ_PL:
                    PravnoLice pravno_lice = (PravnoLice) kto.getParametar();
                     {
                        ObjectOutputStream out = new ObjectOutputStream(ks.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            dbKonekcija.azurirajPravnoLice(pravno_lice);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);

                        } catch (Exception ex) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.writeObject(sto);
                    }

                    break;

                case util.Util.OPERACIJA_VRATI_SVA_PL: {
                    ObjectOutputStream out = new ObjectOutputStream(ks.getOutputStream());
                    ServerTransferObjekat sto = new ServerTransferObjekat();
                    try {
                        List<PravnoLice> lpl = dbKonekcija.vratiListuPravnihLica();
                        sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        sto.setRezultat(lpl);
                    } catch (Exception ex) {
                        sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                        sto.setGreska(ex.getMessage());
                        Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    out.writeObject(sto);
                }
                break;

            }

        }
    }

}
