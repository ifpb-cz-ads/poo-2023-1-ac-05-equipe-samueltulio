package model;

import java.time.LocalDate;

public class PessoaFisica extends Cliente {
    private String cpf;
    private String nome;
    private LocalDate dtNascimento;

    public PessoaFisica(double limiteCredito, Endereco endereco, String cpf, String nome, LocalDate dtNascimento) {
        super(limiteCredito, endereco);
        this.cpf = cpf;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
