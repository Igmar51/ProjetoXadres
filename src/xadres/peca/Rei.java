package xadres.peca;

import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.Cor;
import xadres.XadresPeca;

public class Rei  extends XadresPeca{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}

	@Override
	public String toString() {
		return "R";
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
		 p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() , posicao.getColuna() - 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
		 if (getTabuleiro().posicaoExist(p) && canMove(p)){
		 mat[p.getLinha()][p.getColuna()] = true;
		
		 }
		 return mat;
	}
	
}
