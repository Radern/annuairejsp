package com.annuaire.dao;

import java.util.List;

import com.annuaire.beans.Personne;

public interface AnnuaireDao {

    // Permet de créer un enregistrement du SRT sur support DAO
    void creer(Personne personne) throws DaoException;

    // Permet de modifier un contgenu SRT sur support DAO
    void modifier(Personne personne) throws DaoException;

    // Permet d'avoir la liste des personnes depuis support DAO
    List<Personne> lister() throws DaoException;

    // Permet de supprimer une personne du support DAO
    boolean supprimer(int id_personne) throws DaoException;

    // Permet de voir une personneparticulière depuis support DAO
    Personne consulter(int id_personne) throws DaoException;

}