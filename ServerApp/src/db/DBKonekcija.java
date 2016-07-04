/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Mesto;
import domen.PravnoLice;
import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import util.Util;

/**
 *
 * @author student1
 */
public class DBKonekcija {

    public void sacuvajPravnoLice(PravnoLice pl) throws Exception {
        try {
            //ucitaj driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver je ucitan");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO pravnolice VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setString(1, pl.getMaticniBroj());
            ps.setString(2, pl.getNaziv());
            ps.setString(3, pl.getPib());
            ps.setDate(4, new Date(pl.getDatumOsnivanja().getTime()));
            ps.setLong(5, pl.getMestoSediste().getPtt());
            ps.setString(6, pl.getOpstinaSediste());
            ps.setString(7, pl.getUlicaSediste());
            ps.setString(8, pl.getBrojSediste());

            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver ne postoji: " + ex.getMessage());
            throw new Exception("Driver ne postoji");
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception("Gresak u konekciji!s");
        }

    }

    public void azurirajPravnoLice(PravnoLice pl) throws Exception {
        try {
            //ucitaj driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver je ucitan");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE pravnolice SET naziv=?, pib=?, datum_osnivanja=?, ptt_mesto_osnivanja=?,opstina_sediste=?, ulica_sediste=?, broj_sediste=?  WHERE maticni_broj=?";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setString(1, pl.getNaziv());
            ps.setString(2, pl.getPib());
            ps.setDate(3, new Date(pl.getDatumOsnivanja().getTime()));
            ps.setLong(4, pl.getMestoSediste().getPtt());
            ps.setString(5, pl.getOpstinaSediste());
            ps.setString(6, pl.getUlicaSediste());
            ps.setString(7, pl.getBrojSediste());
            ps.setString(8, pl.getMaticniBroj());
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver ne postoji: " + ex.getMessage());
            throw new Exception("Driver ne postoji");
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception("Gresak u konekciji!s");
        }

    }

    public List<Mesto> vratiListuMesta() {
        List<Mesto> listaMesta = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver je ucitan");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "SELECT * FROM mesto";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {
                long ptt = rs.getLong("ptt");
                String naziv = rs.getString("naziv");
                Mesto m = new Mesto(ptt, naziv);
                listaMesta.add(m);
            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaMesta;
    }

    //sve podatke o mestu
    public Mesto vratiMesto(Mesto m) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver je ucitan");
        String url = Util.url;
        String password = Util.password;
        String username = Util.username;
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Konekcija je uspostavljena");

        String upit = "SELECT * FROM mesto where ptt=?";
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setLong(1, m.getPtt());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            m.setNaziv(rs.getString(2));
        }
        return m;
    }

    public List<PravnoLice> vratiListuPravnihLica() {
        List<PravnoLice> listaPL = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver je ucitan");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "SELECT * FROM pravnolice";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {

                String mb = rs.getString("maticni_broj");
                String naziv = rs.getString("naziv");
                String pib = rs.getString("pib");
                java.util.Date datum = new java.util.Date(rs.getDate("datum_osnivanja").getTime());
                long mesto = rs.getLong("ptt_mesto_osnivanja");
                String opstina = rs.getString("opstina_sediste");
                String ulicaSediste = rs.getString("ulica_sediste");
                String brojSediste = rs.getString("broj_sediste");

                PravnoLice pl = new PravnoLice();
                pl.setMaticniBroj(mb);
                pl.setNaziv(naziv);
                pl.setPib(pib);
                pl.setDatumOsnivanja(datum);

                Mesto m = new Mesto();
                m.setPtt(mesto);
                m = vratiMesto(m);

                pl.setMestoSediste(m);
                pl.setOpstinaSediste(opstina);
                pl.setUlicaSediste(ulicaSediste);
                pl.setBrojSediste(brojSediste);

                listaPL.add(pl);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPL;

    }

    public void sacuvajListuPravnihLica(List<PravnoLice> lpl) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver je ucitan");
        String url = Util.url;
        String password = Util.password;
        String username = Util.username;
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        System.out.println("Konekcija je uspostavljena");
        String upit = "insert into pravnolice values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(upit);
        try {
            for (PravnoLice pl : lpl) {
                ps.setString(1, pl.getMaticniBroj());
                ps.setString(2, pl.getNaziv());
                ps.setString(3, pl.getPib());
                ps.setDate(4, new Date(pl.getDatumOsnivanja().getTime()));
                ps.setLong(5, pl.getMestoSediste().getPtt());
                ps.setString(6, pl.getOpstinaSediste());
                ps.setString(7, pl.getUlicaSediste());
                ps.setString(8, pl.getBrojSediste());
                try {
                    ps.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Ne mogu da sacuvam: " + pl.getMaticniBroj());
                    throw new Exception("Nije sacuvan " + pl.getMaticniBroj());
                }
            }
            connection.commit();
        } catch (Exception e) {
            System.out.println("Doslo je do greske kod cuvanja. " + e.getMessage());
            connection.rollback();
        }

        ps.close();
        connection.close();
    }

    public List<Proizvod> vratiSveProizvode() {
        List<Proizvod> lp = new LinkedList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver je ucitan");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "SELECT * FROM Proizvod";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {

                int sifra = rs.getInt("sifra");
                String naziv = rs.getString("naziv");
                double cena = rs.getDouble("cena");

                Proizvod p = new Proizvod(sifra, naziv, cena);
                lp.add(p);
            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lp;
    }

    public void sacuvajRacun(Racun r) throws Exception {
        Connection connection = null;
        try {
            //ucitaj driver

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver je ucitan");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            System.out.println("Konekcija je uspostavljena");
            String upit = "INSERT INTO racun VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setString(1, r.getBrojRacuna());
            ps.setDate(2, new Date(r.getDatum().getTime()));
            ps.setString(3, r.getPl().getMaticniBroj());
            ps.setDouble(4, -1);
            ps.executeUpdate();

            upit = "INSERT INTO stavkaracuna VALUES (?,?,?,?,?,?)";
            ps = connection.prepareStatement(upit);
            for (StavkaRacuna sr : r.getList_stavke()) {
                ps.setString(1, r.getBrojRacuna());
                ps.setInt(2, sr.getRb());
                ps.setInt(3, sr.getProizvod().getSifra());
                ps.setInt(4, sr.getKolicina());
                ps.setDouble(5, sr.getCena());
                ps.setDouble(6, sr.getIznos());
                ps.executeUpdate();
            }
            System.out.println("Upit je izvrsen");
            connection.commit();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver ne postoji: " + ex.getMessage());
            throw new Exception("Driver ne postoji");
        } catch (SQLException sqlEx) {
            if (connection != null) {
                connection.rollback();
                connection.close();
            }
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception("Gresak u konekciji!s");
        }

    }
}
