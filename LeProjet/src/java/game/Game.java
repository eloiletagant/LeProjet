/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author 
 */
public class Game implements API{
private static final byte[][] matrix =null; // matrice des pions de 1-7 (largeur) 1-6, 1-7 (hauteur)
private int winner; // 0: null, 1 or 2 the winner
private int lastPlayer;
private byte[2] lastCell = [0,0]; // stock la derniere position (colonne, hauteur)
    
    public void Game() {
        
    }



@Override
public void initialisation() {
	this.winner = 0;
	this.lastPlayer = 0;
	this.matrix = new byte[7][6];
	this.matrix[7][6] = {{0}}; 
	this.lastCell = [0,0] ;
 
}

@Override
public boolean action(int numJoueur, int coup) {
   return placePawn(numJoueur, (byte)coup);
}

private boolean placePawn(int numJoueur, byte col) {
   bool done = false;
   for(int i = 0; i < 6 ;i++){
      if ( matrix[col-1][i] == 0 ){
         lastCell = [col-1][i];
         matrix[col-1][i] = (byte)numJoueur;
         done = true;
         
         break;
      }
   }
   return done;
}


@Override
public String status() {
   //si game fini return zero
	if (this.winner>0){
return String.valueOf(0)
}else{
		return String.valueOf(this.lastPlayer());
}
	

}

@Override
public int vainqueur() {
   return this.winner;
}

@Override
public int derniereAction() {
   return this.lastCell;
}

@Override
/**
*  Affiche la matrice
*/
public String Affichage() {
   for (int i = 0; i < this.matrix.length; i++) { 
for (int j = 0; j < this.matrix[i].length; j++) { 
System.out.print(this.matrix[i][j] + " "); 
} 
System.out.println();

}
   
}


