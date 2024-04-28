package lottoZahlApp.model;
import java.util.ArrayList;
import java.util.Random;


public class SuperZahl extends LottoZahl {

	private ArrayList<Integer> lottoZahl;
	private Random random;
	private int zahl;

	
//	Rückgabe einer Arrayliste mit generierten Zufallszahl für Superzahl
	@Override
	public ArrayList<Integer> ZahlGenerieren() {
	lottoZahl = new ArrayList<>();
	random = new Random();
	zahl = random.nextInt(9);

	lottoZahl.add(zahl);

	return lottoZahl;
	}
}
