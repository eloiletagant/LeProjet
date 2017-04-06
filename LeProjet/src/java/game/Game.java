/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import interfaceAPI.API;

/**
 *
 * @author Anatole
 */
public class Game implements API {


    
    public void Game(){
        this.initialisation();
        while (status()!="terminé"){ //tant que le status du jeu n'est pas sur "y'a un gagant"
            Integer nbrJoueur = Integer.parseInt(status()); //on trnastype vers de l'int
            
        }
    }

    @Override
    public void initialisation() {

    }

    @Override
    public boolean action(int numJoueur, int coup) {
        return true;
    }

    @Override
    public String status() {
        return null;
    }

    @Override
    public int vainqueur() {
        return 0;
    }

    @Override
    public int derniereAction() {
        return 0;
    }

    @Override
    public String Affichage() {
        return null;
    }
}
