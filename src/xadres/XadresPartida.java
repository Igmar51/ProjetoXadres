package xadres;

import jogotaboleiro.Peca;
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
	
	public XadresPeca performXadresMove(XadresPosicao sourcePosicao, XadresPosicao tarPosicao) {
	   Posicao source = sourcePosicao.toPosicao();
	   Posicao targer   = tarPosicao.toPosicao();
	   validateSourcePosicao(source);
	   Peca capituraPeca = makeMove(source, targer);
	   return (XadresPeca) capituraPeca;
		
	}
	
	private Peca makeMove(Posicao source , Posicao targer) {
		Peca p = tabuleiro.removePeca(source);
		Peca capturadaPeca = tabuleiro.removePeca(targer);
		tabuleiro.lugarPeca(p, targer);
		return capturadaPeca;
		
	}
	
	private void  validateSourcePosicao(Posicao posicao) {
		if(!tabuleiro.thereIsApeca(posicao)) {
			throw new XadresException("Não existe peça nesta posição; ");
		}
	}
	
	private void pecaNewPeca( char coluna, int linha, XadresPeca peca) {
		tabuleiro.lugarPeca(peca, new XadresPosicao(coluna, linha).toPosicao());
	}
	
	private void initialSetup() {
	//	pecaNewPeca('b', 6, new Torre(tabuleiro, Cor.Branco));
		pecaNewPeca('e', 8, new  Torre(tabuleiro, Cor.Preto));
		pecaNewPeca('e', 1, new Torre(tabuleiro, Cor.Branco));
		pecaNewPeca('c', 1, new Torre(tabuleiro, Cor.Branco));
		pecaNewPeca('c', 2, new Torre(tabuleiro, Cor.Branco));
		pecaNewPeca('d', 2, new Torre(tabuleiro, Cor.Branco));
		pecaNewPeca('e', 2, new Torre(tabuleiro, Cor.Branco));
	//	pecaNewPeca('e', 1, new Torre(tabuleiro, Cor.Branco));
		pecaNewPeca('d', 1, new Rei(tabuleiro, Cor.Branco));

		pecaNewPeca('c', 7, new Torre(tabuleiro, Cor.Preto));
		pecaNewPeca('c', 8, new Torre(tabuleiro, Cor.Preto));
		pecaNewPeca('d', 7, new Torre(tabuleiro, Cor.Preto));
		pecaNewPeca('e', 7, new Torre(tabuleiro, Cor.Preto));
	//	pecaNewPeca('e', 8, new Torre(tabuleiro, Cor.Preto));
		pecaNewPeca('d', 8, new Rei(tabuleiro, Cor.Preto));
	}
}
