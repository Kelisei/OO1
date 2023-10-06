package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarpetaTest {
	
	private Carpeta c1;
	private Email e1;
	private Email e2;

	@BeforeEach
	void setUp() throws Exception {
		this.c1 = new Carpeta("1234567890");
		this.e1= new Email ("gg","1234567890");
		this.e2= new Email ("ggez","12");
		
	}

	@Test
	void testAgregarYRemoverCorreo() {
		this.c1.agregar(e1);
		assertEquals(1,this.c1.getEmails().size());
		this.c1.eliminar(e1);
		assertEquals(0,this.c1.getEmails().size());
		
	}
	
	@Test
	void testBuscar() {
		this.c1.agregar(e1);
		assertEquals(this.e1,this.c1.buscar("1234567890"));
	}
	
	@Test
	void testEspacioOcupado() {
		this.c1.agregar(e1);
		this.c1.agregar(e2);
		assertEquals(18,this.c1.getTamanio());
		
	}

}