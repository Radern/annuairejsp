package com.annuaire.beans;

public class Personne {
//SELECT id,nom,prenom,datecreation,datemaj FROM personne WHERE id > 0 ORDER BY id DESC LIMIT 0,2
    private int id;
    private String nom;
    private String prenom;
    private String dateCreation;
    private String dateMaj;
    private Adresse adresse;
    private Telephone telephone;
    
    public Personne() {
        new Personne(0,"","",new Adresse(),new Telephone(),"","");
    }
    
    public Personne(int id,String nom,String prenom,Adresse adresse, Telephone telephone,String dateCreation,String dateMaj) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setTelephone(telephone);
        this.setDateCreation(dateCreation);
        this.setDateMaj(dateMaj);
    }
    public Adresse getAdresse() {
        return adresse;
    }
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    public Telephone getTelephone() {
        return telephone;
    }
    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
