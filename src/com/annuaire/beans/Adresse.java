package com.annuaire.beans;

public class Adresse {
    // SELECT id_adresse,id_personne,rue1,rue2,codepostal,ville,datecreation,datemaj
    // FROM adresse WHERE id_personne= '0' LIMIT 1
    private int id_adresse;
    private int id_personne;
    private String rue1;
    private String rue2;
    private String codePostal;
    private String ville;
    private String dateCreation;
    private String dateMaj;

    public Adresse() {
        new Adresse(0,0,"","","","","","");
    }
    
    public Adresse(int id_adresse, int id_personne, String rue1, String rue2, String codePostal, String ville,
            String dateCreation, String dateMaj) {
        this.setId_adresse(id_adresse);
        this.setId_personne(id_personne);
        this.setRue1(rue1);
        this.setRue2(rue2);
        this.setCodePostal(codePostal);
        this.setVille(ville);
        this.setDateCreation(dateCreation);
        this.setDateMaj(dateMaj);
    }

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public String getRue1() {
        return rue1;
    }

    public void setRue1(String rue1) {
        this.rue1 = rue1;
    }

    public String getRue2() {
        return rue2;
    }

    public void setRue2(String rue2) {
        this.rue2 = rue2;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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
