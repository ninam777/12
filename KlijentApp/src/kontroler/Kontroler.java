/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Mesto;
import domen.PravnoLice;
import domen.Proizvod;
import domen.Racun;
import dto.KlijentTransferObjekat;
import dto.ServerTransferObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author student1
 */
public class Kontroler {

    private static Kontroler instanca;

    private int aktivanSK;
    private Map<String, Object> mapa;

    public static Kontroler vratiInstancuKontrolera() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    private Kontroler() {
        mapa = new HashMap<>();
    }

    public void sacuvajPravnoLice(PravnoLice pl) throws Exception {
        Socket s = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);

        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_SACUVAJ_PL);
        kto.setParametar(pl);
        out.writeObject(kto);

        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
        } else {
            throw new Exception(sto.getGreska());
        }
    }
     public void azurirajPravnoLice(PravnoLice pl) throws Exception {
        Socket s = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);

        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_AZURIRAJ_PL);
        kto.setParametar(pl);
        out.writeObject(kto);

        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
        } else {
            throw new Exception(sto.getGreska());
        }
    }

    public List<PravnoLice> vratiListuPravnihLica() throws IOException, ClassNotFoundException, Exception {
        Socket s = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);

        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(util.Util.OPERACIJA_VRATI_SVA_PL);        
        out.writeObject(kto);

        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_OK) {
            return (List<PravnoLice> )sto.getRezultat();
        } else {
            throw new Exception(sto.getGreska());
        }
        
    }

    public List<Mesto> vratiListuMesta() {        
        try {
            // posalji zahtev
            Socket s = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(util.Util.OPERACIJA_VRATI_SVA_MESTA);
            out.writeObject(kto);

            // procitaj odgovor
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            List<Mesto> lm = (List<Mesto>) sto.getRezultat();
            return lm;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void sacuvajListuPravnihLica(List<PravnoLice> lpl) throws ClassNotFoundException, SQLException {

    }

    public int getAktivanSK() {
        return aktivanSK;
    }

    public void setAktivanSK(int aktivanSK) {
        this.aktivanSK = aktivanSK;
    }

    public Map<String, Object> getMapa() {
        return mapa;
    }

    public List<Proizvod> vratiSveProizvode() {
        return null;
    }

    public void sacuvajRacun(Racun r) throws Exception {

    }

}
