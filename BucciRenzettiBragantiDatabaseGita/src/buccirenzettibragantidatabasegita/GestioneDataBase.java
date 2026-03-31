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
    public GestioneDataBase(){
        
    }
    public void creaTabelle(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:gite.db");
            System.out.println("Connessione aperta.");
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (SQLException e) {
            System.out.println("Errore connessione: " + e.getMessage());
        }
    }
}

