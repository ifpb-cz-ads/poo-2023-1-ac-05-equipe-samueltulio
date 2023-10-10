package view;

import model.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao banco do povo!");
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar conta Pessoa Física");
            System.out.println("2. Criar conta Pessoa Jurídica");
            Scanner ler = new Scanner(System.in);
            int opcao;
            opcao = ler.nextInt();
            if (opcao == 1) {
                System.out.println("Criar conta Pessoa Física");
                System.out.println("1 Conta Corrente");
                System.out.println("2 Conta Poupança");
                int conta;
                conta = ler.nextInt();
                Cliente cliente = null;
                if (conta == 1) {
                    ContaCorrente contaCorrente = new ContaCorrente(105, 77751, 2500, LocalDate.of(2015, 4, 10), cliente);
                } else if (conta == 2) {
                    Poupanca poupanca = new Poupanca(558, 4478555, 4000, LocalDate.of(2010, 1, 2), cliente);
                }
            } else if (opcao == 2) {
                System.out.println("Criar conta Pessoa Juridica");
                System.out.println("1 Conta Corrente");
                System.out.println("2 Conta Poupança");
                int conta;
                conta = ler.nextInt();
                Cliente cliente = null;
                if (conta == 1) {
                    ContaCorrente contaCorrente = new ContaCorrente(105, 77751, 2500, LocalDate.of(2015, 4, 10), cliente);
                } else if (conta == 2) {
                    cliente = null;
                    Poupanca poupanca = new Poupanca(558, 4478555, 4000, LocalDate.of(2010, 1, 2), cliente);
                }
            }
        }
    }
}




















