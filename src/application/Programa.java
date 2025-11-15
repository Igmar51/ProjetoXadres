package application;

import java.lang.annotation.Target;
import java.util.Scanner;

import jogotaboleiro.Posicao;
import jogotaboleiro.Tabuleiro;
import xadres.XadresPartida;
import xadres.XadresPeca;
import xadres.XadresPosicao;

public class Programa {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		XadresPartida partidaXadres = new XadresPartida();
		
		while (true) {
		UI.printTabuleiro(partidaXadres.getPecas());
		System.out.println();
		System.out.println("Source; ");
		XadresPosicao source = UI.readXadresPosicao(sc);
		
		System.out.println();
		System.out.println("Destino; ");
		XadresPosicao targer = UI.readXadresPosicao(sc);
		
		XadresPeca capituraPeca = partidaXadres.performXadresMove(source, targer);
	}
	}
}
