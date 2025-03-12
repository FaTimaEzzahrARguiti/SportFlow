package Model;

public class Entraineur extends User{

    private int id;
    private String specialite;

    public Entraineur(int id, String nom, String prénom, String tele, String username, String pssword, String role, int id1, String specialite) {
        super(id, nom, prénom, tele, username, pssword, role);
        this.id = id1;
        this.specialite = specialite;
    }

    public Entraineur() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
