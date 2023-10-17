package model;

import java.time.LocalDate;

public class PessoaFisica extends Cliente{

    private int cpf;
    private String nome;
    private LocalDate nascimento;

    public PessoaFisica(double limiteCredito, Endereco endereco, int cpf, String nome, LocalDate nascimento) {
        super(limiteCredito, endereco);
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}