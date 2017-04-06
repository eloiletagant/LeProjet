/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Groupe
 */
public interface API {
    
    public void initialisation();
    
    public boolean action(int numJoueur, int coup);
    
    //qui renvoie quel joueur doit joueur ou partie finie
    public boolean status();

    //Return 1,2 ou 0 si match nul
    public int vainqueur();

    //renvoie chaine de charactere qui renvoie la dernière action valide du joueur si c'est 0, c'est l'initialisation
    public int derniereAction();

    //affiche ce qu'il s'est passé
    public String Affichage(); 
    
}
