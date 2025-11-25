package xadres;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jogotaboleiro.Peca;
import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.peca.Rei;
import xadres.peca.Torre;

public class XadresPartida {

	private int turn;
	private Cor currentPlayer;
	private Tabuleiro tabuleiro;
	private boolean check;
	
	
	private List<Peca> pecasOnTheTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapiturada = new ArrayList<>();
	
	public XadresPartida() {
		tabuleiro = new Tabuleiro(8, 8);
		turn = 1;
		currentPlayer =Cor.WHITE;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	public Cor getCurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean getCheck() {
		return check;
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
	   if(testCheck(currentPlayer)) {
		   undoMove(source, target, capituraPeca);
		   throw new XadresException("Voce não pode colocar em check; ");
	   }
	   check = (testCheck(opponent(currentPlayer)))? true : false;
	   
	   nextTurn();
	   return (XadresPeca) capituraPeca;
		
	}
	
	private Peca makeMove(Posicao source , Posicao target) {
		Peca p = tabuleiro.removePeca(source);
		Peca capturadaPeca = tabuleiro.removePeca(target);
		tabuleiro.lugarPeca(p, target);
		
		if(capturadaPeca != null) {
			pecasOnTheTabuleiro.remove(capturadaPeca);
			pecasCapiturada.add(capturadaPeca);
		}
		
		return capturadaPeca;
		
	}
	
	private void undoMove(Posicao source, Posicao targert, Peca capitraPeca) {
		Peca p = tabuleiro.removePeca(targert);
		tabuleiro.lugarPeca(p, source);
		
		if(capitraPeca != null) {
			tabuleiro.lugarPeca(capitraPeca, targert);
			pecasCapiturada.remove(capitraPeca);
			pecasOnTheTabuleiro.add(capitraPeca);
		}
	
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
			currentPlayer = (currentPlayer == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
			
		}
		
	private Cor opponent(Cor cor) {
		return (cor == cor.WHITE)? cor.BLACK :cor.WHITE;
		
	}
	
	private XadresPeca Rei(Cor cor) {
		List<Peca> list = pecasOnTheTabuleiro.stream().filter(x -> ((XadresPeca)x).getCor()== cor).collect(Collectors.toList());	
	    for (Peca p : list) {
	    	if(p instanceof Rei) {
	    		return (XadresPeca)p;	    	
	    		}
	    }
	 throw new IllegalStateException("Não existe "+ cor +"Rei no tabuleiro");
	}
	
	private boolean testCheck(Cor cor) {
		Posicao reiPosicao = Rei(cor).getXadesPosicao().toPosicao();
		List<Peca>opponentPeca = pecasOnTheTabuleiro.stream().filter(x -> ((XadresPeca)x).getCor()== opponent(cor)).collect(Collectors.toList());		
       	for( Peca p : opponentPeca) {
       	boolean[][]mat	= p.possibleMoves();
       	if(mat[reiPosicao.getLinha()][reiPosicao.getColuna()]) {
       		
       	 return true;
       	}
	}
	return false;
}
	
	private void pecaNewPeca( char coluna, int linha, XadresPeca peca) {
		tabuleiro.lugarPeca(peca, new XadresPosicao(coluna, linha).toPosicao());
	    pecasOnTheTabuleiro.add(peca);
	}
	
	private void initialSetup() {
	//	pecaNewPeca('b', 6, new Torre(tabuleiro, Cor.Branco));
		pecaNewPeca('e', 8, new  Torre(tabuleiro, Cor.BLACK));
		pecaNewPeca('e', 1, new Torre(tabuleiro, Cor.WHITE));
		pecaNewPeca('c', 1, new Torre(tabuleiro, Cor.WHITE));
		pecaNewPeca('c', 2, new Torre(tabuleiro, Cor.WHITE));
		pecaNewPeca('d', 2, new Torre(tabuleiro, Cor.WHITE));
		pecaNewPeca('e', 2, new Torre(tabuleiro, Cor.WHITE));
	//	pecaNewPeca('e', 1, new Torre(tabuleiro, Cor.Branco));
		pecaNewPeca('d', 1, new Rei(tabuleiro, Cor.WHITE));

		pecaNewPeca('c', 7, new Torre(tabuleiro, Cor.BLACK));
		pecaNewPeca('c', 8, new Torre(tabuleiro, Cor.BLACK));
		pecaNewPeca('d', 7, new Torre(tabuleiro, Cor.BLACK));
		pecaNewPeca('e', 7, new Torre(tabuleiro, Cor.BLACK));
	//	pecaNewPeca('e', 8, new Torre(tabuleiro, Cor.Preto));
		pecaNewPeca('d', 8, new Rei(tabuleiro, Cor.BLACK));
	}
}
