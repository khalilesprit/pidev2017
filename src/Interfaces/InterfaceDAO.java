package Interfaces;
import java.util.List;
public interface InterfaceDAO <T> {
 
    
   public void ajouter(T t);
   public T getByID(long id);
   public void supprimer(T t);
   public void modifier(T t);
   public void afficher(T t);
   public List<T> afficherListe();
    
    
    
    
    
}