package xadres.peca;

import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.Cor;
import xadres.XadresPeca;

public class Peao extends XadresPeca{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][]mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		 Posicao p = new Posicao(0, 0);
		 
		 
			 
		 
		 if(getCor() == Cor.WHITE) {
			 p.setValues(posicao.getLinha() - 1, posicao.getColuna());
			 if(getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)) {
				 
				 mat[p.getLinha()][p.getColuna()]= true;
			 }
			 
			 p.setValues(posicao.getLinha() - 2, posicao.getColuna());
			 Posicao p1 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			 if(getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p) && getTabuleiro().posicaoExist(p1) && !getTabuleiro().thereIsApeca(p1)  && getMoveCount() == 0 ) {
			 mat[p.getLinha()][p.getColuna()]= true; 
			 
			 
		        }
			 
			 p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
			 if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
			 mat[p.getLinha()][p.getColuna()]= true;
			 }
			 p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
			 if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
			 mat[p.getLinha()][p.getColuna()]= true;
			 }
		 }
			 else{
				 p.setValues(posicao.getLinha() + 1, posicao.getColuna());
				 if(getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p)) {
					 
					 mat[p.getLinha()][p.getColuna()]= true;
				 }
				 
				 p.setValues(posicao.getLinha() + 2, posicao.getColuna());
				 Posicao p1 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
				 if(getTabuleiro().posicaoExist(p) && !getTabuleiro().thereIsApeca(p) && getTabuleiro().posicaoExist(p1) && !getTabuleiro().thereIsApeca(p1)  && getMoveCount() == 0 ) {
				 mat[p.getLinha()][p.getColuna()]= true; 
				 
				 
			        }
				 
				 p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
				 if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
				 mat[p.getLinha()][p.getColuna()]= true;
				 }
				 p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
				 if(getTabuleiro().posicaoExist(p) && isThereOpponentPeca(p)) {
				 mat[p.getLinha()][p.getColuna()]= true;
				 }
	}
	
		 return mat;
	}
}

