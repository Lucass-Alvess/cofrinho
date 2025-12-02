package service;

import java.text.DecimalFormat;

public class Euro extends Moeda {

	final static double taxa = 6.22;
	private static final DecimalFormat df = new DecimalFormat("0.00"); // Define o formato de duas casas decimais
	
	protected double valor;
	
	 public Euro(double valor) {
	        super(valor);
	    }
	
	
	@Override
	public void info() {
		 System.out.println("Euro: €" + df.format(getValor()));
		
	}

	@Override
	public double converter() {
		return  getValor() * taxa;
	}

}
