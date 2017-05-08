/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import static java.lang.Integer.min;
import java.sql.Date;
import java.time.LocalDate;
/**
 *
 * @author KHALIL-PC
 */
public class Moniteur {
    

     private Integer id;
     private Agence agence;
     private String civilite;
     private String nom;
     private String prenom;
     private String adresse;
     private String mail;
     private String ville;
     private int codePostal;
     private int telephone;
     private Date dateNaissance;
     private String lieuNaissance;
     private String photo;
     private Integer id_agence;
//      assert ( codePostal >= 0 && codePostal <= 10 ) : "bad number: " + codePostal;
//assertTrue (min <= 1000 and 9999 <= max);

    public Moniteur() {
    }

    public Moniteur(int agence, String civilite, String nom, String prenom, String adresse, String mail, String ville, int codePostal, int telephone, Date dateNaissance, String lieuNaissance, String photo) {
       this.id_agence = agence;
       this.civilite = civilite;
       this.nom = nom;
       this.prenom = prenom;
       this.adresse = adresse;
       this.mail = mail;
       this.ville = ville;
       this.codePostal = codePostal;
       this.telephone = telephone;
       this.dateNaissance = dateNaissance;
       this.lieuNaissance = lieuNaissance;
       this.photo = photo;
    }

    
	
    public Moniteur(String civilite, String nom, String prenom, String adresse, String mail, String ville, int codePostal, int telephone, Date dateNaissance, String lieuNaissance, String photo) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.photo = photo;
    }
    public Moniteur(Agence agence, String civilite, String nom, String prenom, String adresse, String mail, String ville, int codePostal, int telephone, Date dateNaissance, String lieuNaissance, String photo) {
       this.agence = agence;
       this.civilite = civilite;
       this.nom = nom;
       this.prenom = prenom;
       this.adresse = adresse;
       this.mail = mail;
       this.ville = ville;
       this.codePostal = codePostal;
       this.telephone = telephone;
       this.dateNaissance = dateNaissance;
       this.lieuNaissance = lieuNaissance;
       this.photo = photo;

    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Agence getAgence() {
        return this.agence;
    }
    
    public void setAgence(Agence agence) {
        this.agence = agence;
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
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
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
    public int getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public Date getDateNaissance() {
        return this.dateNaissance;
    }
    
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getLieuNaissance() {
        return this.lieuNaissance;
    }
    
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }
    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getId_agence() {
        return id_agence;
    }

    public void setId_agence(Integer id_agence) {
        this.id_agence = id_agence;
    }
  



    
}
