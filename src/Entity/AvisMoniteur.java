/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author KHALIL-PC
 */
public class AvisMoniteur {
    
     private Integer id;
     private Client client;
     private String contenu;
     private int rating;

    public AvisMoniteur() {
    }

	
    public AvisMoniteur(String contenu, int rating) {
        this.contenu = contenu;
        this.rating = rating;
    }
    public AvisMoniteur(Client client, String contenu, int rating) {
       this.client = client;
       this.contenu = contenu;
       this.rating = rating;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    public String getContenu() {
        return this.contenu;
    }
    
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public int getRating() {
        return this.rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }



}
