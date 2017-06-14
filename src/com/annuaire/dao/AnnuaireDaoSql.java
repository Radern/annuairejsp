package com.annuaire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.annuaire.beans.Adresse;
import com.annuaire.beans.Personne;
import com.annuaire.beans.Telephone;

public class AnnuaireDaoSql implements AnnuaireDao {
    private DaoFactorySql daoFactory;

    AnnuaireDaoSql(DaoFactorySql daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void creer(Personne personne) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            // Parcourir tous les sous titres et les sauver en base
            int id = 0;
            String nom = personne.getNom();
            String prenom = personne.getPrenom();
            preparedStatement = connexion
                    .prepareStatement("INSERT INTO personne(nom,prenom,datecreation,datemaj) VALUES(?,?,Now(),Now())");
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.executeUpdate();

            Statement statement = null;
            ResultSet resultat = null;

            // chercher id du dernier ajout
            try {
                statement = connexion.createStatement();
                resultat = statement.executeQuery(
                        "SELECT id FROM personne WHERE nom='" + nom + "' and prenom='" + prenom + "' order by id desc");
                while (resultat.next()) {
                    id = resultat.getInt("id");
                }

                preparedStatement = connexion.prepareStatement(
                        "INSERT INTO adresse(id_personne,rue1,rue2,codepostal,ville,datecreation,datemaj) VALUES(?,?,?,?,?,Now(),Now())");
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, personne.getAdresse().getRue1());
                preparedStatement.setString(3, personne.getAdresse().getRue2());
                preparedStatement.setString(4, personne.getAdresse().getCodePostal());
                preparedStatement.setString(5, personne.getAdresse().getVille());
                preparedStatement.executeUpdate();

                preparedStatement = connexion.prepareStatement(
                        "INSERT INTO telephone(id_personne,numero,typenumero,datecreation,datemaj) VALUES(?,?,?,Now(),Now())");
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, personne.getTelephone().getNumero());
                preparedStatement.setString(3, personne.getTelephone().getTypenumero());
                preparedStatement.executeUpdate();
                connexion.commit();

            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            } finally {
                try {
                    if (connexion != null) {
                        connexion.close();
                    }
                } catch (SQLException e) {
                    throw new DaoException("Impossible de communiquer avec la base de données");
                }
            }

        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        } finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
    }

    @Override
    public void modifier(Personne personne) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            // Parcourir tous les sous titres et les sauver en base
            int id_personne = personne.getId();
            preparedStatement = connexion
                    .prepareStatement("UPDATE personne SET nom=?,prenom=?,datemaj=Now() WHERE id=?;");
            preparedStatement.setString(1, personne.getNom());
            preparedStatement.setString(2, personne.getPrenom());
            preparedStatement.setInt(3, id_personne);
            preparedStatement.executeUpdate();

            preparedStatement = connexion.prepareStatement(
                    "UPDATE adresse SET rue1=?,rue2=?,codepostal=?,ville=?,datemaj=Now() WHERE id_personne=?;");
            preparedStatement.setString(1, personne.getAdresse().getRue1());
            preparedStatement.setString(2, personne.getAdresse().getRue2());
            preparedStatement.setString(3, personne.getAdresse().getCodePostal());
            preparedStatement.setString(4, personne.getAdresse().getVille());
            preparedStatement.setInt(5, id_personne);
            preparedStatement.executeUpdate();

            preparedStatement = connexion
                    .prepareStatement("UPDATE telephone SET numero=?,typenumero=?,datemaj=Now() WHERE id_personne=?;");
            preparedStatement.setString(1, personne.getTelephone().getNumero());
            preparedStatement.setString(2, personne.getTelephone().getTypenumero());
            preparedStatement.setInt(3, id_personne);
            preparedStatement.executeUpdate();
            connexion.commit();

        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        } finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
    }

    @Override
    public List<Personne> lister() throws DaoException {
        List<Personne> personnes = new ArrayList<Personne>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();

            resultat = statement.executeQuery("SELECT id FROM personne WHERE id > 0");
            while (resultat.next()) {
                int id = resultat.getInt("id");
                Personne personne = lirePersonne(connexion, id);
                personnes.add(personne);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        } finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return personnes;
    }

    @Override
    public Personne consulter(int id_personne) throws DaoException {
        Personne personne = null;
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id FROM personne WHERE id='" + id_personne + "' limit 1");
            while (resultat.next()) {
                int id = resultat.getInt("id");
                personne = lirePersonne(connexion, id);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        } finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return personne;
    }

    @Override
    public boolean supprimer(int id_personne) throws DaoException {
        Connection connexion = null;
        boolean bln_result = false;
        try {
            connexion = daoFactory.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connexion.prepareStatement("DELETE FROM personne WHERE id=?");
            preparedStatement.setInt(1, id_personne);
            preparedStatement.executeUpdate();
            preparedStatement = connexion.prepareStatement("DELETE FROM telephone WHERE id_personne=?");
            preparedStatement.setInt(1, id_personne);
            preparedStatement.executeUpdate();
            preparedStatement = connexion.prepareStatement("DELETE FROM adresse WHERE id_personne=?");
            preparedStatement.setInt(1, id_personne);
            preparedStatement.executeUpdate();
            connexion.commit();

            bln_result = true;
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        } finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return bln_result;
    }

    private Personne lirePersonne(Connection connexion, int id_personne) throws DaoException {
        ResultSet resultatPersonne = null;
        Statement statement = null;
        Personne personne = null;
        try {
            statement = connexion.createStatement();
            resultatPersonne = statement.executeQuery(
                    "SELECT id,nom,prenom,datecreation,datemaj FROM personne WHERE id = '" + id_personne + "'");

            while (resultatPersonne.next()) {
                int id = resultatPersonne.getInt("id");
                String nom = resultatPersonne.getString("nom");
                String prenom = resultatPersonne.getString("prenom");
                String datecreation = resultatPersonne.getString("datecreation");
                String datemaj = resultatPersonne.getString("datemaj");
                Adresse adresse = lireAdresse(connexion, id);
                Telephone telephone = lireTelephone(connexion, id);
                personne = new Personne(id, nom, prenom, adresse, telephone, datecreation, datemaj);
                personne.setTelephone(telephone);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        return personne;
    }

    private Adresse lireAdresse(Connection connexion, int id_personne) throws DaoException {
        ResultSet resultatAdresse = null;
        Statement statement = null;
        Adresse adresse = null;
        try {
            statement = connexion.createStatement();
            resultatAdresse = statement.executeQuery(
                    "SELECT id_adresse,id_personne,rue1,rue2,codepostal,ville,datecreation,datemaj FROM adresse WHERE id_personne= '"
                            + id_personne + "' LIMIT 1");

            while (resultatAdresse.next()) {
                int id_adresse = resultatAdresse.getInt("id_adresse");
                String rue1 = resultatAdresse.getString("rue1");
                String rue2 = resultatAdresse.getString("rue2");
                String codepostal = resultatAdresse.getString("codepostal");
                String ville = resultatAdresse.getString("ville");
                String dateCreation = resultatAdresse.getString("datecreation");
                String dateMaj = resultatAdresse.getString("datemaj");
                adresse = new Adresse(id_adresse, id_personne, rue1, rue2, codepostal, ville, dateCreation, dateMaj);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        return adresse;
    }

    private Telephone lireTelephone(Connection connexion, int id_personne) throws DaoException {
        ResultSet resultatTelephone = null;
        Statement statement = null;
        Telephone telephone = null;
        try {
            statement = connexion.createStatement();
            resultatTelephone = statement.executeQuery(
                    "SELECT id_telephone,id_personne,numero,typenumero,datecreation,datemaj FROM telephone WHERE id_personne= '"
                            + id_personne + "' LIMIT 1");

            while (resultatTelephone.next()) {
                int id_telephone = resultatTelephone.getInt("id_telephone");
                String numero = resultatTelephone.getString("numero");
                String typenumero = resultatTelephone.getString("typenumero");
                String dateCreation = resultatTelephone.getString("datecreation");
                String dateMaj = resultatTelephone.getString("datemaj");
                telephone = new Telephone(id_telephone, id_personne, numero, typenumero, dateCreation, dateMaj);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        return telephone;
    }
}