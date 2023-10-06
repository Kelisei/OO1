package ar.edu.unlp.info.oo1.ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteDeCorreoTest {
	private ClienteDeCorreo c1;
	private ClienteDeCorreo c2;
	private Email e1;
	private Email e2;
	private Email e3;
	private Carpeta Facultad;
	@BeforeEach
	public void setUp() throws Exception{
		Facultad = new Carpeta("Facultad");
		e1 = new Email("Hola", "Zapato");
		Facultad.agregar(e1);
		c1 = new ClienteDeCorreo();
		c1.agregarCarpeta(Facultad);
		e2 = new Email("tuki", "tucson");
		c1.recibir(e2);
		
		e3 = new Email("Zapallo", "Raid");
		e3.agregarAdjuntos(new Archivo("Archivo1"));
		c2 = new ClienteDeCorreo();
		c2.recibir(e3);
	}
	@Test
	void testBusqueda() {
		assertEquals(e1, c1.buscar("Zapato"));
	}
	@Test 
	void testMover() {
		c1.mover(e2, c1.getCarpeta("Inbox"), Facultad);
		assertEquals(0, c1.getCarpeta("Inbox").getEmails().size());
		assertEquals(2, c1.getCarpeta("Facultad").getEmails().size());
	}
	@Test  
	void testEspacioOcupado() {
		assertEquals(19, c2.espacioOcupado());		
	}
}
