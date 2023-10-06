package ar.edu.unlp.info.oo1.ejercicio14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse implements DateLapseInterface{
	private LocalDate to;
	private LocalDate from;
	public DateLapse(LocalDate to, LocalDate from) {
		super();
		this.to = to;
		this.from = from;
	}
	public LocalDate getTo() {
		return to;
	}
	public LocalDate getFrom() {
		return from;
	}
	@Override
	public int sizeInDays() {
		return (int) this.getFrom().until(this.getTo(), ChronoUnit.DAYS);
	}
	@Override
	public boolean includesDate(LocalDate other) {
		return other.isAfter(this.getFrom()) && other.isBefore(this.getTo());
	}
	
}
