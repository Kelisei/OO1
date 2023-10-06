package ar.edu.unlp.info.oo1.ejercicio14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateLapseTest {
	private DateLapseInterface d1;
	private DateLapseInterface d2;
	@BeforeEach
	void SetUp() throws Exception{
		/*
		d1 = new DateLapse(LocalDate.of(2023, 10, 24), LocalDate.of(2023, 10, 5));
		d2 = new DateLapse(LocalDate.of(2023, 11, 20), LocalDate.of(2023, 10, 15));
		 */
		d1 = new DateLapseAlter(19, LocalDate.of(2023, 10, 5));
		d2 = new DateLapseAlter(36, LocalDate.of(2023, 10, 15));
	}
	@Test
	void testSizeInDays() {
		assertEquals(19, this.d1.sizeInDays());
		assertEquals(36,this.d2.sizeInDays());
	}
	@Test
	void testIncludesDate() {
		assertTrue(this.d1.includesDate(LocalDate.of(2023, 10, 6)));
		assertTrue(this.d1.includesDate(LocalDate.of(2023, 10, 23)));
	}
}
