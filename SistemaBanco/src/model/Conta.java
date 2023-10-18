package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class Conta {

    private int agencia;
    private int numero;
    protected double saldo;
    private LocalDate dataAbertura;
    protected Cliente cliente;

    public Conta(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
    }
    
    
    public boolean transferir(Conta conta, double valor) {
    	if(this.saldo >= valor) {
    		this.saldo -= valor;
    		conta.saldo += valor;
    		return true;
    	} else return false;
    }
    
    public boolean depositar(double valor){
        saldo += valor;
        return true;
    }

    public abstract boolean sacar(double valor);

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public static Cliente addJuridica() {
    	Scanner input = new Scanner(System.in);
    	
    	double limiteCredito;
    	String cnpj;
    	String razaoSocial;
    	
		System.out.println("Informe seu limite de crédito:");
		limiteCredito = input.nextDouble();
		
		System.out.println("Informe seu endereco:");
		Endereco endereco = addEndereco();
		
		System.out.println("Informe seu CNPJ");
		cnpj = input.nextLine();
		input.nextLine();
		
		System.out.println("Informe seu razão social:");
		razaoSocial = input.nextLine();
		input.nextLine();

		PessoaJuridica novoCliente = new PessoaJuridica(limiteCredito, endereco, cnpj, razaoSocial);
		
		input.close();
		return novoCliente;
    }
    
    public static Cliente addFisica() {
    	Scanner input = new Scanner(System.in);
    	
    	double limiteCredito;
    	int cpf;
    	String nome;
    	
		System.out.println("Informe seu limite de crédito:");
		limiteCredito = input.nextDouble();
		
		System.out.println("Informe seu endereco:");
		Endereco endereco = addEndereco();
		
		System.out.println("Informe seu CPF");
		cpf = input.nextInt();
		
		System.out.println("Informe seu nome:");
		nome = input.nextLine();
		input.nextLine();
		
        System.out.println("Informe sua data de nascimento (no formato yyyy-MM-dd):");
        String datNascimento = input.nextLine();
        input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate nascimento = LocalDate.parse(datNascimento, formatter);
        
		PessoaFisica novoCliente = new PessoaFisica(limiteCredito, endereco, cpf, nome, nascimento);
		
		input.close();
		return novoCliente;
    }
    
    public static Endereco addEndereco() {
    	Scanner input = new Scanner(System.in);

        String rua;
        int numero;
        String cidade;

        System.out.println("Informe o nome da sua rua:");
        rua = input.nextLine();
        System.out.println("Informe o numero da sua casa:");
        numero = input.nextInt();
        input.nextLine();

        System.out.println("Informe o nome do seu bairro:");
        cidade = input.nextLine();

        Endereco endereco = new Endereco(rua, numero, cidade);
        
        input.close();

        return endereco;
    }
}
