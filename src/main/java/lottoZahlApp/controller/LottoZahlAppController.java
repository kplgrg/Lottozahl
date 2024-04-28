package lottoZahlApp.controller;

import java.util.ArrayList;

import lottoZahlApp.model.LottoZahl;
import lottoZahlApp.view.LottoZahlView;


public class LottoZahlAppController {
	private static  LottoZahlView view;
	private static LottoZahl model;
	
	
//	Erstellt eine Arrayliste für die jeweilige Klasse und liefert sie an die Klasse View
	public static void generateLottoZahl(LottoZahl ziehung) {
		model = ziehung;
		ArrayList<Integer> zahl = model.ZahlGenerieren();
		view.ergebnisseAnzeigen(zahl, model);

	}


	public static void main(String[] args) {

		view = new LottoZahlView();
	   }
}
