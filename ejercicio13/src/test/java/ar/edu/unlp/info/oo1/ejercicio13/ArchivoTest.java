package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {
	private Archivo a1;
	
	@BeforeEach
	void setUp() throws Exception {
		this.a1 = new Archivo("Goku.jpg");
	}
	@Test 
	void tamanioTest() {
		assertEquals(8,a1.tamanio());
	}
}
