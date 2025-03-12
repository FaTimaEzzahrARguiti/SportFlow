package Model;

public class User {
    private int id;
    private String nom;
    private String prénom;
    private String tele;
    private String username;
    private String pssword;
    private String role;

    public User() {

    }

    public User(String nom, String prénom, String tele, String username, String pssword, String role) {

        this.nom = nom;
        this.prénom = prénom;
        this.tele = tele;
        this.username = username;
        this.pssword = pssword;
        this.role = role;
    }

    public User(int id, String nom, String prénom, String tele, String username, String pssword, String role) {
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.tele = tele;
        this.username = username;
        this.pssword = pssword;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPssword() {
        return pssword;
    }

    public void setPssword(String pssword) {
        this.pssword = pssword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prénom='" + prénom + '\'' +
                ", tele='" + tele + '\'' +
                ", username='" + username + '\'' +
                ", pssword='" + pssword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
