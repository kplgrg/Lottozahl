package lottoZahlApp.model;

import java.util.ArrayList;
import java.util.Random;

public class Super6 extends LottoZahl {

	private ArrayList<Integer> lottoZahl;
	private Random random;
	private int zahl;

	
//	Rückgabe einer Arrayliste mit generierten Zufallszahlen für Lotto Super6
	@Override
	public ArrayList<Integer> ZahlGenerieren() {
		lottoZahl = new ArrayList<>();
		random = new Random();
		lottoZahl.clear();

		for(int i = 0 ; i < 6 ; i++) {
			zahl = random.nextInt(9);
			lottoZahl.add(zahl);

		}
		return lottoZahl;

	}



}
