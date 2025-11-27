package xadres.peca;

import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.Cor;
import xadres.XadresPeca;

public class Cavalo  extends XadresPeca{

	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}

	@Override
	public String toString() {
		return "C";
	}

	private boolean canMove(Posicao posicao) {
		XadresPeca p = (XadresPeca) getTabuleiro().peca(posicao);
		return p == null || p.getCor() != getCor();
		
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][]mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		 Posicao p = new Posicao(0, 0);
		
		 //Para cima
		 p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 2);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() - 2, posicao.getColuna() - 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 2);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() + 2, posicao.getColuna() + 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() + 2, posicao.getColuna() - 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 2);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() - 2, posicao.getColuna() + 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 2);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 return mat;
	}
	
}

