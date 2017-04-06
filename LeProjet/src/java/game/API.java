/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Groupe MASTER
 */
public interface API {
    
    /**
     * fonction d'nitialisation, instancie le jeu, les joueurs
     */
    public void initialisation();
    
    /**
     * 
     * @param numJoueur le numero du joueur ui doit jouer
     * @param coup l'action réalisée par le joueur
     * @return True si l'action a été effectuée
     */
    public boolean action(int numJoueur, int coup);
    
    //qui renvoie quel joueur doit joueur ou partie finie
    public boolean status();

    /**
     * Fonctioh qui donne des infos sur les vainqueur
     * return num du joueur, si game pas fini return 0 , et si match nul ??
     * 
    */
    public int vainqueur();
    
    /**
     * renvoi la derniere action
     * @return renvoie chaine de charactere qui renvoie la dernière action valide du joueur si c'est 0, c'est l'initialisation
     */
    public int derniereAction();

    /**
     * affiche ce qu'il s'est passé
     * @return le string de l'action
     */
    public String Affichage(); 
    
}
