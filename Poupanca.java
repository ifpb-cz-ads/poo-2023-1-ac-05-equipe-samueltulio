package model;

import java.time.LocalDate;

public class Poupanca extends Conta {
    private double taxaJuros;

    public Poupanca(int agencia, int numero, double saldo, LocalDate dtAbertura, Cliente cliente) {
        super(agencia, numero, saldo, dtAbertura, cliente);
        this.taxaJuros = taxaJuros;
    }

    double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public boolean sacar(double valor) {
        //TODO: Verificar as restrições
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }
         else{
            return false;
        }

    }


    public boolean renderJuros(){
        saldo += (saldo*taxaJuros)/100;
        return true;
    }
}
