package xadres;

import jogotaboleiro.Tabuleiro;

public class XadresPartida {

	private Tabuleiro tabuleiro;
	
	public XadresPartida() {
		tabuleiro = new Tabuleiro(8, 8);
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
}
