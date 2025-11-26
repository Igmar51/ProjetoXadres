package xadres;

import jogotaboleiro.Peca;
import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;

public abstract class XadresPeca extends Peca{

	private Cor cor;
     private int moveCount;
     
	public XadresPeca(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void increaseMoveCount() {
		moveCount ++;
	}
	public void decreaseMoveCount() {
		moveCount --;
	}
	
	public XadresPosicao getXadesPosicao() {
		
		return XadresPosicao.fromPosicao(posicao);
		
		
	}
	protected  boolean isThereOpponentPeca(Posicao posicao) {
		XadresPeca p = (XadresPeca) getTabuleiro().peca(posicao);
		
		return p != null && p.getCor() != cor;
}

		
}
