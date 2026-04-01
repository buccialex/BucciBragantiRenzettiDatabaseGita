/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccirenzettibragantidatabasegita;

import java.sql.*;

/**
 *
 * @author braganti.alessandro
 */
public class GestioneDataBase {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public GestioneDataBase() {

    }

    public void creaTabelle() throws ClassNotFoundException {
    try {
        connection = null;
        statement = null;
        resultSet = null;
        String percorso = System.getProperty("user.dir") + "/DataBase.db";
        connection = DriverManager.getConnection("jdbc:sqlite:" + percorso);
        statement = connection.createStatement();
        
        statement.execute("PRAGMA foreign_keys = ON;");

        String gite = "CREATE TABLE IF NOT EXISTS gite ("
                + "git_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "git_dest VARCHAR(50),"
                + "git_durata INTEGER,"
                + "git_prezzo INTEGER"
                + ");";
        statement.execute(gite);

        String classi = "CREATE TABLE IF NOT EXISTS classi ("
                + "cla_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "cla_anno INTEGER,"
                + "cla_sezione INTEGER"
                + ");";
        statement.execute(classi);

        String alunni = "CREATE TABLE IF NOT EXISTS alunni ("
                + "alu_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "alu_nome VARCHAR(15),"
                + "alu_cognome VARCHAR(15),"
                + "alu_cla_id INTEGER,"
                + "FOREIGN KEY (alu_cla_id) REFERENCES classi(cla_id)"  // ✅ corretto
                + ");";
        statement.execute(alunni);

        String partecipazione = "CREATE TABLE IF NOT EXISTS partecipazione ("
                + "par_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "par_alu_id INTEGER,"
                + "par_git_id INTEGER,"
                + "FOREIGN KEY (par_alu_id) REFERENCES alunni(alu_id),"  // ✅ corretto
                + "FOREIGN KEY (par_git_id) REFERENCES gite(git_id)"     // ✅ senza virgola finale
                + ");";
        statement.execute(partecipazione);

    } catch (SQLException e) {
        System.out.println("Errore connessione: " + e.getMessage());
    }
}

    public void scriviGite(String git_dest, Integer git_durata, Integer git_prezzo) {
        try {
            // 1. Scrivi la query con i segnaposto ?
            String query = "INSERT INTO gite (git_dest, git_durata, git_prezzo) VALUES (?, ?, ?)";

// 2. Prepara lo statement
            PreparedStatement ps = connection.prepareStatement(query);

// 3. Sostituisci i ? con i valori reali (l'indice parte da 1, non da 0)
            ps.setString(1, git_dest);   // primo  ?
            ps.setInt(2, git_durata);    // secondo ?
            ps.setInt(3, git_prezzo);    // terzo  ?

// 4. Esegui
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errore connessione: " + e.getMessage());
        }
    }

    public void scriviClassi(String cla_anno, String cla_sezione) {
        try {
            String datiClasse = "INSERT INTO classi (cla_anno, cla_sezione)"
                    + "VALUES (2,'c')";
            statement.execute(datiClasse);
        } catch (SQLException e) {
            System.out.println("Errore connessione: " + e.getMessage());
        }
    }

    public void scriviAlunni(String alu_nome, String alu_cognome, Integer alu_cla_id) {
        try {
            String query = "INSERT INTO alunni (alu_nome, alu_cognome, alu_cla_id) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,alu_nome);
        ps.setString(2, alu_cognome);
        ps.setInt(3, alu_cla_id);
        ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errore connessione: " + e.getMessage());
        }

    }
public void leggiPartecipazione() {
    try {
        String query = "SELECT alunni.alu_nome, alunni.alu_cognome, partecipazione.par_git_id "
                     + "FROM partecipazione "
                     + "JOIN alunni ON partecipazione.par_alu_id = alunni.alu_id;";
        
        resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            String nome    = resultSet.getString("alu_nome");
            String cognome = resultSet.getString("alu_cognome");
            int gitaId     = resultSet.getInt("par_git_id");
            
            System.out.println("Alunno: " + nome + " " + cognome + " | Gita ID: " + gitaId);
        }
    } catch (SQLException e) {
        System.out.println("Errore: " + e.getMessage());
    }
}
    
}


