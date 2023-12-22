package de.mkremer.jav41;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adresse {

    private String postleitzahl;
    private String ort;
    private String strasse;
    private String hausnummer;

    public Adresse(){
        setPostleitzahl("12345");
        setOrt("Musterort");
        setStrasse("Musterstrasse");
        setHausnummer("123");
    }

    public Adresse(String postleitzahl, String ort, String strasse, String hausnummer) {
        setPostleitzahl(postleitzahl);
        setOrt(ort);
        setStrasse(strasse);
        setHausnummer(hausnummer);
    }

    public void setPostleitzahl(String postleitzahl){
        if(postleitzahl != null && !postleitzahl.isEmpty()) {
            Pattern pattern = Pattern.compile("^\\d{5}$");
            Matcher matcher = pattern.matcher(postleitzahl);
            if(matcher.find()) {
                this.postleitzahl = postleitzahl;
                return;
            }
        }
        this.postleitzahl = "12345";
    }

    public String getPostleitzahl(){
        return this.postleitzahl;
    }

    public void setOrt(String ort){
        if(ort == null || ort.isEmpty()) {
            this.ort = "Musterstadt";
        } else {
            this.ort = ort;
        }
    }

    public String getOrt(){
        return this.ort;
    }

    public void setStrasse(String strasse){
        if(strasse == null || strasse.isEmpty()) {
            this.strasse = strasse;
        } else {
            this.strasse = "Musterstrasse";
        }
    }

    public String getStrasse(){
        return this.strasse;
    }

    public void setHausnummer(String hausnummer){
        if(hausnummer != null && !hausnummer.isEmpty()){
            Pattern pattern = Pattern.compile("^[1-9]\\d{0,3}.$");
            Matcher matcher = pattern.matcher(hausnummer);
            if(matcher.find()) {
                this.hausnummer = hausnummer;
                return;
            }
        }
        this.hausnummer = "123";
    }

    public String getHausnummer(){
        return this.hausnummer;
    }

    @Override
    public String toString() {
        return "[postleitzahl=" + getPostleitzahl() + ", ort=" + getOrt() + ", strasse=" + getStrasse() + ", hausnummer=" + getHausnummer() + "]";
    }

}
