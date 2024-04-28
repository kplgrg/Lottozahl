package lottoZahlApp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import lottoZahlApp.model.Sechs49;

public class Sechs49Test {
	static Sechs49 ziehung = new Sechs49();
	static ArrayList<Integer> lottoZahl;
	
	@BeforeEach
	public void genLottoZahl() {
		lottoZahl = ziehung.ZahlGenerieren();
	}
	
	@RepeatedTest(100)
	@DisplayName("Testfall für die Generierung von 6 Zahlen")
	public void AnzLottoZahlTest() {

		int arraySize = lottoZahl.size();

		assertEquals(6, arraySize);
	}

	@RepeatedTest(10)
	@DisplayName("Testfall für die Generierung von eindeutige Zahlen")
	public void TestDuplicacy() {
		HashSet<Integer> uniqueNumbers = new HashSet<>(lottoZahl);
		boolean hasDuplicate  = true;
		hasDuplicate = lottoZahl.size() != uniqueNumbers.size();
		assertFalse(hasDuplicate);

	}

	@RepeatedTest(10)
	@DisplayName("Testfall für Zufälligkeit")
	public void DuplicacyTest() {
		boolean repeatedArrayList = false;
		
		int count = 100000;
		for (int i = 0 ; i < count ; i++ ) {
		ArrayList<Integer> lottoZahlen2 = ziehung.ZahlGenerieren();
		repeatedArrayList = lottoZahl.equals(lottoZahlen2);

	}
		assertFalse(repeatedArrayList);
	}
}
