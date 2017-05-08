/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author KHALIL-PC
 */
public class Client {
    private Integer id;
     private Moniteur moniteur;
     private String civilite;
     private String nom;
     private String prenom;
     private String adresse;
     private String ville;
     private int codePostal;
     private String telephone;
     private Date dateNaissance;
     private String villeNaissance;
     private boolean etatCode;


    public Client() {
    }

	
    public Client(String civilite, String nom, String prenom, String adresse, String ville, int codePostal, String telephone, Date dateNaissance, String villeNaissance, boolean etatCode) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.villeNaissance = villeNaissance;
        this.etatCode = etatCode;
    }
    public Client(Moniteur moniteur, String civilite, String nom, String prenom, String adresse, String ville, int codePostal, String telephone, Date dateNaissance, String villeNaissance, boolean etatCode) {
       this.moniteur = moniteur;
       this.civilite = civilite;
       this.nom = nom;
       this.prenom = prenom;
       this.adresse = adresse;
       this.ville = ville;
       this.codePostal = codePostal;
       this.telephone = telephone;
       this.dateNaissance = dateNaissance;
       this.villeNaissance = villeNaissance;
       this.etatCode = etatCode;

    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Moniteur getMoniteur() {
        return this.moniteur;
    }
    
    public void setMoniteur(Moniteur moniteur) {
        this.moniteur = moniteur;
    }
    public String getCivilite() {
        return this.civilite;
    }
    
    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getVille() {
        return this.ville;
    }
    
    public void setVille(String ville) {
        this.ville = ville;
    }
    public int getCodePostal() {
        return this.codePostal;
    }
    
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Date getDateNaissance() {
        return this.dateNaissance;
    }
    
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getVilleNaissance() {
        return this.villeNaissance;
    }
    
    public void setVilleNaissance(String villeNaissance) {
        this.villeNaissance = villeNaissance;
    }
    public boolean isEtatCode() {
        return this.etatCode;
    }
    
    public void setEtatCode(boolean etatCode) {
        this.etatCode = etatCode;
    }

    
}
