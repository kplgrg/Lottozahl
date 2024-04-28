package lottoZahlApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import lottoZahlApp.model.SuperZahl;


public class SuperZahlTest {
	private SuperZahl ziehung = new SuperZahl();
	static ArrayList<Integer> lottoZahl;

	@BeforeEach
	public void genLottoZahl() {
		lottoZahl = ziehung.ZahlGenerieren();
	}
	
	@RepeatedTest(10)
	@DisplayName("Testfall für Generierung der ein Zahl")
	public void AnzLottoZahlTest() {

		int arraySize = lottoZahl.size();
		assertEquals(1, arraySize);
	}
	
	@RepeatedTest(10)
	@DisplayName("Testfall für Generierung der einstelligen Zahl")
	public void zahlTest() {
		
		boolean containsSingleDigit = false;
		for (Integer zahl: lottoZahl) {
			containsSingleDigit = zahl >= 0 || zahl <= 9;
		}
		assertEquals(true, containsSingleDigit);
	}
}
