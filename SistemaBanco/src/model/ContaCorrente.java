package model;

import java.time.LocalDate;
import java.util.Scanner;

public class ContaCorrente extends Conta{

    private double taxaManutencao;

    public ContaCorrente(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente, double taxaManutencao) {
        super(agencia, numero, saldo, dataAbertura, cliente);
        this.taxaManutencao = taxaManutencao;
    }
    
    public static Conta addContaCorrente() {
    	Scanner input = new Scanner(System.in);

    	int agencia;
    	int numero;
    	double saldo;
    	double taxaManutencao;
    	LocalDate dataAbertura = LocalDate.now();
        Cliente clienteNovo = null;
    	
    	System.out.println("Informe o número da agência:");
    	agencia = input.nextInt();
    	System.out.println("Informe o número da conta");
    	numero = input.nextInt();
    	System.out.println("Informe o saldo inicial para deposito na conta:");
    	saldo = input.nextDouble();
    	System.out.println("Informe a taxa de manutenção");
    	taxaManutencao = input.nextDouble();
    	
    	System.out.println("Informe se você é pessoa jurídica(1) ou física(2):");
    	int opt = input.nextInt();
    	if(opt == 1) {
    		clienteNovo = Conta.addJuridica();
    	} else {
    		clienteNovo = Conta.addFisica();
    	}
    	
    	ContaCorrente conta = new ContaCorrente(agencia, numero, saldo, dataAbertura, clienteNovo, taxaManutencao);
    	
    	input.close();
    	
    	return conta;
    	
    }

    @Override
    public boolean sacar(double valor){
        if(valor <= saldo+getCliente().getLimiteCredito()){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    public boolean aplicarTaxa(){
        saldo -= taxaManutencao;
        return true;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }
}