/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccirenzettibragantidatabasegita;

/**
 *
 * @author renzetti.alessandro
 */
public class Alunno {
    private int matricola;
    private String nome;
    private String cognome;
    private int id;

    public Alunno(int matricola, String nome, String cognome, int id) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Alunno{" + "matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", id=" + id + '}';
    }
    
    
}
