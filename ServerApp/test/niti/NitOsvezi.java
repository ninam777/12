/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forma.ServerForma;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student1
 */
public class NitOsvezi extends Thread{
    
    ServerForma sf;

    public NitOsvezi(ServerForma sf) {
        this.sf = sf;
    }
    
    

    @Override
    public void run() {
        while (true) {            
            sf.srediTabelu();
            System.out.println("Osvezio");
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitOsvezi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

//*UKOLIKO JE KONZOLA

//public class NitOsvezi extends Thread{
//    
//    ServerKonzola k;
//
//    public NitOsvezi(ServerKonzola k) {
//        this.k = k;
//    }
//
//    
//    
//    
//
//    @Override
//    public void run() {
//        while (true) {            
//            k.srediPrikaz();
//            System.out.println("Osvezio");
//            try {
//                sleep(10000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(NitOsvezi.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//    
//}
