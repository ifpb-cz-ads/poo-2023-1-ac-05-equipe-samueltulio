package model;

import java.time.LocalDate;
import java.util.Scanner;

public class ContaPoupanca extends Conta{

    private double taxaJuros;

    public ContaPoupanca(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente, double taxaJuros) {
        super(agencia, numero, saldo, dataAbertura, cliente);
        this.taxaJuros = taxaJuros;
    }
    
    public static Conta addContaPoupanca() {
    	Scanner input = new Scanner(System.in);

    	int agencia;
    	int numero;
    	double saldo;
    	double taxaJuros;
    	LocalDate dataAbertura = LocalDate.now();
        Cliente clienteNovo = null;
    	
    	System.out.println("Informe o número da agência:");
    	agencia = input.nextInt();
    	System.out.println("Informe o número da conta");
    	numero = input.nextInt();
    	System.out.println("Informe o saldo inicial para deposito na conta:");
    	saldo = input.nextDouble();
    	System.out.println("Informe a taxa de taxa de juros:");
    	taxaJuros = input.nextDouble();
    	
    	System.out.println("Informe se você é pessoa jurídica(1) ou física(2):");
    	int opt = input.nextInt();
    	if(opt == 1) {
    		clienteNovo = Conta.addJuridica();
    	} else {
    		clienteNovo = Conta.addFisica();
    	}
    	
    	ContaPoupanca conta = new ContaPoupanca(agencia, numero, saldo, dataAbertura, clienteNovo, taxaJuros);
    	
    	input.close();
    	
    	return conta;
    	
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    public boolean renderJuros(){
        saldo += saldo*taxaJuros/100;
        return true;
    }

}