package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadres.XadresException;
import xadres.XadresPartida;
import xadres.XadresPeca;
import xadres.XadresPosicao;

public class Programa {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		XadresPartida partidaXadres = new XadresPartida();
		List<XadresPeca> capiturada = new ArrayList<>();		
		
		while (!partidaXadres.getCheckMate()) {
		try {	
		UI.clearScreen();	
		UI.printMach(partidaXadres, capiturada);
		System.out.println();
		System.out.print("Source; ");
		XadresPosicao source = UI.readXadresPosicao(sc);
		
		boolean[][] possibleMoves = partidaXadres.possibleMoves(source);
		UI.clearScreen();
		UI.printTabuleiro(partidaXadres.getPecas() , possibleMoves);
		
		System.out.println();
		System.out.print("Destino; ");
		XadresPosicao target = UI.readXadresPosicao(sc);
		
		XadresPeca capituraPeca = partidaXadres.performXadresMove(source, target);
	     if(capiturada != null) {
	    	 capiturada.add(capituraPeca);
	     }
		
		}
		catch (XadresException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
	}
		UI.clearScreen();
		UI.printMach(partidaXadres, capiturada);
	}
}
