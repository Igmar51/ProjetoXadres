package xadres.peca;

import jogotaboleiro.Tabuleiro;
import xadres.Cor;
import xadres.XadresPeca;

public class Torre extends XadresPeca{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}

	@Override
	public String toString() {
		return "T";
	}

}
