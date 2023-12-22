package de.mkremer.jav41;

public class Main {

    public static void main(String[] args) {
        Kartei kartei = new Kartei();

        Adresse ersteAdresse = new Adresse(
                "21149",
                "Hamburg",
                "Teststrasse",
                "1"
        );
        Freund ersterFreund = new Freund(
                "Vorname", "Nachname", "2000-01-01", ersteAdresse, new Adresse()
        );

        Adresse zweiteAdresse = new Adresse(
                "70191",
                "Stuttgart",
                "Heilbronner Strasse",
                "86"
        );
        Freund zweiterFreund = new Freund(
                "AKAD", "University", "1959-01-01", zweiteAdresse
        );

        kartei.addFreund(ersterFreund);
        kartei.addFreund(zweiterFreund);

        System.out.println(kartei.getFreundeAnzahl());
        System.out.println(kartei.getFreundPerId(ersterFreund.getId()));
        System.out.println(kartei.getFreundePerNachname("university"));
        System.out.println(kartei);
        kartei.aendereAdressePerId(
                ersterFreund.getId(),
                ersterFreund.getAdressen().get(0),
                new Adresse()
        );
        System.out.println(kartei.entferneFreund(zweiterFreund.getId()));
        System.out.println(kartei);
        System.out.println(kartei.getFreundeAnzahl());
    }

}
