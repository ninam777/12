/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author student1
 */
public class Util {

    public static final String url = "jdbc:mysql://localhost:3306/prosoft";
    public static final String username = "root";
    public static final String password = "";
    public static final int SK_IZMENA_PL = 1;
    public static final int SK_UNOS_PL = 2;
    
    public static final int OPERACIJA_VRATI_SVA_MESTA = 100;
    public static final int OPERACIJA_SACUVAJ_PL = 200;
    public static final int OPERACIJA_VRATI_SVA_PL = 201;
    public static final int OPERACIJA_AZURIRAJ_PL = 203;
    
    
    public static final int SERVER_STATUS_OPERACIJA_OK = 1000;
    public static final int SERVER_STATUS_OPERACIJA_NOT_OK = 1001;
    
    public static final String MAP_KEY_SOKET = "soket";
}
