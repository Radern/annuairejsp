package com.annuaire.dao;


public abstract class AbstractDAOFactory {
    public static final int DAO_FACTORY = 0;
    public static final int XML_DAO_FACTORY = 1;

    public abstract AnnuaireDao getAnnuaireDao();

    // Méthode permettant de récupérer les Factory
    @SuppressWarnings("static-access")
    public static AbstractDAOFactory getFactory(int type) {
        switch (type) {
        case DAO_FACTORY:
            return new DaoFactorySql("", "", "").getInstance("jdbc:mysql://172.17.0.2:3306/annuaire", "annuaire",
                    "annuaire");
        case XML_DAO_FACTORY:
            System.out.println("A FAIRE");
        default:
            return null;
        }
    }
}