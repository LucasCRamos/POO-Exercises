package ex2;

public class JogoDaVelha {
	
	private String [][] tab = new String[3][3];
	
	static private JogoDaVelha instance = null;
	
	private JogoDaVelha() {} //construtor privado
		
	private static JogoDaVelha getInstance () {
			
		if (instance == null) { //instancio tardiamente
			
			instance = new JogoDaVelha();
			
		}
		
		return instance;
			
	}
	
	private static void preencheTabuleiro (JogoDaVelha board) {
		
		board.tab[0][0] = "O";
		JogoDaVelha.imprimeTabuleiro(board);	
		board.tab[0][1] = "X";
		JogoDaVelha.imprimeTabuleiro(board);	
		board.tab[1][2] = "O";
		JogoDaVelha.imprimeTabuleiro(board);	
		board.tab[0][2] = "X";
		JogoDaVelha.imprimeTabuleiro(board);	
		board.tab[2][1] = "O";
		JogoDaVelha.imprimeTabuleiro(board);	
		board.tab[2][0] = "X";
		JogoDaVelha.imprimeTabuleiro(board);	
		board.tab[2][2] = "O";
		JogoDaVelha.imprimeTabuleiro(board);	
		board.tab[1][0] = "X";
		JogoDaVelha.imprimeTabuleiro(board);	
		board.tab[1][1] = "O";
		System.out.print("Estado Final do Tabuleiro:\n\n");
		JogoDaVelha.imprimeTabuleiro(board);
		System.out.print("'O' wins!");
	}
	
	static void imprimeTabuleiro (JogoDaVelha board) {
		
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++) {
				
				if(board.tab[i][j] != null) {
					
					System.out.print(board.tab[i][j] + "|");
					
				}
				
				else {
					
					System.out.print(" " + "|");
				}
				
				if(j == 2) System.out.print("\n");
			}
		}
		
		System.out.print("\n");
	}
		
	public static void main(String args[]) {
		
		JogoDaVelha tabuleiro = JogoDaVelha.getInstance();
		
		JogoDaVelha.preencheTabuleiro(tabuleiro);
	
	}
		
}
