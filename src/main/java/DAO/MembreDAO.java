package DAO;

import Config.DbConfig;
import Model.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class MembreDAO {


        // 1. Ajouter un membre
        public void AddMembre(Membre membre) throws SQLException {
            Connection conn = null;
            try {
                conn = DbConfig.getConnection();
                conn.setAutoCommit(false); // Démarrer une transaction

                String query = "INSERT INTO user (nom, prenom, tele, username, password, role) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, membre.getNom());
                    stmt.setString(2, membre.getPrenom());
                    stmt.setString(3, membre.getTele());
                    stmt.setString(4, membre.getUsername());
                    stmt.setString(5, membre.getPassword());
                    stmt.setString(6, membre.getRole()); // Utiliser le rôle dynamique
                    stmt.executeUpdate();

                    ResultSet rs = stmt.getGeneratedKeys();
                    int userId = 0;
                    if (rs.next()) {
                        userId = rs.getInt(1);
                    }
                    rs.close();

                    // Insérer dans membre uniquement si le rôle est "membre"
                    if ("membre".equalsIgnoreCase(membre.getRole())) {
                        String sql = "INSERT INTO membre (id_membre, date_naissance, sport_pratique) VALUES (?, ?, ?)";
                        try (PreparedStatement stmtMembre = conn.prepareStatement(sql)) {
                            stmtMembre.setInt(1, userId);
                            stmtMembre.setDate(2, new java.sql.Date(membre.getDate_naissance().getTime()));
                            stmtMembre.setString(3, membre.getSport_pratique());
                            stmtMembre.executeUpdate();
                        }
                    }

                    conn.commit(); // Valider la transaction
                }
            } catch (SQLException e) {
                if (conn != null) {
                    try {
                        conn.rollback(); // Annuler en cas d'erreur
                    } catch (SQLException rollbackEx) {
                        rollbackEx.printStackTrace();
                    }
                }
                throw new SQLException("Erreur lors de l'ajout du membre : " + e.getMessage(), e);
            } finally {
                if (conn != null) {
                    try {
                        conn.close(); // Fermer la connexion
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // 2. Obtenir un membre par ID
        // Dans getMembreById
        public Membre getMembreById(int id) throws SQLException {
            try (Connection conn = DbConfig.getConnection()) {
                if (conn != null) {
                    String query = "SELECT u.*, m.date_naissance, m.sport_pratique " +
                            "FROM user u LEFT JOIN membre m ON u.id_user = m.id_membre " +
                            "WHERE u.id_user = ?";
                    try (PreparedStatement stmt = conn.prepareStatement(query)) {
                        stmt.setInt(1, id);
                        ResultSet rs = stmt.executeQuery();

                        Membre membre = null;
                        if (rs.next()) {
                            membre = new Membre(
                                    rs.getInt("id_user"),
                                    rs.getString("nom"),
                                    rs.getString("prenom"),
                                    rs.getString("tele"),
                                    rs.getString("username"),
                                    rs.getString("password"),
                                    rs.getString("role"),
                                    rs.getDate("date_naissance"), // Peut être null pour admin/entraineur
                                    rs.getString("sport_pratique") // Peut être null pour admin/entraineur
                            );
                        }
                        return membre;
                    }
                }
            }
            return null;
        }

        // Dans getAllMembres
        public List<Membre> getAllMembres() throws SQLException {
            List<Membre> membres = new ArrayList<>();
            try (Connection conn = DbConfig.getConnection()) {
                if (conn != null) {
                    String query = "SELECT u.*, m.date_naissance, m.sport_pratique " +
                            "FROM user u LEFT JOIN membre m ON u.id_user = m.id_membre";
                    try (Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery(query)) {
                        while (rs.next()) {
                            Membre membre = new Membre(
                                    rs.getInt("id_user"),
                                    rs.getString("nom"),
                                    rs.getString("prenom"),
                                    rs.getString("tele"),
                                    rs.getString("username"),
                                    rs.getString("password"),
                                    rs.getString("role"),
                                    rs.getDate("date_naissance"),
                                    rs.getString("sport_pratique")
                            );
                            membres.add(membre);
                        }
                    }
                }
            }
            return membres;
        }
        // 4. Mettre à jour un membre
        public void UpdateMembre(Membre membre) throws SQLException {
            try (Connection conn = DbConfig.getConnection()) {
                if (conn != null) {
            String query = "UPDATE user u JOIN membre m ON u.id_user = m.id_membre " +
                    "SET u.nom = ?, u.prenom = ?, u.tele = ?, u.username = ?, u.password = ?, m.date_naissance = ?, m.sport_pratique = ? " +
                    "WHERE u.id_user = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, membre.getNom());
            stmt.setString(2, membre.getPrenom());
            stmt.setString(3, membre.getTele());
            stmt.setString(4, membre.getUsername());
            stmt.setString(5, membre.getPassword());
            stmt.setDate(6, new Date(membre.getDate_naissance().getTime()));
            stmt.setString(7, membre.getSport_pratique());
            stmt.setInt(8, membre.getId());

            stmt.executeUpdate();
            stmt.close();
        }}}

        // 5. Supprimer un membre
        public void DeleteMembre(int id) throws SQLException {
            try (Connection conn = DbConfig.getConnection()) {
                if (conn != null) {
                    // Supprimer d'abord dans la table membre (clé étrangère)
                    String deleteMembre = "DELETE FROM membre WHERE id_membre = ?";
                    PreparedStatement stmtMembre = conn.prepareStatement(deleteMembre);
                    stmtMembre.setInt(1, id);
                    stmtMembre.executeUpdate();
                    stmtMembre.close();

                    // Supprimer ensuite dans la table user
                    String deleteUser = "DELETE FROM user WHERE id_user = ?";
                    PreparedStatement stmtUser = conn.prepareStatement(deleteUser);
                    stmtUser.setInt(1, id);
                    stmtUser.executeUpdate();
                    stmtUser.close();
                }
            }
        }


}
