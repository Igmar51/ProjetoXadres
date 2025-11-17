package xadres;

import jogotaboleiro.Peca;
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

		
}
