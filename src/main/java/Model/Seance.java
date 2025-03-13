package Model;

import java.util.Date;

public class Seance {
    private int idSeance;
    private int idMembre;
    private int idEntraineur;
    private Date date;
    private Date heure;

    // Constructeurs
    public Seance() {}

    public Seance(int idMembre, int idEntraineur, Date date, Date heure) {
        this.idMembre = idMembre;
        this.idEntraineur = idEntraineur;
        this.date = date;
        this.heure = heure;
    }

    // Getters et Setters
    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdEntraineur() {
        return idEntraineur;
    }

    public void setIdEntraineur(int idEntraineur) {
        this.idEntraineur = idEntraineur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }
}
