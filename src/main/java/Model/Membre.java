package Model;

import java.util.Date;

public class Membre extends User{
    private Date date_naissance;
    private String sport_pratique;

    public Membre(int id, String nom, String prénom, String tele, String username, String pssword, String role, Date date_naissance, String sport_pratique) {
        super(id, nom, prénom, tele, username, pssword, role);
        this.date_naissance = date_naissance;
        this.sport_pratique = sport_pratique;
    }
    public Membre() {
        super();
    }

    public Date getDateNaissance() {
        return date_naissance;
    }

    public void setDateNaissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getSportPratique() {
        return sport_pratique;
    }

    public void setSportPratique(String sport_pratique) {
        this.sport_pratique = sport_pratique;
    }



}
