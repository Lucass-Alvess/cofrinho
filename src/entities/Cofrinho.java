package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import service.Dolar;
import service.Euro;
import service.Moeda;
import service.Real;

public class Cofrinho {

    private List<Moeda> listaMoedas = new ArrayList<>();

    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

 
    public void removerMoeda(double valor, int tipo) {
        
        Iterator<Moeda> iterator = listaMoedas.iterator();
        boolean moedaRemovida = false;

        while (iterator.hasNext()) {
            Moeda m = iterator.next();

            // Verifica se o valor é igual (usando getValor)
            if (m.getValor() == valor) {
                
                //Verifica se o TIPO bate com o número do menu 
                boolean tipoCorreto = false;
                
                if (tipo == 1 && m instanceof Real) tipoCorreto = true;
                else if (tipo == 2 && m instanceof Dolar) tipoCorreto = true;
                else if (tipo == 3 && m instanceof Euro) tipoCorreto = true;

                // Se valor e tipo baterem, removemos!
                if (tipoCorreto) {
                    iterator.remove();
                    System.out.println("Moeda removida com sucesso!");
                    moedaRemovida = true;
                    break; // Para o loop para não remover moedas duplicadas
                }
            }
        }

        if (!moedaRemovida) {
            System.out.println("Moeda não encontrada!");
        }
    }
    
    public void listagemMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("Cofrinho vazio!");
            return;
        }
        for (Moeda m : listaMoedas) {
            m.info();
        }
    }

    public double totalConvertido() {
        double total = 0.0;
        for (Moeda m : listaMoedas) {
            total += m.converter();
        }
        return total;
    }
    
    
    
    
}

