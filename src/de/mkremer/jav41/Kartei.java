package de.mkremer.jav41;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Kartei {

    private final List<Freund> FREUNDE;

    public Kartei(){
        this.FREUNDE = new ArrayList<>();
    }

    public void addFreund(Freund freund) {
        this.FREUNDE.add(freund);
    }

    public List<Freund> getFreunde() {
        return this.FREUNDE;
    }

    public Freund getFreundPerId(UUID id) {
        if(id != null) {
            for (Freund freund : this.FREUNDE) {
                if (freund.getId().compareTo(id) == 0) {
                    return freund;
                }
            }
        }
        return null;
    }

    public List<Freund> getFreundePerNachname(String nachname) {
        List<Freund> filteredFreunde = new ArrayList<>();

        if (nachname != null && !nachname.isEmpty()) {
            for (Freund freund : this.FREUNDE) {
                if (freund.getNachname().equalsIgnoreCase(nachname)) {
                    filteredFreunde.add(freund);
                }
            }
        }

        return filteredFreunde;
    }

    public boolean entferneFreund(UUID id) {
        if(id == null) return false;

        int indexToRemove = -1;
        for(int i = 0; i < this.FREUNDE.size(); i++) {
            Freund freund = this.FREUNDE.get(i);
            if(freund.getId().compareTo(id) == 0) {
                indexToRemove = i;
                break;
            }
        }

        if(indexToRemove > -1) {
            this.FREUNDE.remove(indexToRemove);
            return true;
        }

        return false;
    }

    public void aendereAdressePerId(UUID freundId, Adresse alteAdresse, Adresse neueAdresse) {
        Freund freund = getFreundPerId(freundId);

        for(int i = 0; i < freund.getAdressen().size(); i++){
            Adresse adresse = freund.getAdressen().get(i);
            if(adresse.toString().equalsIgnoreCase(alteAdresse.toString())){
                freund.getAdressen().set(i, neueAdresse);
                break;
            }
        }
    }

    public void aendereAdressePerNachname(String nachname, Adresse alteAdresse, Adresse neueAdresse) {
        List<Freund> freunde = getFreundePerNachname(nachname);

        for(Freund freund : freunde) {
            for (int i = 0; i < freund.getAdressen().size(); i++) {
                Adresse adresse = freund.getAdressen().get(i);
                if (adresse.toString().equalsIgnoreCase(alteAdresse.toString())) {
                    freund.getAdressen().set(i, neueAdresse);
                }
            }
        }
    }

    public int getFreundeAnzahl() {
        return this.FREUNDE.size();
    }

    @Override
    public String toString() {
        return "Kartei{" +
                "freunde=" + getFreunde() +
                "}";
    }
}
