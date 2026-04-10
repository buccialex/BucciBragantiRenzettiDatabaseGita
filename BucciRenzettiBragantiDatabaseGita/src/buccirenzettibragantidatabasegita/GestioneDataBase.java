package buccirenzettibragantidatabasegita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestioneDataBase {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public GestioneDataBase() {
    }

    public void creaTabelle() {
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
                    + "cla_sezione VARCHAR(5)"
                    + ");";
            statement.execute(classi);

            String alunni = "CREATE TABLE IF NOT EXISTS alunni ("
                    + "alu_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "alu_nome VARCHAR(15),"
                    + "alu_cognome VARCHAR(15),"
                    + "alu_cla_id INTEGER,"
                    + "FOREIGN KEY (alu_cla_id) REFERENCES classi(cla_id)"
                    + ");";
            statement.execute(alunni);

            String partecipazione = "CREATE TABLE IF NOT EXISTS partecipazione ("
                    + "par_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "par_alu_id INTEGER,"
                    + "par_git_id INTEGER,"
                    + "FOREIGN KEY (par_alu_id) REFERENCES alunni(alu_id),"
                    + "FOREIGN KEY (par_git_id) REFERENCES gite(git_id)"
                    + ");";
            statement.execute(partecipazione);

        } catch (SQLException e) {
            System.out.println("Errore connessione: " + e.getMessage());
        }
    }

    // ── WRITE ────────────────────────────────────────────────────────────────

    public void scriviGite(String git_dest, Integer git_durata, Integer git_prezzo) {
        try {
            String query = "INSERT INTO gite (git_dest, git_durata, git_prezzo) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, git_dest);
            ps.setInt(2, git_durata);
            ps.setInt(3, git_prezzo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errore scriviGite: " + e.getMessage());
        }
    }

    // FIX: prima usava valori hardcodati – ora usa i parametri ricevuti
    public void scriviClassi(Integer cla_anno, String cla_sezione) {
        try {
            String query = "INSERT INTO classi (cla_anno, cla_sezione) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cla_anno);
            ps.setString(2, cla_sezione);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errore scriviClassi: " + e.getMessage());
        }
    }

    public void scriviAlunni(String alu_nome, String alu_cognome, Integer alu_cla_id) {
        try {
            String query = "INSERT INTO alunni (alu_nome, alu_cognome, alu_cla_id) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, alu_nome);
            ps.setString(2, alu_cognome);
            ps.setInt(3, alu_cla_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errore scriviAlunni: " + e.getMessage());
        }
    }

    public void scriviPartecipazione(Integer par_alu_id, Integer par_git_id) {
        try {
            String query = "INSERT INTO partecipazione (par_alu_id, par_git_id) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, par_alu_id);
            ps.setInt(2, par_git_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errore scriviPartecipazione: " + e.getMessage());
        }
    }

    // ── READ (ResultSet per FRMTabella) ──────────────────────────────────────

    public ResultSet ottieniAlunni() {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery("SELECT alu_id, alu_nome, alu_cognome, alu_cla_id FROM alunni");
        } catch (SQLException e) {
            System.out.println("Errore ottieniAlunni: " + e.getMessage());
            return null;
        }
    }

    public ResultSet ottieniClassi() {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery("SELECT cla_id, cla_anno, cla_sezione FROM classi");
        } catch (SQLException e) {
            System.out.println("Errore ottieniClassi: " + e.getMessage());
            return null;
        }
    }

    public ResultSet ottieniGite() {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery("SELECT git_id, git_dest, git_durata, git_prezzo FROM gite");
        } catch (SQLException e) {
            System.out.println("Errore ottieniGite: " + e.getMessage());
            return null;
        }
    }

    public ResultSet ottieniPartecipazione() {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery("SELECT par_id, par_alu_id, par_git_id FROM partecipazione");
        } catch (SQLException e) {
            System.out.println("Errore ottieniPartecipazione: " + e.getMessage());
            return null;
        }
    }

    // ── READ (List<String> per ComboBox – label "id - info") ─────────────────

    /** Restituisce le classi come lista di stringhe "id - anno sezione" */
    public List<String> ottieniClassiCombo() {
        List<String> lista = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cla_id, cla_anno, cla_sezione FROM classi");
            while (rs.next()) {
                lista.add(rs.getInt("cla_id") + " - " + rs.getInt("cla_anno") + " " + rs.getString("cla_sezione"));
            }
        } catch (SQLException e) {
            System.out.println("Errore ottieniClassiCombo: " + e.getMessage());
        }
        return lista;
    }

    /** Restituisce gli alunni come lista di stringhe "id - nome cognome" */
    public List<String> ottieniAlunniCombo() {
        List<String> lista = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT alu_id, alu_nome, alu_cognome FROM alunni");
            while (rs.next()) {
                lista.add(rs.getInt("alu_id") + " - " + rs.getString("alu_nome") + " " + rs.getString("alu_cognome"));
            }
        } catch (SQLException e) {
            System.out.println("Errore ottieniAlunniCombo: " + e.getMessage());
        }
        return lista;
    }

    /** Restituisce le gite come lista di stringhe "id - destinazione" */
    public List<String> ottieniGiteCombo() {
        List<String> lista = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT git_id, git_dest FROM gite");
            while (rs.next()) {
                lista.add(rs.getInt("git_id") + " - " + rs.getString("git_dest"));
            }
        } catch (SQLException e) {
            System.out.println("Errore ottieniGiteCombo: " + e.getMessage());
        }
        return lista;
    }

    /** Estrae l'id intero dalla stringa "id - descrizione" scelta nella ComboBox */
    public static int estraiId(String voceCombo) {
        return Integer.parseInt(voceCombo.split(" - ")[0].trim());
    }

    public void leggiPartecipazione() {
        try {
            String query = "SELECT alunni.alu_nome, alunni.alu_cognome, partecipazione.par_git_id "
                    + "FROM partecipazione "
                    + "JOIN alunni ON partecipazione.par_alu_id = alunni.alu_id;";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String nome = resultSet.getString("alu_nome");
                String cognome = resultSet.getString("alu_cognome");
                int gitaId = resultSet.getInt("par_git_id");
                System.out.println("Alunno: " + nome + " " + cognome + " | Gita ID: " + gitaId);
            }
        } catch (SQLException e) {
            System.out.println("Errore leggiPartecipazione: " + e.getMessage());
        }
    }
}
