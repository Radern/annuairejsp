package com.annuaire.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annuaire.beans.Personne;
import com.annuaire.dao.AbstractDAOFactory;
import com.annuaire.dao.AnnuaireDao;
import com.annuaire.dao.DaoException;

/**
 * Servlet implementation class Consultation
 */
@WebServlet("/Consultation")
public class Consultation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consultation() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Personne> personnes = null;

        // Se connecter avec DAO a la bdd
        AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
        AnnuaireDao annuaireDao = adf.getAnnuaireDao();
        // Faire un effacement si cela est demandéZ
        if (request.getParameter("action") != null && request.getParameter("fiche") != null) {
            String action = request.getParameter("action");
            if (action.equals("Effacer")) {
                try {
                    String id_personne = request.getParameter("fiche");
                    boolean effacer = annuaireDao.supprimer(Integer.parseInt(id_personne));
                    if (effacer == true) {
                        System.out.println("Effacement ok");
                    }
                } catch (DaoException e) {
                    System.out.println("Erreur : Impossible de supprimer");
                }
            }
        }
        // Préparer la liste des personnes et stocker résultat pour la jsp
        try {
            personnes = annuaireDao.lister();
        } catch (DaoException e) {
            System.out.println("Erreur : Impossible de lister");
        }
        request.setAttribute("personnes", personnes);
        this.getServletContext().getRequestDispatcher("/WEB-INF/consultation.jsp").forward(request, response);
    }

}
