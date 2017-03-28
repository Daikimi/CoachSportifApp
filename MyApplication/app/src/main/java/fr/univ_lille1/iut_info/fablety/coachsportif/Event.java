package fr.univ_lille1.iut_info.fablety.coachsportif;

import java.util.Date;

/**
 * Created by fablety on 27/03/17.
 */

public class Event {
    Date date;
    boolean dispo;
    String nom;

    public Event(Date date, boolean dispo, String nom) {
        this.date = date;
        this.dispo = dispo;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Event{" +
                "Date=" + date +
                ", Dispo=" + dispo +
                ", Nom='" + nom + '\'' +
                '}';
    }
}
