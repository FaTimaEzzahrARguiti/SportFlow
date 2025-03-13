package Model;

public class User {
    private int idUser;
    private String nom;
    private String prenom;
    private String tele;
    private String username;
    private String password;
    private String role;

    public User() {

    }

    public User(String nom, String prenom, String tele, String username, String password, String role) {

        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(int idUser, String nom, String prenom, String tele, String username, String password, String role) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prénom) {
        this.prenom = prenom;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                "id=" + idUser +
                ", nom='" + nom + '\'' +
                ", prénom='" + prenom + '\'' +
                ", tele='" + tele + '\'' +
                ", username='" + username + '\'' +
                ", pssword='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
