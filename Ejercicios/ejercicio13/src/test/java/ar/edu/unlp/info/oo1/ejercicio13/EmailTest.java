package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	
	private Email e1;
	private Email e2;
	private Archivo a1;
	private Archivo a2;

	@BeforeEach
	void setUp() throws Exception {
		this.e1 = new Email ("Zapallo","kk");
		this.e2 = new Email ("1213","213");
		this.a1 = new Archivo("23");
		this.a2 = new Archivo("23");
		
	}
	
	@Test
	void tamanioTest() {
		this.e1.agregarAdjuntos(a1);
		this.e1.agregarAdjuntos(a2);
		assertEquals(13,this.e1.getTamanio());
		assertEquals(7,this.e2.getTamanio());
	}
	
	@Test
	void contieneTest() {
		assertTrue(this.e2.contiene("1213"));
		assertFalse(this.e2.contiene("Mail"));
		
	}

}