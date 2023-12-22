package de.mkremer.jav41;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Freund {

    private UUID id;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    private List<Adresse> adressen;

    private Freund() {
        this.id = UUID.randomUUID();
    }

    public Freund(String vorname, String nachname, String geburtsdatum, Adresse... adressen) {
        this();
        setVorname(vorname);
        setNachname(nachname);
        setGeburtsdatum(geburtsdatum);
        setAdressen(new ArrayList<>(List.of(adressen)));
    }

    public UUID getId() {
        return this.id;
    }

    public void setVorname(String vorname) {
        if(vorname == null || vorname.isEmpty()){
            this.vorname = "Max";
        } else {
            this.vorname = vorname;
        }
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setNachname(String nachname) {
        if(nachname == null || nachname.isEmpty()){
            this.nachname = "Mustermann";
        } else {
            this.nachname = nachname;
        }
    }

    public String getNachname() {
        return this.nachname;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        if(geburtsdatum != null && !geburtsdatum.isEmpty()) {
            Pattern pattern = Pattern.compile("^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
            Matcher matcher = pattern.matcher(geburtsdatum);
            if(matcher.find()) {
                this.geburtsdatum = LocalDate.parse(geburtsdatum);
                return;
            }
        }
        this.geburtsdatum = LocalDate.parse("1970-01-01");
    }

    public LocalDate getGeburtsdatum() {
        return this.geburtsdatum;
    }

    public void setAdressen(List<Adresse> adressen) {
        this.adressen = adressen;
    }

    public void adresseHinzufuegen(Adresse adresse) {
        if(this.adressen != null) {
            this.adressen.add(adresse);
        }
    }

    public List<Adresse> getAdressen() {
        return this.adressen;
    }

    @Override
    public String toString() {
        return "[id=" + getId().toString() + ", vorname=" + getVorname() + ", nachname=" + getNachname() + ", geburtsdatum=" + getGeburtsdatum().toString() + ", adressen=" + getAdressen() + "]";
    }
}
