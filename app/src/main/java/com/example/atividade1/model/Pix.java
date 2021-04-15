package com.example.atividade1.model;

public class Pix {

    private String nome;
    private String chave;
    private float saldo;
    private float cheque_especial;

    public Pix(){
        
    }

    public Pix(String nome, String chave, float saldo, float cheque_especial){
        this.nome = nome;
        this.chave = chave;
        this.saldo = saldo;
        this.cheque_especial = cheque_especial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getCheque_especial() {
        return cheque_especial;
    }

    public void setCheque_especial(float cheque_especial) {
        this.cheque_especial = cheque_especial;
    }

    @Override
    public String toString(){
        return this.nome + " - " +  this.chave;
    }

}
