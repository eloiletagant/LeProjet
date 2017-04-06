/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Anatole
 */
public class Game implements API{

    private int amour;

    @Override
    public void initialisation() {

    }

    @Override
    public boolean action(int numJoueur, int coup) {
        return false;
    }

    @Override
    public boolean status() {
        return false;
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
