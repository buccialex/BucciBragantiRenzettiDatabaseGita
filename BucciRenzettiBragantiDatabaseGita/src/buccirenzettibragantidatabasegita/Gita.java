/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccirenzettibragantidatabasegita;

/**
 *
 * @author bucci.alex
 */
public class Gita {
    private Integer id;
    private String destinazione;
    private Integer durata;
    private Integer prezzo;

    public Gita(Integer id, String destinazione, Integer durata, Integer prezzo) {
        this.id = id;
        this.destinazione = destinazione;
        this.durata = durata;
        this.prezzo = prezzo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Gita{" + "id=" + id + ", destinazione=" + destinazione + ", durata=" + durata + ", prezzo=" + prezzo + '}';
    }
    
    
}
