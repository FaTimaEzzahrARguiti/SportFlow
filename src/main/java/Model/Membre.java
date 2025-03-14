package Model;

import java.util.Date;

public class Membre extends User{
    private int id;
    private Date date_naissance;
    private String sport_pratique;

    public Membre(int idUser, String nom, String prenom, String tele, String username, String password, String role,Date date_naissance, String sport_pratique) {
        super(idUser, nom, prenom, tele, username, password, role);

        this.date_naissance = date_naissance;
        this.sport_pratique = sport_pratique;
    }

    public Membre(String nom, String prenom, String tele, String role, String username, String password, String date_naissance, String sport_pratique) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getSport_pratique() {
        return sport_pratique;
    }

    public void setSport_pratique(String sport_pratique) {
        this.sport_pratique = sport_pratique;
    }


}
