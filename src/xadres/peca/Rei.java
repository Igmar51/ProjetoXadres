package xadres.peca;

import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.Cor;
import xadres.XadresPartida;
import xadres.XadresPeca;

public class Rei  extends XadresPeca{

	private XadresPartida xadresPartida;
	
	public Rei(Tabuleiro tabuleiro, Cor cor , XadresPartida xadresPartida) {
		super(tabuleiro, cor);
		this.xadresPartida = xadresPartida;
	}

	@Override
	public String toString() {
		return "R";
	}

	private boolean canMove(Posicao posicao) {
		XadresPeca p = (XadresPeca) getTabuleiro().peca(posicao);
		return p == null || p.getCor() != getCor();
		
	}
	
	private boolean testRookCastling(Posicao posicao) {
		XadresPeca p =(XadresPeca)getTabuleiro().peca(posicao);
		return p != null && p instanceof Torre && p.getCor()== getCor() && p.getMoveCount() == 0;
		
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
		 //especial movimento
		 if(getMoveCount() == 0 && !xadresPartida.getCheckMate()) {
			 Posicao posTr1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3 );
			 
			 if(testRookCastling(posTr1)) {
				 Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1 );
				 Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2 );
				 if(getTabuleiro().peca(p1)== null && getTabuleiro().peca(p2) == null) {
					 mat[posicao.getLinha()][posicao.getColuna() + 2 ] = true;
				 }
			 }
				 Posicao posTr2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4 );
				 
				 if(testRookCastling(posTr1)) {
					 Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1 );
					 Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2 );
					 Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3 );
					 if(getTabuleiro().peca(p1)== null && getTabuleiro().peca(p2) == null && getTabuleiro().peca(p3) == null) {
						 mat[posicao.getLinha()][posicao.getColuna() - 2] = true;
					 }
			 }
		 }
		 
		 return mat;
	}
	
}
