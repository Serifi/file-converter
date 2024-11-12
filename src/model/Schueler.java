package model;

import java.io.Serializable;
import java.util.Objects;

public class Schueler implements Comparable<Schueler>, Serializable {
    int ssd_id;
    int ssd_katnr;
    String ssd_zuname;
    String ssd_vorname;
    String ssd_geschlecht;
    String ssd_religion;
    String ssd_gebdatum;
    String ssd_str;
    int ssd_plz;
    String ssd_ort;
    String ssd_schulformkurzbez;
    String ssd_kla_bezeichnung;
    String ssd_kv_zuname;

    public Schueler(int ssd_id, int ssd_katnr, String ssd_zuname, String ssd_vorname, String ssd_geschlecht, String ssd_religion, String ssd_gebdatum, String ssd_str, int ssd_plz, String ssd_ort, String ssd_schulformkurzbez, String ssd_kla_bezeichnung, String ssd_kv_zuname) {
        this.ssd_id = ssd_id;
        this.ssd_katnr = ssd_katnr;
        this.ssd_zuname = ssd_zuname;
        this.ssd_vorname = ssd_vorname;
        this.ssd_geschlecht = ssd_geschlecht;
        this.ssd_religion = ssd_religion;
        this.ssd_gebdatum = ssd_gebdatum;
        this.ssd_str = ssd_str;
        this.ssd_plz = ssd_plz;
        this.ssd_ort = ssd_ort;
        this.ssd_schulformkurzbez = ssd_schulformkurzbez;
        this.ssd_kla_bezeichnung = ssd_kla_bezeichnung;
        this.ssd_kv_zuname = ssd_kv_zuname;
    }

    public int getSsd_id() {
        return ssd_id;
    }

    public void setSsd_id(int ssd_id) {
        this.ssd_id = ssd_id;
    }

    public int getSsd_katnr() {
        return ssd_katnr;
    }

    public void setSsd_katnr(int ssd_katnr) {
        this.ssd_katnr = ssd_katnr;
    }

    public String getSsd_zuname() {
        return ssd_zuname;
    }

    public void setSsd_zuname(String ssd_zuname) {
        this.ssd_zuname = ssd_zuname;
    }

    public String getSsd_vorname() {
        return ssd_vorname;
    }

    public void setSsd_vorname(String ssd_vorname) {
        this.ssd_vorname = ssd_vorname;
    }

    public String getSsd_geschlecht() {
        return ssd_geschlecht;
    }

    public void setSsd_geschlecht(String ssd_geschlecht) {
        this.ssd_geschlecht = ssd_geschlecht;
    }

    public String getSsd_religion() {
        return ssd_religion;
    }

    public void setSsd_religion(String ssd_religion) {
        this.ssd_religion = ssd_religion;
    }

    public String getSsd_gebdatum() {
        return ssd_gebdatum;
    }

    public void setSsd_gebdatum(String ssd_gebdatum) {
        this.ssd_gebdatum = ssd_gebdatum;
    }

    public String getSsd_str() {
        return ssd_str;
    }

    public void setSsd_str(String ssd_str) {
        this.ssd_str = ssd_str;
    }

    public int getSsd_plz() {
        return ssd_plz;
    }

    public void setSsd_plz(int ssd_plz) {
        this.ssd_plz = ssd_plz;
    }

    public String getSsd_ort() {
        return ssd_ort;
    }

    public void setSsd_ort(String ssd_ort) {
        this.ssd_ort = ssd_ort;
    }

    public String getSsd_schulformkurzbez() {
        return ssd_schulformkurzbez;
    }

    public void setSsd_schulformkurzbez(String ssd_schulformkurzbez) {
        this.ssd_schulformkurzbez = ssd_schulformkurzbez;
    }

    public String getSsd_kla_bezeichnung() {
        return ssd_kla_bezeichnung;
    }

    public void setSsd_kla_bezeichnung(String ssd_kla_bezeichnung) {
        this.ssd_kla_bezeichnung = ssd_kla_bezeichnung;
    }

    public String getSsd_kv_zuname() {
        return ssd_kv_zuname;
    }

    public void setSsd_kv_zuname(String ssd_kv_zuname) {
        this.ssd_kv_zuname = ssd_kv_zuname;
    }

    @Override
    public String toString() {
        return "Schueler{" +
                "ssd_id=" + ssd_id +
                ", ssd_katnr=" + ssd_katnr +
                ", ssd_zuname='" + ssd_zuname + '\'' +
                ", ssd_vorname='" + ssd_vorname + '\'' +
                ", ssd_geschlecht=" + ssd_geschlecht +
                ", ssd_religion='" + ssd_religion + '\'' +
                ", ssd_gebdatum='" + ssd_gebdatum + '\'' +
                ", ssd_str='" + ssd_str + '\'' +
                ", ssd_plz=" + ssd_plz +
                ", ssd_ort='" + ssd_ort + '\'' +
                ", ssd_schulformkurzbez='" + ssd_schulformkurzbez + '\'' +
                ", ssd_kla_bezeichnung='" + ssd_kla_bezeichnung + '\'' +
                ", ssd_kv_zuname='" + ssd_kv_zuname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schueler schueler = (Schueler) o;
        return ssd_id == schueler.ssd_id &&
                ssd_katnr == schueler.ssd_katnr &&
                ssd_geschlecht.equals(schueler.ssd_geschlecht) &&
                ssd_plz == schueler.ssd_plz &&
                ssd_zuname.equals(schueler.ssd_zuname) &&
                ssd_vorname.equals(schueler.ssd_vorname) &&
                ssd_religion.equals(schueler.ssd_religion) &&
                ssd_gebdatum.equals(schueler.ssd_gebdatum) &&
                ssd_str.equals(schueler.ssd_str) &&
                ssd_ort.equals(schueler.ssd_ort) &&
                ssd_schulformkurzbez.equals(schueler.ssd_schulformkurzbez) &&
                ssd_kla_bezeichnung.equals(schueler.ssd_kla_bezeichnung) &&
                ssd_kv_zuname.equals(schueler.ssd_kv_zuname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssd_id, ssd_katnr, ssd_zuname, ssd_vorname, ssd_geschlecht, ssd_religion, ssd_gebdatum, ssd_str, ssd_plz, ssd_ort, ssd_schulformkurzbez, ssd_kla_bezeichnung, ssd_kv_zuname);
    }

    @Override
    public int compareTo(Schueler o) {
        int ret = 0;
        if ((ret = this.ssd_zuname.compareTo(o.getSsd_zuname())) == 0){
            if ((ret = this.ssd_vorname.compareTo(o.getSsd_vorname())) == 0) {
                ret = this.getSsd_katnr() - o.getSsd_katnr();
            }
        }
        return ret;
    }
}