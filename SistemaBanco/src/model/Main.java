package model;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int option = 0;
		boolean loop = true;
		
		Scanner input = new Scanner(System.in);
		ArrayList<Conta> listaContas = new ArrayList<Conta>();
		
		while(loop) {
			System.out.println("Bem-vindo ao Banco do Povo!");
			System.out.println("Informe sua operação:");
			System.out.println("1 - Adicionar conta");
			System.out.println("2 - Realizar depósito");
			System.out.println("Press any number for close.");
			System.out.println(" ");
			
			option = input.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Deseja abrir uma conta poupança ou corrente?");
				System.out.println("1 - Poupança");
				System.out.println("2 - Corrente");			
				System.out.println(" ");

				option = input.nextInt();
				switch(option) {
				case 1:
					ContaPoupanca contaPoupanca = (ContaPoupanca) ContaPoupanca.addContaPoupanca();
					listaContas.add(contaPoupanca);
					break;
				case 2:
					ContaCorrente contaCorrente = (ContaCorrente) ContaCorrente.addContaCorrente();
					listaContas.add(contaCorrente);
					break;
				default:
					break;
				}
			case 2:
				System.out.println("Sua conta será a primeiria, a segunda conta será a que receberá o depósito:");
				Conta contaUsuarioDoador = listaContas.get(0);
				Conta contaUsuarioReceptor = listaContas.get(1);
				
				System.out.println("Informe o total que deseja depositar:");
				double valDeposito = input.nextDouble();
				
				if(contaUsuarioDoador.transferir(contaUsuarioReceptor, valDeposito)) {
					System.out.println("Transferência ocorreu bem.");
					System.out.println(" ");
				} else {
					System.out.println("Transferência não ocorreu bem.");
					System.out.println(" ");
				}
				break;
			default:
				loop = false;
				break;
			}

		}
		
		input.close();
	}
}
