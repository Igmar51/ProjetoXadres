package jogotaboleiro;

import xadres.Cor;

public abstract class Peca {

	protected Posicao posicao;
    private Tabuleiro tabuleiro;
    
    
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}


	protected  Tabuleiro getTabuleiro() {
		return tabuleiro;
	}


	public static Cor getColor() {
		
		return null;
	}
    
    
    public abstract boolean[][] possibleMoves();
    	
    	public boolean possibleMoves(Posicao posicao) {
    		return possibleMoves()[posicao.getLinha()][posicao.getColuna()];
			
		}
    	
    	public boolean isThereAnyPossibleMoves() {
    	boolean[][]mat = possibleMoves();
    	for(int i = 0 ; i < mat.length ; i++) {
    		for(int j = 0 ; j < mat.length; j++) {
    			if(mat[i][j]) {
    				return true;
    			}
    			
    		}
    	}
    	return false;
    		
    		
    	}
    }

