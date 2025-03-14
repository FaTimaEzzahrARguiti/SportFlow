package Contrellers;

import DAO.MembreDAO;
import Model.Membre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/membre/*")
public class MembreServlet extends HttpServlet {
    private MembreDAO membreDAO = new MembreDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) {
            response.sendRedirect(request.getContextPath() + "/membre/list");
            return;
        }
        try {
            switch (action) {
                case "/new":
                    addCondidat(request, response);
                    break;
                case "/new-form":
                    showNewForm(request, response);
                    break;
                case "/list":
                    listMembres(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/membre/list");
            }
        } catch (SQLException e) {
            throw new ServletException("Erreur base de données", e);
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addMembre.jsp").forward(req, resp);
    }

    private void addCondidat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String tele = req.getParameter("tele");
        String role = req.getParameter("role");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String dateNaissanceStr = req.getParameter("dateNaissance");
        String sportPratique = req.getParameter("sportPratique");

        // Convertir la date de String à Date
        Date dateNaissance;
        try {
            dateNaissance = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissanceStr);
        } catch (ParseException e) {
            throw new ServletException("Erreur de format de date", e);
        }

        Membre membre = new Membre(0, nom, prenom, tele, username, password, role, dateNaissance, sportPratique);
        HttpSession session = req.getSession();
        try {
            membreDAO.AddMembre(membre);
            session.setAttribute("message", "Membre ajouté avec succès");
            session.setAttribute("messageType", "success");
        } catch (SQLException e) {
            session.setAttribute("message", e.getMessage());
            session.setAttribute("messageType", "danger");
            throw e; // Propager pour debug
        }
        resp.sendRedirect(req.getContextPath() + "/membre/list");
    }

    private void listMembres(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Membre> membres = membreDAO.getAllMembres();
        req.setAttribute("membres", membres);
        req.getRequestDispatcher("/listeMembres.jsp").forward(req, resp);
    }
}