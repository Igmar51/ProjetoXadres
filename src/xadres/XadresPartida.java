package xadres;

import jogotaboleiro.Tabuleiro;
import xadres.peca.Rei;
import xadres.peca.Torre;

public class XadresPartida {

	private Tabuleiro tabuleiro;
	
	public XadresPartida() {
		tabuleiro = new Tabuleiro(8, 8);
		initialSetup();
	}
	public XadresPeca[][] getPecas() {
		XadresPeca[][] mat = new XadresPeca[tabuleiro.getLinhas()][tabuleiro.getColunas()];
	  for (int i = 0 ; i < tabuleiro.getLinhas(); i++) {
		for (int j = 0  ; j < tabuleiro.getColunas(); j++){
			mat[i][j] = (XadresPeca)tabuleiro.pecas(i , j);
		}
	  }
   return	mat;
	}
	private void pecaNewPeca( char coluna, int linha, XadresPeca peca) {
		tabuleiro.lugarPeca(peca, new XadresPosicao(coluna, linha).toPosicao());
	}
	
	private void initialSetup() {
		pecaNewPeca('b' , 6 , new Torre(tabuleiro, Cor.Branco));
		pecaNewPeca('e' , 8 , new Rei(tabuleiro, Cor.Preto));
		pecaNewPeca('e' , 1 , new Rei(tabuleiro, Cor.Branco));
	}
}
