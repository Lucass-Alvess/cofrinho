package application;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Cofrinho;
import service.Dolar;
import service.Euro;
import service.Moeda;
import service.Real;

public class Program {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		final DecimalFormat df = new DecimalFormat("0.00"); // Define o formato de duas casas decimais
        Cofrinho cofrinho = new Cofrinho();

        int opcao = 0; // Variável para controlar a opção do menu

        // Menu
        while (opcao != 5) {

            System.out.println("\n===== COFRINHO =====");
            System.out.println("1 - Adicionar moeda");
            System.out.println("2 - Remover moeda");
            System.out.println("3 - Listar moedas");
            System.out.println("4 - Calcular total convertido para real");
            System.out.println("5 - Encerrar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
            	
            	// Adicionar moeda
                case 1:
                    System.out.println("\nEscolha a moeda:");
                    System.out.println("1 - Real");
                    System.out.println("2 - Dólar");
                    System.out.println("3 - Euro");
                    int tipoAdd = sc.nextInt();

                    System.out.print("Valor: ");
                    double valorAdd = sc.nextDouble();

                    Moeda tipo = null;

                    if (tipoAdd == 1) tipo = new Real(valorAdd);
                    if (tipoAdd == 2) tipo = new Dolar(valorAdd);
                    if (tipoAdd == 3) tipo = new Euro(valorAdd);

                    cofrinho.adicionar(tipo);
                    break;

                // Remover    
                case 2:
                    System.out.println("\n--- Remover moeda ---");
                    System.out.println("1 - Real");
                    System.out.println("2 - Dolar");
                    System.out.println("3 - Euro");
                    System.out.print("Tipo: ");
                    int tipoRemover = sc.nextInt();

                    System.out.print("Valor da moeda a remover: ");
                    double valorRemover = sc.nextDouble();

                    cofrinho.removerMoeda(valorRemover, tipoRemover);
                    break;

                // Listar
                case 3:
                    System.out.println("\n--- Moedas no cofrinho ---");
                    cofrinho.listagemMoedas();
                    break;
                
                // Converter    
                case 4:
                    System.out.println("\nTotal convertido para reais: R$ " 
                        + df.format(cofrinho.totalConvertido()));
                    break;
                
                // Encerrar    
                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        sc.close();

	}

}
