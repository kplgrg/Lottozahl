package lottoZahlApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import lottoZahlApp.model.Super6;

public class Super6Test {
	private Super6 ziehung = new Super6();
	static ArrayList<Integer> lottoZahl;
	
	@BeforeEach
	public void genLottoZahl() {
		lottoZahl = ziehung.ZahlGenerieren();
	}
	
	@RepeatedTest(10)
	@DisplayName("Testfall für Generierung der sechs Zahl")
	public void AnzLottoZahlTest() {
		ArrayList<Integer> lottoZahl = ziehung.ZahlGenerieren();
		int arraySize = lottoZahl.size();
		assertEquals(6, arraySize);
	}

	@RepeatedTest(10)
	@DisplayName("Testfall für Generierung der einstelligen Zahl")
	public void zahlTest() {
		ArrayList<Integer> lottoZahl = ziehung.ZahlGenerieren();
		boolean containsSingleDigit = false;
		for (Integer zahl: lottoZahl) {
			containsSingleDigit = zahl >= 0 || zahl <= 9;
		}
		assertEquals(true, containsSingleDigit);
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
