package service;

import java.text.DecimalFormat;

public class Dolar extends Moeda {

	final static double taxa = 5.37;
	private static final DecimalFormat df = new DecimalFormat("0.00"); // Define o formato de duas casas decimais
	
	 public Dolar(double valor) {
	        super(valor);
	    }
	
	@Override
	public void info() {
		  System.out.println("Dólar: $" + df.format(getValor()));
	}

	@Override
	public double converter() {
		return  getValor() * taxa;
	}

	
}
