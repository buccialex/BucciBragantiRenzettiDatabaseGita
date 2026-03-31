/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccirenzettibragantidatabasegita;

/**
 *
 * @author bucci.alex
 */
public class Classe {
    private Integer anno;
    private String sezione;
    private String indirizzo;

    public Classe(Integer anno, String sezione, String indirizzo) {
        this.anno = anno;
        this.sezione = sezione;
        this.indirizzo = indirizzo;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getSezione() {
        return sezione;
    }

    public void setSezione(String sezione) {
        this.sezione = sezione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    
    
}
