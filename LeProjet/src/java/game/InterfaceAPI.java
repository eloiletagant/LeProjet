/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Mathias
 */
public class InterfaceAPI {
    
    private Object game;
    
    /**
     * Construction
     */
    public InterfaceAPI(Object game) {
        this.game = game;
        if (game instanceof API){
            ((API) game).initialisation();
        }
    }
    
    public void routine(int coup){
        
        if (!(((API) game).status()).equals("0")){
            
            if ((((API) game).status()).equals("1")){
                ((API) game).action(2,coup);
                ((API) game).Affichage();
            }
            else if ((((API) game).status()).equals("2")){
                ((API) game).action(1,coup);
                ((API) game).Affichage();
            }   
        } 
    }
    
    
    }  
