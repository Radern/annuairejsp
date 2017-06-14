package com.annuaire.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactorySql extends AbstractDAOFactory {
    private String url;
    private String username;
    private String password;

    DaoFactorySql(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactorySql getInstance(String url, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }
        DaoFactorySql instance = new DaoFactorySql(url, username, password);
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connexion = DriverManager.getConnection(url, username, password);
        connexion.setAutoCommit(false);
        return connexion;
    }

    // Récupération du Dao
    public AnnuaireDao getAnnuaireDao() {
        return new AnnuaireDaoSql(this);
    }
}