package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapseAlter implements DateLapseInterface{
	private int sizeInDays;
	private LocalDate from;
	public DateLapseAlter(int sizeInDays, LocalDate from) {
		super();
		this.sizeInDays= sizeInDays;
		this.from = from;
	}
	public LocalDate getTo() {
		return this.getFrom().plus(sizeInDays, ChronoUnit.DAYS);
	}
	public LocalDate getFrom() {
		return from;
	}
	@Override
	public int sizeInDays() {
		return this.sizeInDays;
	}
	@Override
	public boolean includesDate(LocalDate other) {
		return other.isAfter(this.getFrom()) && other.isBefore(this.getTo());
	}
	
}
