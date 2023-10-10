package model;

import java.time.LocalDate;

public abstract class Conta {
    private int agencia;
    private int numero;
    protected double saldo;
    private LocalDate dtAbertura;
    private Cliente cliente;

    public Conta(int agencia, int numero, double saldo, LocalDate dtAbertura, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dtAbertura = dtAbertura;
        this.cliente = cliente;
    }

    public abstract boolean sacar(double valor);
    public boolean depositar(double valor){
        //TODO: Verificar problemas no preenchimento
        saldo += valor;
        return true;
    }

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

    public LocalDate getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(LocalDate dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
