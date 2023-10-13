package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DateLapseTest {
	private DateLapse lapso;
	private DateLapse lapsoEnElBorde1;
	private DateLapse lapsoEnElBorde2;
	private DateLapse lapsoAntes;
	private DateLapse lapsoDespues;

	@BeforeEach
	void setUp() throws Exception {
		this.lapso = new DateLapse(LocalDate.of(2023, 10, 15), LocalDate.of(2023, 10, 13));
		this.lapsoEnElBorde1 = new DateLapse(LocalDate.of(2023, 10, 13), LocalDate.of(2023, 10, 12));
		this.lapsoEnElBorde2 = new DateLapse(LocalDate.of(2023, 10, 16), LocalDate.of(2023, 10, 15));
		this.lapsoAntes = new DateLapse(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 3));
		this.lapsoDespues = new DateLapse(LocalDate.of(2023, 10, 17), LocalDate.of(2023, 10, 16));
	}

	@Test
	void testOverlaps() {
		assertTrue(this.lapso.overlaps(lapsoEnElBorde1));
		assertTrue(this.lapso.overlaps(lapsoEnElBorde2));
		assertFalse(this.lapso.overlaps(lapsoAntes));
		assertFalse(this.lapso.overlaps(lapsoDespues));
	}

}