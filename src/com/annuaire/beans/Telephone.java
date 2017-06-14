package com.annuaire.beans;

public class Telephone {
    // SELECT id_telephone,id_personne,numero,typenumero,datecreation,datemaj FROM
    // telephone WHERE id_personne= '0' LIMIT 1
    private int id_telephone;
    private int id_personne;
    private String numero;
    private String typenumero;
    private String dateCreation;
    private String dateMaj;

    public Telephone() {
        new Telephone(0,0,"","","","");
    }
    
    public Telephone(int id_telephone, int id_personne, String numero, String typenumero,String dateCreation,String dateMaj) {
        this.setId_telephone(id_telephone);
        this.setId_personne(id_personne);
        this.setNumero(numero);
        this.setTypenumero(typenumero);
        this.setDateCreation(dateCreation);
        this.setDateMaj(dateMaj);
    }

    public int getId_telephone() {
        return id_telephone;
    }

    public void setId_telephone(int id_telephone) {
        this.id_telephone = id_telephone;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTypenumero() {
        return typenumero;
    }

    public void setTypenumero(String typenumero) {
        this.typenumero = typenumero;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(String dateMaj) {
        this.dateMaj = dateMaj;
    }

}
