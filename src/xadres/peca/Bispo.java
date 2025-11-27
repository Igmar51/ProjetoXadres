package xadres.peca;

import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.Cor;
import xadres.XadresPeca;

public class Bispo extends XadresPeca{

	public  Bispo (Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}
	
	@Override
	public String toString() {

		return "B";
	}
	

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		//Acima
	    p.setValues(posicao.getLinha() -1, posicao.getColuna() - 1);
	    while (getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)){
	    	mat[p.getLinha()][p.getColuna()] = true;
	    	p.setValues(p.getLinha() - 1, p.getColuna() - 1);
	    	
	    }
	    	if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
	    		mat[p.getLinha()][p.getColuna()]=true;
	    		
	    	}
	    	
	    	 p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
	 	    while (getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)){
	 	    	mat[p.getLinha()][p.getColuna()] = true;
	 	    	p.setValues(p.getLinha() - 1, p.getColuna() + 1);
	 	    	
	 	    }
	 	    	if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
	 	    		mat[p.getLinha()][p.getColuna()]=true;
	 	    		
	 	    	}
	 	    	
		    	 p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
		 	    while (getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)){
		 	    	mat[p.getLinha()][p.getColuna()] = true;
		 	    	p.setValues(p.getLinha() + 1, p.getColuna() + 1);
		 	    	
		 	    }
		 	    	if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
		 	    		mat[p.getLinha()][p.getColuna()]=true;
		 	    		
		 	    	}
		 	    	//Abaixo
		 	    	p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
		 		    while (getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)){
		 		    	mat[p.getLinha()][p.getColuna()] = true;
		 		    	p.setValues(p.getLinha() + 1, p.getColuna() - 1);
		 		    	
		 		    }
		 		    	if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
		 		    		mat[p.getLinha()][p.getColuna()]=true;
		 		    		
		 		    	}
	
		
		 		    	return mat;
	}
}
	