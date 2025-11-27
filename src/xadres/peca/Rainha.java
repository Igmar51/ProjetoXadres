package xadres.peca;

import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.Cor;
import xadres.XadresPeca;

public class Rainha extends XadresPeca{

	public Rainha(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}
	
	@Override
	public String toString() {

		return "Q";
	}
	

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		//Acima
	    p.setValues(posicao.getLinha() -1, posicao.getColuna());
	    while (getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)){
	    	mat[p.getLinha()][p.getColuna()] = true;
	    	p.setLinha(p.getLinha() - 1);
	    	
	    }
	    	if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
	    		mat[p.getLinha()][p.getColuna()]=true;
	    		
	    	}
	    	//Esquerda
	    	 p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
	 	    while (getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)){
	 	    	mat[p.getLinha()][p.getColuna()] = true;
	 	    	p.setColuna(p.getColuna() - 1);
	 	    	
	 	    }
	 	    	if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
	 	    		mat[p.getLinha()][p.getColuna()]=true;
	 	    		
	 	    	}
	 	    	//Direita
		    	 p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		 	    while (getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)){
		 	    	mat[p.getLinha()][p.getColuna()] = true;
		 	    	p.setColuna(p.getColuna() + 1);
		 	    	
		 	    }
		 	    	if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
		 	    		mat[p.getLinha()][p.getColuna()]=true;
		 	    		
		 	    	}
		 	    	//Abaixo
		 	    	p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		 		    while (getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)){
		 		    	mat[p.getLinha()][p.getColuna()] = true;
		 		    	p.setLinha(p.getLinha() + 1);
		 		    	
		 		    }
		 		    	if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
		 		    		mat[p.getLinha()][p.getColuna()]=true;
		 		    		
		 		    	}
	
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
	