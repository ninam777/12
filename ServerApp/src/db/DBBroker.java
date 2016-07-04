/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;

/**
 *
 * @author student1
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection connection;

    private DBBroker() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver je ucitan");
        String url = Util.url;
        String password = Util.password;
        String username = Util.username;
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Konekcija je uspostavljena");
        connection.setAutoCommit(false);
    }

    public static DBBroker getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void potvrdiTransakciju() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ponistiTransakciju() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES " + odo.vratiVrednostiZaInsert();
        System.out.println(upit);
        Statement st = connection.createStatement();
        st.executeUpdate(upit);
    }

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws SQLException {

        String upit = "SELECT * FROM " + odo.vratiNazivTabele();
        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery(upit);

        return odo.vratiListu(rs);

    }
}
