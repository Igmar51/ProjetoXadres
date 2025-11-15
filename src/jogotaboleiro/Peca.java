package jogotaboleiro;

import xadres.Cor;

public class Peca {

	protected Posicao posicao;
    private Tabuleiro tabuleiro;
    
    
	public Peca(Tabuleiro tabuleiro) {
	
		this.tabuleiro = tabuleiro;
	}


	protected  Tabuleiro getTabuleiro() {
		return tabuleiro;
	}


	public static Cor getColor() {
		
		return null;
	}
    
    
    
}
