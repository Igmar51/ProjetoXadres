package xadres;

import jogotaboleiro.Peca;
import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;

public abstract class XadresPeca extends Peca{

	private Cor cor;

	public XadresPeca(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	protected  boolean isThereOpponentPeca(Posicao posicao) {
		XadresPeca p = (XadresPeca) getTabuleiro().peca(posicao);
		
		return p != null && p.getCor() != cor;
}
}
