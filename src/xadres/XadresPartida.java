package xadres;

import jogotaboleiro.Peca;
import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.peca.Rei;
import xadres.peca.Torre;

public class XadresPartida {

	private int turn;
	private Cor currentPlayer;
	private Tabuleiro tabuleiro;
	
	public XadresPartida() {
		tabuleiro = new Tabuleiro(8, 8);
		turn = 1;
		currentPlayer =Cor.Branco;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	public Cor getCurrentPlayer() {
		return currentPlayer;
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
	 
	public boolean[][]  possibleMoves(XadresPosicao sourcePosicao) {
		Posicao posicao = sourcePosicao.toPosicao();
		validateSourcePosicao(posicao);
		return tabuleiro.peca(posicao).possibleMoves();
	}
	
	public XadresPeca performXadresMove(XadresPosicao sourcePosicao, XadresPosicao tarPosicao) {
	   Posicao source = sourcePosicao.toPosicao();
	   Posicao target   = tarPosicao.toPosicao();
	   validateSourcePosicao(source);
	   validateTargetPosicao(source, target);
	   Peca capituraPeca = makeMove(source, target);
	   nextTurn();
	   return (XadresPeca) capituraPeca;
		
	}
	
	private Peca makeMove(Posicao source , Posicao target) {
		Peca p = tabuleiro.removePeca(source);
		Peca capturadaPeca = tabuleiro.removePeca(target);
		tabuleiro.lugarPeca(p, target);
		return capturadaPeca;
		
	}
	
	private void  validateSourcePosicao(Posicao posicao) {
		if(!tabuleiro.thereIsApeca(posicao)) {
			throw new XadresException("Não existe peça nesta posição; ");
		}
		if(currentPlayer != ((XadresPeca)tabuleiro.peca(posicao)).getCor()) {
			throw new XadresException("Esta peça não e sua ; ");
		}
		if(!tabuleiro.peca(posicao).isThereAnyPossibleMoves()) {
			throw new XadresException("Nõa existe movimentos pociveis para esta peça");
		}
	}
	
	public void validateTargetPosicao(Posicao source, Posicao target) {
		if(!tabuleiro.peca(source).possibleMoves(target)) {
			throw new XadresException("A peca não pode ser removida para o local de destino");
		}
				
	}
		private void nextTurn() {
			turn ++;
			currentPlayer = (currentPlayer == Cor.Branco) ? Cor.Preto : Cor.Branco;
			
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
