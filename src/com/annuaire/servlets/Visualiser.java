package com.annuaire.servlets;

import java.io.IOException;

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
 * Servlet implementation class Visualiser
 */
@WebServlet("/Visualiser")
public class Visualiser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visualiser() {
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
        AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
        AnnuaireDao annuaireDao = adf.getAnnuaireDao();
        // charger la bonne fiche si paramètre
        if (request.getParameter("fiche") != null) {
            try {
                int numero = Integer.parseInt(request.getParameter("fiche"));
                personne = annuaireDao.consulter(numero);
            } catch (DaoException e) {
                System.out.println("Erreur : Impossible de lister");
            }
        }
        request.setAttribute("personne", personne);
        this.getServletContext().getRequestDispatcher("/WEB-INF/visualiser.jsp").forward(request, response);
    }

}
