package ar.edu.unlp.info.oo1.a;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaTest {
	Llamada local;
	Llamada internacionalDiurna;
	Llamada internacionalNocturna;
	Llamada interurbana99km;
	Llamada interurbana499km;
	Llamada interurbana500km;
	@BeforeEach
	public void setUp () throws Exception {
		local = new Llamada(LocalDate.of(2023, 1, 2), LocalTime.of(8, 0), 25, "321");
		internacionalNocturna = new LlamadaInternacional(LocalDate.of(2023, 1, 1), LocalTime.of(8, 0), 25, "312", "Argelia", "Argentina");
		internacionalDiurna = new LlamadaInternacional(LocalDate.of(2023, 1, 1), LocalTime.of(8, 1), 25, "312", "Argelia", "Argentina");
		interurbana99km = new LlamadaInterurbana(LocalDate.of(2023, 1, 3), LocalTime.of(8, 0), 25, "321", 99);
		interurbana499km = new LlamadaInterurbana(LocalDate.of(2023, 1, 3), LocalTime.of(8, 0), 25, "321", 499);
		interurbana500km = new LlamadaInterurbana(LocalDate.of(2023, 1, 3), LocalTime.of(8, 0), 25, "321", 500);
	}
	@Test
	public void llamdaLocalTest() {
		assertEquals(25, local.getCosto());
	}
	@Test
	public void llamdaInternacionalNocturnaTest() {
		assertEquals(75, internacionalNocturna.getCosto());
	}
	@Test
	public void llamdaInternacionalDiurnaTest() {
		assertEquals(100, internacionalDiurna.getCosto());
	}
	@Test
	public void llamdaInterurbanaTest99km() {
		assertEquals(55, interurbana99km.getCosto());
	}
	@Test
	public void llamdaInterurbanaTest499km() {
		assertEquals(67.5, interurbana499km.getCosto());
	}
	@Test
	public void llamdaInterurbanaTest500km() {
		assertEquals(80, interurbana500km.getCosto());
	}
}
