package ar.edu.unlp.info.oo1.a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	
	Sistema sistema;
	Cliente c1;
	Cliente c2;
	Cliente c3;
	Cliente c4;
	
	@BeforeEach
	public void setUp() throws Exception{
		sistema = new Sistema();
		sistema.agregarNumero("123");
		sistema.agregarNumero("312");
		sistema.agregarNumero("231");
		sistema.agregarNumero("321");
	}
	
	@Test
	public void testAltaPersonaJuridica() {
		c1 = sistema.altaPersonaJuridica("nom1", "dir", "Cuit1", "SA");
		c3 = sistema.altaPersonaJuridica("nom3", "dir", "Cuit2", "SA");
		assertNotNull(c1);
		assertNotNull(c3);
	}
	@Test
	public void testAltaPersonaFisica() {
		c2 = sistema.altaPersonaFisica("nom2", "dir", "45.555");
		c4 = sistema.altaPersonaFisica("nom4", "dir", "46.555");
		assertNotNull(c2);
		assertNotNull(c4);
	}
	@Test
	public void testRegistrarLlamada() {
		c1 = sistema.altaPersonaJuridica("nom1", "dir", "Cuit1", "SA");
		c2 = sistema.altaPersonaFisica("nom2", "dir", "45.555");
		sistema.registrarLlamadaInternacional(LocalDate.of(2023, 1, 1), LocalTime.of(8, 0), 25, "312", "Argelia", "Argentina", "123");
		sistema.registrarLlamadaInterurbana(LocalDate.of(2023, 1, 3), LocalTime.of(8, 0), 25, "123", 499.0, "312");
		sistema.registrarLlamadaLocal(LocalDate.of(2023, 1, 3), LocalTime.of(8, 0), 25, "123", "312");
		assertEquals(1, c1.getLlamadas().size());
		assertEquals(2, c2.getLlamadas().size());
	}
}
