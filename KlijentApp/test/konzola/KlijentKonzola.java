/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konzola;

//TODO: izbrisi ovo
//import domen.Mesto;
//import domen.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Konstante;
import transfer.KlijentskiTransferObjekat;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author student1
 */
public class KlijentKonzola {

    boolean nijeKraj = true;

    public KlijentKonzola() throws IOException {
        meni();
        while (nijeKraj) {
            unosPoruke();
        }
    }

    public static void main(String[] args) throws IOException {
        new KlijentKonzola();
    }

    public void meni() {
        System.out.println("1. Unos novog studenta");
        System.out.println("2. Kraj rada");
    }

    public void unosPoruke() throws IOException {
        //pripremi poruku za slanje
        System.out.println("Klijent :: unesi poruku :: ");
        BufferedReader inTastatura = new BufferedReader(new InputStreamReader(System.in));
        String porukaZaSlanje = inTastatura.readLine();

        // ovo ne treba (sledeca tri zakomentarisana reda), al nek se nadje, nikad se ne zna
        // posalji poruku serveru
//        PrintWriter outSocket = new PrintWriter(s.getOutputStream(), true);
//        outSocket.println(porukaZaSlanje);
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        int izbor = Integer.parseInt(porukaZaSlanje);
        if (izbor == 1) {
            System.out.println("Unesi ime");
            String ime = inTastatura.readLine();
            System.out.println("Unesi prezime");
            String prezime = inTastatura.readLine();
            System.out.println("Unesi jmbg");
            String jmbg = inTastatura.readLine();
            System.out.println("Unesi broj indeksa");
            String brInd = inTastatura.readLine();
            System.out.println("Unesi ptt mesta");
            String ptt = inTastatura.readLine();

//            TODO: Promeni u zavisnosti to ga sta ti treba za sacuvaj
//            Student stud = new Student(-1, ime, prezime, Integer.parseInt(jmbg), brInd, new Mesto(-1, Integer.parseInt(ptt), null));


//            kto.setOperacija(Konstante.SACUVAJ_STUDENTA);
//            kto.setParametar(stud);
//
            Komunikacija.getInstanca().posaljiZahtev(kto);
            ServerskiTransferObjekat sto = Komunikacija.getInstanca().primiOdgovor();
            System.out.println(sto.getPoruka());
        } else if (izbor == 2) {
            
            nijeKraj=false;
        } else {
            System.out.println("Niste dobro uneli. Unesite 1 ili 2");
        }
    }
}
