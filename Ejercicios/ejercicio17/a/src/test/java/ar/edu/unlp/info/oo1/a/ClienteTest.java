package ar.edu.unlp.info.oo1.a;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
	public Cliente juridico;
	public Cliente fisico;
	public Cliente juridicoSinLlamadas;
	public Cliente fisicoSinLlamadas;
	
	@BeforeEach
	public void setUp() throws Exception{
		juridico = new PersonaJuridica("nom1", "dir", "123", "CUIT1", "S.A");
		fisico = new PersonaFisica("nom2", "dir", "312", "45.555");
		juridicoSinLlamadas = new PersonaJuridica("nom3", "dir", "231", "CUIT2", "S.R.L");
		fisicoSinLlamadas = new PersonaFisica("nom4", "dir", "321", "46.666");
		
		//Testeamos los limites y que tome correctamente los valores de cada tipo de llamada
		juridico.registrarLlamadaLocal(LocalDate.of(2021, 12, 31), LocalTime.of(8, 0), 25, "321");
		juridico.registrarLlamadaInternacional(LocalDate.of(2022, 1, 1), LocalTime.of(8, 0), 25, "312", "Argelia", "Argentina");
		juridico.registrarLlamadaInterurbana(LocalDate.of(2022, 1, 3), LocalTime.of(8, 0), 25, "321", 21);
		juridico.registrarLlamadaLocal(LocalDate.of(2022, 1, 4), LocalTime.of(8, 0), 25, "321");

		fisico.registrarLlamadaLocal(LocalDate.of(2022, 12, 31), LocalTime.of(8, 0), 25, "321");
		fisico.registrarLlamadaInternacional(LocalDate.of(2023, 1, 1), LocalTime.of(8, 0), 25, "312", "Argelia", "Argentina");
		fisico.registrarLlamadaInterurbana(LocalDate.of(2023, 1, 3), LocalTime.of(8, 0), 25, "321", 21);
		fisico.registrarLlamadaLocal(LocalDate.of(2023, 1, 4), LocalTime.of(8, 0), 25, "321");
	}
	
	@Test
	public void facturarFisicoTest() {
		Factura factura = fisico.facturar(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 3), LocalDate.now());
		assertEquals(117, factura.getMonto());
	}
	@Test
	public void facturarJuridicoTest() {
		Factura factura = juridico.facturar(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 3), LocalDate.now());
		assertEquals(130, factura.getMonto());
	}
	@Test
	public void facturarFisicoSinLlamadasTest() {
		Factura factura = fisicoSinLlamadas.facturar(LocalDate.of(2021, 12, 31), LocalDate.of(2024, 1, 2), LocalDate.now());
		assertEquals(0, factura.getMonto());
	}
	@Test
	public void facturarJuridicoSinLlamadasTest() {
		Factura factura = juridicoSinLlamadas.facturar(LocalDate.of(2021, 12, 31), LocalDate.of(2024, 1, 2), LocalDate.now());
		assertEquals(0, factura.getMonto());
	}
}
