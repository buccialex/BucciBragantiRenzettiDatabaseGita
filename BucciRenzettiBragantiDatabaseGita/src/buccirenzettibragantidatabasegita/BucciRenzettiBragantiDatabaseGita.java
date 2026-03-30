/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buccirenzettibragantidatabasegita;
import java.sql.*;


/**
 *
 * @author bucci.alex
 */
public class BucciRenzettiBragantiDatabaseGita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Connessione OK");

            Statement stmt = conn.createStatement();

            // Attiva foreign key
            stmt.execute("PRAGMA foreign_keys = ON;");

            // Verifica
            ResultSet rs = stmt.executeQuery("PRAGMA foreign_keys;");
            if (rs.next()) {
                System.out.println("FK attive: " + rs.getInt(1));
            }

            // Pulizia
            stmt.execute("DROP TABLE IF EXISTS ordini;");
            stmt.execute("DROP TABLE IF EXISTS clienti;");

            // Tabelle
            stmt.execute("""
                CREATE TABLE clienti (
                    id INTEGER PRIMARY KEY,
                    nome TEXT
                );
            """);

            stmt.execute("""
                CREATE TABLE ordini (
                    id INTEGER PRIMARY KEY,
                    cliente_id INTEGER,
                    FOREIGN KEY(cliente_id) REFERENCES clienti(id)
                );
            """);

            // Inserimento valido
            stmt.execute("INSERT INTO clienti VALUES (1, 'Mario');");
            stmt.execute("INSERT INTO ordini VALUES (1, 1);");

            System.out.println("Inserimento valido OK");

            // Inserimento NON valido
            stmt.execute("INSERT INTO ordini VALUES (2, 999);");

            System.out.println("NON DOVREBBE STAMPARE");

        } catch (SQLException e) {
            System.out.println("Errore SQL:");
            e.printStackTrace();
        }
             FRMGita f = new FRMGita();
        f.setVisible(true);
    }
}
   
    

