package xadres;

import jogotaboleiro.Posicao;
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
	private void initialSetup() {
		tabuleiro.lugarPeca(new Torre(tabuleiro, Cor.Branco), new Posicao(2 , 1));
		tabuleiro.lugarPeca(new Rei(tabuleiro, Cor.Preto), new Posicao(0 , 4));
		tabuleiro.lugarPeca(new Rei(tabuleiro, Cor.Branco), new Posicao(7, 4));
	}
}
