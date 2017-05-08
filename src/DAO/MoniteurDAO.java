package DAO;

import Entity.Agence;
import Entity.AvisMoniteur;
import Entity.Client;
import Tools.DataBase;
import Entity.Moniteur;
import Interfaces.InterfaceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MoniteurDAO implements InterfaceDAO<Moniteur> {

    Connection connection;
    PreparedStatement ps, ps2;
    ResultSet rs;

    public MoniteurDAO() {
        connection = DataBase.getInstance().getConnection();

    }

    @Override
    public void afficher(Moniteur t) {

    }

    @Override
    public Moniteur getByID(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Moniteur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void modifier(Moniteur p) {
        String req ="UPDATE `moniteur` SET `agence_id`=?,`civilite`=?,"
                + "`nom`=?,`prenom`=?,`adresse`=?,`mail`=?,`ville`=?,"
                + "`codePostal`=?,`telephone`=?,"
                + "`lieuNaissance`=?,`photo`=? WHERE id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, p.getId_agence());
            ps.setString(2, p.getCivilite());
            ps.setString(3, p.getNom());
            ps.setString(4, p.getPrenom());
            ps.setString(5, p.getAdresse());
            ps.setString(6, p.getMail());
            ps.setString(7, p.getVille());
            ps.setInt(8, p.getCodePostal());
            ps.setInt(9, p.getTelephone());
            ps.setString(10, p.getLieuNaissance());
            ps.setString(11, p.getPhoto());
            ps.setInt(12, p.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MoniteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
        @Override
    public List<Moniteur> afficherListe() {
        {
            List<Moniteur> liste = new ArrayList();
            String req = "SELECT * FROM `moniteur`";
            String req1="SELECT i.*, u.nom FROM moniteur i LEFT JOIN agence u ON "
                    + "(i.agence_id = u.id)";
            try {
                ps = connection.prepareStatement(req1);
                rs = ps.executeQuery();
                Moniteur moniteur;
                while (rs.next()) {
                    moniteur = new Moniteur();
                    moniteur.setId(rs.getInt("id"));
                    moniteur.setCivilite(rs.getString("civilite"));
                    moniteur.setVille(rs.getString("ville"));
                    moniteur.setNom(rs.getString("nom"));
                    moniteur.setPrenom(rs.getString("prenom"));
                    moniteur.setMail(rs.getString("mail"));
                    moniteur.setAdresse(rs.getString("adresse"));
                    moniteur.setLieuNaissance(rs.getString("lieuNaissance"));
                    moniteur.setPhoto(rs.getString("photo"));
                    moniteur.setTelephone(rs.getInt("telephone"));
                    moniteur.setCodePostal(rs.getInt("codePostal"));
                    moniteur.setId_agence(rs.getInt("agence_id"));
                    Agence a = new Agence();
                    a.setId(rs.getInt("agence_id"));
                    a.setNom(rs.getString(14));
                    moniteur.setAgence(a);

                    liste.add(moniteur);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return liste;
        }
    }
    

    public Moniteur AffichMoniteur() {
        {
            Moniteur moniteur = new Moniteur();
            String req = "SELECT * FROM `moniteur`";
            try {
                ps = connection.prepareStatement(req);
                rs = ps.executeQuery();
                while (rs.next()) {
                    moniteur = new Moniteur();
                    moniteur.setId(rs.getInt("id"));
                    moniteur.setCivilite(rs.getString("civilite"));
                    moniteur.setVille(rs.getString("ville"));
                    moniteur.setNom(rs.getString("nom"));
                    moniteur.setPrenom(rs.getString("prenom"));
                    moniteur.setMail(rs.getString("mail"));
                    moniteur.setAdresse(rs.getString("adresse"));
                    moniteur.setLieuNaissance(rs.getString("lieuNaissance"));
                    moniteur.setPhoto(rs.getString("photo"));
                    moniteur.setTelephone(rs.getInt("telephone"));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return moniteur;
        }
    }

    @Override
    public void ajouter(Moniteur R) {
        try {
            String req = "INSERT INTO `moniteur`(`agence_id`, `civilite`, `nom`, `prenom`, `adresse`, `mail`, `ville`, `codePostal`, `telephone`, `dateNaissance`, `lieuNaissance`, `photo`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, R.getAgence().getId());
            ps.setString(2, R.getCivilite());
            ps.setString(3, R.getNom());
            ps.setString(4, R.getPrenom());
            ps.setString(5, R.getAdresse());
            ps.setString(6, R.getMail());
            ps.setString(7, R.getVille());
            ps.setInt(8, R.getCodePostal());
            ps.setInt(9, R.getTelephone());
            ps.setDate(10, R.getDateNaissance());
            ps.setString(11, R.getLieuNaissance());
            ps.setString(12, R.getPhoto());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MoniteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public List<String> afficheragence() {
        {
            List<String> liste = new ArrayList();

            String req = "SELECT nom FROM `agence`";
            try {
                ps = connection.prepareStatement(req);
                rs = ps.executeQuery();
                while (rs.next()) {
                    liste.add(rs.getString(1));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return liste;
        }
    }

    public Agence findByNomAgence(String nom) {
        {
            Agence agence = new Agence();

//            String req = "SELECT * FROM `agence` where nom=?";
            String req= "SELECT * FROM agence WHERE nom=?";
            try {
                ps = connection.prepareStatement(req);
                
                ps.setString(1, nom);
                rs = ps.executeQuery();
                while (rs.next()) {
                    
                    agence.setId(rs.getInt("id"));
                    agence.setNom(rs.getString("nom"));                 
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return agence;
        }
    }
    
    public Agence findByIdAgence(int id) {
        {
            Agence agence = new Agence();

//            String req = "SELECT * FROM `agence` where nom=?";
            String req= "SELECT * FROM agence WHERE id=?";
            try {
                ps = connection.prepareStatement(req);
                
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    
                    agence.setId(rs.getInt("id"));
                    agence.setNom(rs.getString("nom"));                 
                }
                return agence;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }
    
    public Moniteur findIdAgenceById(int id) {
        {
            Moniteur m = new Moniteur();

            Agence a = new Agence();
//            String req = "SELECT * FROM `agence` where nom=?";
            String req= "SELECT agnece_id FROM moniteur WHERE id=?";
            try {
                ps = connection.prepareStatement(req);
                
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    a.setId(rs.getInt("agence_id"));
                    m.setAgence(a);                 
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return m;
        }
    }
    
    
    public void deleteMoniteur(int id) {
        String requete = "delete from moniteur where id=?";
        try {
            ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    
    public void insertAvis(AvisMoniteur a)
    {
        try {
            String req="INSERT INTO `avis_moniteur`(`client_id`, `contenu`, `rating`) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, a.getClient().getId());
            ps.setString(2, a.getContenu());
            ps.setInt(3, a.getRating());          
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MoniteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<AvisMoniteur> afficherAvisByIdClient(int id) {
        List<AvisMoniteur> liste = new ArrayList();
        String req = "SELECT * FROM `avis_moniteur` where `client_id`=?";
        try {
                ps = connection.prepareStatement(req);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                AvisMoniteur moniteur;
                while (rs.next()) {
                    moniteur = new AvisMoniteur();
                    moniteur.setId(rs.getInt("id"));
                    Client c = new Client();
                    c.setId(rs.getInt("client_id"));
                    moniteur.setClient(c);
                    moniteur.setContenu(rs.getString("contenu"));
                    moniteur.setRating(rs.getInt("rating"));                    
                    liste.add(moniteur);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return liste;
    }
    
    public ObservableList<Moniteur> listeMoniteur() throws SQLException 
     {
        final ObservableList<Moniteur> list;
        list = FXCollections.observableArrayList();
        try {
             
            String req = "select * from moniteur" ;
            PreparedStatement ps = connection.prepareStatement(req);
            
            rs = ps.executeQuery();
           
               
                Moniteur moniteur;
                while (rs.next()) {
                    moniteur = new Moniteur();
                    moniteur.setId(rs.getInt("id"));
                    moniteur.setCivilite(rs.getString("civilite"));
                    moniteur.setVille(rs.getString("ville"));
                    moniteur.setNom(rs.getString("nom"));
                    moniteur.setPrenom(rs.getString("prenom"));
                    moniteur.setMail(rs.getString("mail"));
                    moniteur.setAdresse(rs.getString("adresse"));
                    moniteur.setLieuNaissance(rs.getString("lieuNaissance"));
                    moniteur.setPhoto(rs.getString("photo"));
                    moniteur.setTelephone(rs.getInt("telephone"));
                    moniteur.setCodePostal(rs.getInt("codePostal"));
                    moniteur.setId_agence(rs.getInt("agence_id"));
                    
           list.add(moniteur);
               
            }
     
     } catch (SQLException ex) {
            Logger.getLogger(MoniteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list ; 
}
   
}
