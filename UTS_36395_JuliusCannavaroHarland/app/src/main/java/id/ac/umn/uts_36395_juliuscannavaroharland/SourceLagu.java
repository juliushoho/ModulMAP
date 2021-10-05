package id.ac.umn.uts_36395_juliuscannavaroharland;

import java.io.Serializable;

public class SourceLagu implements Serializable {
    private String judul;
    private String keterangan;
    private String laguURI;
    public SourceLagu(String judul, String keterangan, String laguURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.laguURI = laguURI;
    }

    public String getJudul() { return this.judul; }
    public String getKeterangan() { return this.keterangan; }
    public String getLaguURI() { return this.laguURI; }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public void setLaguURI(String laguURI) {
        this.laguURI = laguURI;
    }

    public String toString() {
        return this.getJudul() + "=>" + this.getKeterangan();
    }
}
