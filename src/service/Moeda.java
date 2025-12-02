package service;

import java.util.Objects;

public abstract  class Moeda {
	
	private double valor;

	public Moeda() {
	}

	public Moeda(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public abstract void info();
	
	public abstract double converter();
	
	@Override
	public int hashCode() {
	    return Objects.hash(valor, getClass());
	}

	@Override
	public boolean equals(Object objeto) {
	    if (this == objeto) return true;
	    if (objeto == null || getClass() != objeto.getClass()) return false;
	    Moeda outraMoeda = (Moeda) objeto;
	    return Double.compare(this.getValor(), outraMoeda.getValor()) == 0;
	}
	
}
