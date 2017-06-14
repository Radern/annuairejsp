package com.annuaire.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annuaire.beans.Adresse;
import com.annuaire.beans.Personne;
import com.annuaire.beans.Telephone;
import com.annuaire.dao.AbstractDAOFactory;
import com.annuaire.dao.AnnuaireDao;
import com.annuaire.dao.DaoException;

/**
 * Servlet implementation class Formulaires
 */
@WebServlet("/Formulaires")
public class Formulaires extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formulaires() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Personne personne = new Personne();
        if (request.getParameter("action") != null && request.getParameter("fiche") != null) {
            if (request.getParameter("action").equals("Modifier")) {
                AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
                AnnuaireDao annuaireDao = adf.getAnnuaireDao();
                // Dans un cas de modification, charger la fiche
                int numero = Integer.parseInt(request.getParameter("fiche"));
                try {
                    personne = annuaireDao.consulter(numero);
                    request.setAttribute("action", "Modifier");
                } catch (DaoException e) {
                    System.out.println("Erreur : Impossible de charger la fiche");
                }
            }
        }
        request.setAttribute("personne", personne);
        this.getServletContext().getRequestDispatcher("/WEB-INF/formulaires.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("fiche") != null) {
            // id=0 si nouveau, sinon valeur de l'id personne
            int id = Integer.parseInt(request.getParameter("fiche"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String numero = request.getParameter("numero");
            String typenumero = request.getParameter("typenumero");
            String rue1 = request.getParameter("rue1");
            String rue2 = request.getParameter("rue2");
            String codepostal = request.getParameter("codepostal");
            String ville = request.getParameter("ville");
            Adresse adresse = new Adresse(0, id, rue1, rue2, codepostal, ville, "", "");
            Telephone telephone = new Telephone(0, id, numero, typenumero, "", "");
            Personne personne = new Personne(id, nom, prenom, adresse, telephone, "", "");
            AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
            AnnuaireDao annuaireDao = adf.getAnnuaireDao();
            request.setAttribute("personne", personne);
            try {
                if (id==0) 
                {
                    annuaireDao.creer(personne);
                    request.setAttribute("message", "Création de la fiche ok");
                } else {
                    annuaireDao.modifier(personne);
                    request.setAttribute("message", "Modification de la fiche ok");
                }

            } catch (DaoException e) {
                System.out.println("ERREUR dans la sauvegarde.");
                request.setAttribute("message", "Soucis, merci de voir l'administrateur");
            }
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/formulaires.jsp").forward(request, response);
    }

}
