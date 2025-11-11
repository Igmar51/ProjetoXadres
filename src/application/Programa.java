package application;

import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.XadresPartida;

public class Programa {

	public static void main(String[] args) {
	
		XadresPartida partidaXadres = new XadresPartida();
		UI.printTabuleiro(partidaXadres.getPecas());
		
		
	}

}
