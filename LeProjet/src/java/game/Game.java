/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

public class Game {

	private byte[][] matrix; // matrice des pions de 1-7 (largeur) 1-6,
								// (hauteur)
	private int winner; // 0: null, 1 or 2 the winner
	private int lastPlayer;
	private byte[] lastCell; // stock la derniere position (colonne, hauteur)

	public Game() {
		this.winner = 0;
		this.lastPlayer = 0;
		this.matrix = new byte[6][7];
		this.lastCell = new byte[2];
	}
        
        public void initialisation(){
            	this.winner = 0;
		this.lastPlayer = 0;
		this.matrix = new byte[6][7];
		this.lastCell = new byte[2];
        }

	public boolean action(int numJoueur, int coup) {
		boolean fait =  placePawn(numJoueur, (byte) coup);
                if (fait){
                    checkWin();  
                }
                return fait;
	}

	private boolean placePawn(int numJoueur, byte col) {
   		boolean done = false;
   		for(byte i = 5; i >=0 ; i--){
   	   	if ( matrix[i][col-1] == 0 ){
   	      	this.lastCell[0] = i;
   	      	this.lastCell[1] = (byte) (col);
   	      	this.matrix[i][col-1] = (byte) numJoueur;
   	      	done = true;  
   	      	break;
   	   	}
   	   	else
		       this.lastCell[0] = (byte) (i-1);
   		   	   this.lastCell[1] = (byte) (col-1);
   			   this.matrix[i-1][col-1] = (byte) numJoueur;
   			   done = true;
   	   	break;
   		}
   		return done;
   	 }


	public String status() {
		// si game fini return zero
		if (this.winner > 0) {
			return String.valueOf(0);
		} else {
			return String.valueOf(this.lastPlayer);
		}
	}

	public int vainqueur() {
		return this.winner;
	}

	public int derniereAction() {
		int last = (int)  lastCell[1];
		return last;
	}

	/**
	 * Affiche la matrice
	 */
	public void AffichageDebug() {
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				System.out.print(this.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Fonction qui renvoi une table HTML qui correspnd a l"tat actul du damier
	 * @return
	 */
	public String Affichage(){
	    StringBuilder sb = new StringBuilder();
	    sb.append("<table>\n");
	    for(int row = 0; row < matrix.length; row++){
	        sb.append("\t<tr>\n");
	        for(int col = 0; col < matrix[0].length; col++){
	        	 byte number = matrix[row][col];
	        	 int nombre = number;
	        	 
	        	 switch (nombre) {
				case 0: //vide
					sb.append("\t\t<td class=\"j0\"></td>\n");
					break;
				case 1://j1 pion
					sb.append("\t\t<td class=\"j1\">O </td>\n");
					break;
				case 2://pion j2
					sb.append("\t\t<td class=\"j2\">O </td>\n");
					break;

				default:
					break;
				}
	            
	        			
	        			
	        }
	        sb.append("\t</tr>\n");
	    }
	    sb.append("</table>");
	    return sb.toString();
	}
        
        public void checkWin(){

            for(int i = 0;i<6 ;i++){
                for (int j = 0; j<7 ;j++){
                    System.out.print(matrix[j][5-i]+" | ");
                }
                System.out.println("");
            }

            int posx = lastCell[0];
            int posy = lastCell[1];

            System.out.println("lastCell : ["+posx+","+posy+"] = "+matrix[posx][posy]);

            //vertical (|)
            if(posy >= 3){
                System.out.println("Check vertical");
                for(int i = 0; i < 4;i++){
                    System.out.println("["+posx+","+(posy-i)+"] = "+matrix[posx][posy-i]);
                    if(matrix[posx][posy] == matrix[posx][posy-i] ){
                        if(i == 3)
                            this.winner = matrix[posx][posy];
                    }else {
                        System.out.println("Pas bon => STOP");
                        break;
                    }
                }
            }

            //Horizontonal (-)
            System.out.println("");
            System.out.println("Horizontal");
            int cursor = posx-3<0?0:posx-3;
            int end = posx+3>6?6:posx+3;
            int compteur = 0;
            int i = 0;
            while (true){
                System.out.println("["+(cursor+i)+","+posy+"] = "+ matrix[cursor+i][posy]);
                if(matrix[posx][posy] == matrix[cursor+i][posy] ){
                    compteur++;
                }else{
                    compteur = 0;
                }
                if(compteur >=4){
                    this.winner = matrix[posx][posy];
                }
                if(cursor+i >=6){
                    break;
                }
                i++;
            }

            System.out.println("");
            System.out.println("Slash (/)");
            //slash (/)
            int cursorx = posx;
            int cursory = posy;
            while (true){
                if( cursorx <=0 || cursory <=0){
                    break;
                }
                cursorx --;
                cursory --;
            }

            int endx = posx;
            int endy = posy;
            while (true){
                if( endx >=6 || endy >=5){
                    break;
                }
                endx ++;
                endy ++;
            }


            compteur = 0;
            i=0;
            while (true){
                System.out.println("["+(cursorx+i)+","+(cursory+i)+"] = "+ matrix[cursorx+i][cursory+i]);
                if(matrix[posx][posy] == matrix[cursorx+i][cursory+i] ){
                    compteur++;
                }else{
                    compteur = 0;
                }
                if(compteur >=4){
                    this.winner = matrix[posx][posy];
                    break;
                }
                if(cursorx+i >= 6 || cursory+i >= 5){
                    break;
                }
                i++;
            }

            //anti-slash (\)
            System.out.println("");
            System.out.println("Anti-slash (\\)");

            cursorx = posx;
            cursory = posy;
            while (true){
                if( cursorx <=0 || cursory >=5){
                    break;
                }
                cursorx --;
                cursory ++;
            }

            endx = posx;
            endy = posy;
            while (true){
                if( endx >=6 || endy <=0){
                    break;
                }
                endx ++;
                endy --;
            }

            compteur = 0;
            i = 0;
            while (true){
                System.out.print("["+(cursorx+i)+","+(cursory-i)+"] = ");
                System.out.println(matrix[cursorx+i][cursory-i]);
                if(matrix[posx][posy] == matrix[cursorx+i][cursory-i] ){
                    compteur++;
                }else{
                    compteur = 0;
                }
                if(compteur >=4){
                    this.winner = matrix[posx][posy];
                }
                if(cursorx+i >= 6|| cursory-i <= 0){
                    break;
                }
                i++;
            }
        }

	public static void main(String[] args) {
		Game p4 = new Game();
		p4.placePawn(1, (byte) 1);
		p4.placePawn(2, (byte) 1);
		p4.placePawn(1, (byte) 2);
		p4.placePawn(2, (byte) 2);
		p4.placePawn(1, (byte) 3);
		p4.placePawn(2, (byte) 3);
		p4.placePawn(1, (byte) 4);
		System.out.println(p4.placePawn(2, (byte) 3));


	
		p4.Affichage();
		System.out.println(p4.winner);
		p4.AffichageDebug();
	}
}
