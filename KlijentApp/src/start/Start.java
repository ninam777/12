/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import forme.FmGlavna;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author student1
 */
public class Start {

    public static void main(String[] args) throws IOException {

//        PravnoLice pl = new PravnoLice();
//        pl.setMaticniBroj("123454");
//        pl.setNaziv("N1");
//        pl.setMestoSediste(new Mesto(11000, "Beograd"));
//        pl.setPib("321321");
//        pl.setOpstinaSediste("Vracar");
//        pl.setUlicaSediste("balasda");
//        pl.setBrojSediste("32");
//        pl.setDatumOsnivanja(new Date());
//
//        DBKonekcija konekcija = new DBKonekcija();
//        konekcija.sacuvajPravnoLice(pl);
        Socket ss = new Socket("127.0.0.1", 9010);
        kontroler.Kontroler.vratiInstancuKontrolera().getMapa().put(util.Util.MAP_KEY_SOKET, ss);
        FmGlavna glavna = new FmGlavna();
        glavna.setVisible(true);
        

    }
}
