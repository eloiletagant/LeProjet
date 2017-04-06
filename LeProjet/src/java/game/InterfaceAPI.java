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
    
    public void routine(){
        
        if ((((API) game).status())?=("0")){
            ((API) game).action(1,0);                         
        }
        
    }
    
    
}   
