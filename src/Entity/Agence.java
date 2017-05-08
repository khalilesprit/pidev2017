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
public class Agence {
    

     private Integer id;
     private String nom;
     private String ville;
     private String adresse;
     private int codePostal;
     private String telephone;
     private String numFiscal;
     private String image;
     private Date heureOuverture;
     private Date heureFermeture;

    public Agence() {
    }

	
    public Agence(String nom, String ville, String adresse, int codePostal, String telephone, String numFiscal, Date heureOuverture, Date heureFermeture) {
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.numFiscal = numFiscal;
        this.heureOuverture = heureOuverture;
        this.heureFermeture = heureFermeture;
    }
    public Agence(String nom, String ville, String adresse, int codePostal, String telephone, String numFiscal, String image, Date heureOuverture, Date heureFermeture) {
       this.nom = nom;
       this.ville = ville;
       this.adresse = adresse;
       this.codePostal = codePostal;
       this.telephone = telephone;
       this.numFiscal = numFiscal;
       this.image = image;
       this.heureOuverture = heureOuverture;
       this.heureFermeture = heureFermeture;
    }

    @Override
    public String toString() {
        return this.nom; //To change body of generated methods, choose Tools | Templates.
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getVille() {
        return this.ville;
    }
    
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
    public String getNumFiscal() {
        return this.numFiscal;
    }
    
    public void setNumFiscal(String numFiscal) {
        this.numFiscal = numFiscal;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Date getHeureOuverture() {
        return this.heureOuverture;
    }
    
    public void setHeureOuverture(Date heureOuverture) {
        this.heureOuverture = heureOuverture;
    }
    public Date getHeureFermeture() {
        return this.heureFermeture;
    }
    
    public void setHeureFermeture(Date heureFermeture) {
        this.heureFermeture = heureFermeture;
    }



    
}
