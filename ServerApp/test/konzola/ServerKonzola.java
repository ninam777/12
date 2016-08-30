/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konzola;

import java.util.ArrayList;
import logika.Kontroler;
import niti.NitOsvezi;
import pomocneKlase.PrikazKlasa;
import server.PokretanjeServera;

/**
 *
 * @author student1
 */
public class ServerKonzola {

    public ServerKonzola() {
        pokreniServer();
        srediPrikaz();
        // TODO: ukoliko je konzola, samo otkomentarisi ovo za nit
//        NitOsvezi no = new NitOsvezi(this);
//        no.start();
    }
    
    public static void main(String[] args) {
        new ServerKonzola();
    }
    
    private void pokreniServer() {
        PokretanjeServera ps = new PokretanjeServera();
        ps.start();
    }
    
    public void srediPrikaz(){
//        ArrayList<PrikazKlasa> lista = Kontroler.getInstanca().vratiPrikaz();
//        ArrayList<PrikazKlasa> sortiranaLista = sort(lista);
//        System.out.println("==========");
//        for (PrikazKlasa pk : lista) {
//            System.out.println(pk.getPtt() + " " + pk.getNaziv() + " " + pk.getBrStud());
//        }
////        System.out.println(lista);
//        System.out.println("==========");
    }

    private ArrayList<PrikazKlasa> sort(ArrayList<PrikazKlasa> lista) {
//        PrikazKlasa pom = new PrikazKlasa();
//        
//        for (int i = 0; i < lista.size()-1; i++) {
//            for (int j = i+1; j < lista.size(); j++) {
//                if(lista.get(i).getPtt()>lista.get(j).getPtt()){
//                    pom = lista.get(i);
//                    lista.set(i, lista.get(j));
//                    lista.set(j, pom);
//                }
//            }
//        }
//        
        return lista;
    }
    
    
}
