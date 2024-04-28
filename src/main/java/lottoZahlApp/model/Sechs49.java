package lottoZahlApp.model;



import java.util.ArrayList;
import java.util.Random;


public class Sechs49 extends LottoZahl {

	private ArrayList<Integer> lottoZahl;
	private Random random;
	private int zahl;

	
//	Rückgabe einer Arrayliste mit generierten Zufallszahlen für Lotto 6 aus 49
	@Override
	public  ArrayList<Integer> ZahlGenerieren() {

		lottoZahl = new ArrayList<>();
		random = new Random();

		for( int i = 0; i < 6 ; i++) {
			zahl = random.nextInt(49) + 1;
			lottoZahl.add(zahl);
			for(int j = 0 ; j < i ; j++) {
				if (lottoZahl.get(i) == lottoZahl.get(j)) {
					lottoZahl.remove(j);
					j = 6;
					i--;
				}
			}
		}

		return lottoZahl;
	}
}
