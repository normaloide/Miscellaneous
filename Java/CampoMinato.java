/**
* This class will implement a full visible Minesweeper,
* useful if it has to be implemented in some GUI
*/

import java.util.*;

public class CampoMinato {
	public static void main(String[] args) {
		int dim = Integer.parseInt(args[0]);
		String[][] campo = new String[dim+2][dim+2];
		Random rand = new Random();
		for(int i = 1; i <= dim; i++) {
			for(int j = 1; j <= dim; j++) {
				int value = rand.nextInt(6);
				if(value == 5) {
					campo[i][j] = "*";
				}

				else {
					campo[i][j] = "0";
				}
			}
		}

		for(int i = 0; i < dim+2; i++) {
			for(int j = 0; j < dim+2; j++) {
				if(campo[i][j] == null) {
					campo[i][j] = "0";
				}
			}
		}

		for(int i = 1; i <= dim; i++) {
			for(int j = 1; j <= dim; j++) {
				if(campo[i][j] == "*") {
					if(campo[i+1][j-1] != "*") {
						campo[i+1][j-1] = Integer.toString(Integer.parseInt(campo[i+1][j-1]) + 1);
					}

					if(campo[i+1][j] != "*") {
						campo[i+1][j] = Integer.toString(Integer.parseInt(campo[i+1][j]) + 1);
					}

					if(campo[i+1][j+1] != "*") {
						campo[i+1][j+1] = Integer.toString(Integer.parseInt(campo[i+1][j+1]) + 1);
					}

					if(campo[i][j-1] != "*") {	
						campo[i][j-1] = Integer.toString(Integer.parseInt(campo[i][j-1]) + 1);
					}

					if(campo[i][j+1] != "*") {
						campo[i][j+1] = Integer.toString(Integer.parseInt(campo[i][j+1]) + 1);
					}

					if(campo[i-1][j-1] != "*") {
						campo[i-1][j-1] = Integer.toString(Integer.parseInt(campo[i-1][j-1]) + 1);
					}
					if(campo[i-1][j] != "*") {
						campo[i-1][j] = Integer.toString(Integer.parseInt(campo[i-1][j]) + 1);
					}
					if(campo[i-1][j+1] != "*") {
						campo[i-1][j+1] = Integer.toString(Integer.parseInt(campo[i-1][j+1]) + 1);
					}
				}
			}
		}

		for(int i = 1; i <= dim; i++) {
			for(int j = 1; j <= dim; j++) {
				System.out.print(campo[i][j]);
			}

			System.out.println("");
		}
	}
}
