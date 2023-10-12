package com.appcontratoalguel.application;


import java.util.Locale;
import java.util.Scanner;

import com.appcontratoalguel.entities.ContratoAluguel;
import com.appcontratoalguel.entities.Fiador;

public class Application {

	public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true; 
        Fiador fiador = null; 
        ContratoAluguel contrato = null; 

        do {
            System.out.println("Opções:");
            System.out.println("1 - Criar um novo contrato");
            System.out.println("2 - Modificar o fiador do contrato existente");
            System.out.println("3 - Sair do programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    
                	 System.out.println("Informe o nome do novo fiador:");
                     String nomeFiador = scanner.nextLine();

                     System.out.println("Informe o CPF do novo fiador:");
                     String cpfFiador = scanner.nextLine();

                     System.out.println("Informe a renda mensal do novo fiador:");
                     double rendaMensalFiador = scanner.nextDouble();
                     scanner.nextLine();

                     
                     fiador = new Fiador(nomeFiador, cpfFiador, rendaMensalFiador);
                     
                    System.out.println("Informe o número do contrato:");
                    int numeroContrato = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Informe o valor do aluguel:");
                    double valorAluguel = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Informe a quantidade total de meses do contrato: ");
                    int mesesTotal = scanner.nextInt();
                    scanner.nextLine();
                    

					System.out.println("Informe a quantidade de prestações pagas: ");
					int qtdPrestPagas = scanner.nextInt();
					scanner.nextLine();
					
					System.out.println("Informe a quantidade de prestações em atraso: ");
					int qtdPrestAtraso = scanner.nextInt();
					scanner.nextLine();
					
					System.out.println("Informe o percentual de juros mensal por atraso: ");
					double juros = scanner.nextDouble();
					scanner.nextLine();
					
					System.out.println("Informe a quantidade de meses atrasados para despejo: ");
					int mesesAtrasados = scanner.nextInt();
					scanner.nextLine();
					
					contrato = new ContratoAluguel(numeroContrato, valorAluguel, mesesTotal, qtdPrestPagas, qtdPrestAtraso, juros, mesesAtrasados, fiador);

                    System.out.println("Contrato criado com sucesso!");
                    break;
                case 2:
                    if (contrato != null) {
    
                        System.out.println("Informe o nome do novo fiador:");
                        String nomeNovoFiador = scanner.nextLine();

                        System.out.println("Informe o CPF do novo fiador:");
                        String cpfNovoFiador = scanner.nextLine();

                        System.out.println("Informe a renda mensal do novo fiador:");
                        double rendaMensalNovoFiador = scanner.nextDouble();
                        scanner.nextLine();

                        Fiador novoFiador = new Fiador(nomeNovoFiador, cpfNovoFiador, rendaMensalNovoFiador);

                        contrato.modificarFiador(novoFiador);
                        fiador = novoFiador;

                        
                    } else {
                        System.out.println("Crie um contrato antes de modificar o fiador.");
                    }
                    break;
                case 3:
                    if (contrato != null) {
      
                        System.out.println("Informações do Contrato:");
                        System.out.println("Número do Contrato: " + contrato.getNumeroContrato());
                        System.out.println("Valor do Aluguel: " + contrato.getValorAluguel());
                        System.out.println("Quantidade Total de Meses: " + contrato.getQtdMeses());
                        

                        if (fiador != null) {
                            System.out.println("\nInformações do Fiador:");
                            System.out.println("Nome do Fiador: " + fiador.getNome());
                            System.out.println("CPF do Fiador: " + fiador.getCpf());
                            System.out.println("Renda Mensal do Fiador: " + fiador.getRendaMensal());
                        } else {
                            System.out.println("\nNenhum fiador associado a este contrato.");
                        }
                    } else {
                        System.out.println("Nenhum contrato criado ainda.");
                    }
                    continuar = false; 
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (continuar);

        scanner.close();
    }
}


