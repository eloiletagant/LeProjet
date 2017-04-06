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
		this.matrix = new byte[7][6];
		this.lastCell = new byte[2];
	}

	public boolean action(int numJoueur, int coup) {
		return placePawn(numJoueur, (byte) coup);
	}

	private boolean placePawn(int numJoueur, byte col) {
		boolean done = false;
		for (byte i = 5; i > 0; i++) {
			if (matrix[i][col - 1] == 0) {
				this.lastCell[0] = i;
				this.lastCell[1] = (byte) (col - 1);
				this.matrix[i][col - 1] = (byte) numJoueur;
				done = true;

				break;
			}
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

	public byte[] derniereAction() {
		return this.lastCell;
	}

	/**
	 * Affiche la matrice
	 */
	public void Affichage() {
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				System.out.print(this.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public String toHTML(){
	    StringBuilder sb = new StringBuilder();
	    sb.append("<table>\n");
	    for(int row = 0; row < matrix.length; row++){
	        sb.append("\t<tr>\n");
	        for(int col = 0; col < matrix[0].length; col++){
	            sb.append("\t\t<td>" + matrix[row][col] + "</td>\n");
	        }
	        sb.append("\t</tr>\n");
	    }
	    sb.append("</table>");
	    return sb.toString();
	}

	public static void main(String[] args) {
		Game p4 = new Game();
		System.out.println(p4.placePawn(0, (byte) 3));
		p4.Affichage();
		System.out.println(p4.toHTML());
	}
}
