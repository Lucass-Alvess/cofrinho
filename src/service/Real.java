package service;

import java.text.DecimalFormat;

public class Real extends Moeda {
	
	private static final DecimalFormat df = new DecimalFormat("0.00"); // Define o formato de duas casas decimais
	
	public Real(double valor) {
        super(valor);
    }
	
	@Override
	public void info() {
		System.out.println("Real: R$" + df.format(getValor()));
		
	}

	@Override
	public double converter() {
		return  getValor();
	}

}
