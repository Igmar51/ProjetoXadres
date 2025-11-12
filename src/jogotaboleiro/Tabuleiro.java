package jogotaboleiro;

public class Tabuleiro {

	
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Tabela tem que ter mais de 1 linha e mais de 1 coluna; ");			
		}				
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];		
	}
	public int getLinhas() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}
	public Peca pecas(int linhas , int colunas) {
		if(! posicaoExist(linhas , colunas)) {
			throw new TabuleiroException("Posição não existe");
		}
		
		return  pecas[linhas][colunas];
	}
	public Peca peca(Posicao posicao) {
		if(! posicaoExist(posicao)) {
			throw new TabuleiroException("Posição não existe");
		
	}
		 return pecas(posicao.getLinha(), posicao.getColuna());
	}
	public void lugarPeca(Peca peca, Posicao posicao) {
		if(thereIsApeca(posicao)) {
			throw new TabuleiroException("Ja existe uma peça nesta posição"+posicao);
		}
	
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	private boolean posicaoExist(int linha , int coluna) {
		return linha >= 0 && linha < linhas && coluna >=0 && coluna < colunas;
	}
	public boolean posicaoExist(Posicao posicao) {
		return posicaoExist(posicao.getLinha(), posicao.getColuna());
		
	}
	public boolean thereIsApeca(Posicao posicao) {
		return peca(posicao) != null;
	}
}
