package br.edu.uniaeso.Exercicio13;

import java.io.*;

class Produto implements Serializable
{
    private String nome;
    private double preco;

    public Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }

    public String getName()
    {
        return nome;
    }

    public double getPreco()
    {
        return preco;
    }

    @Override
    public String toString()
    {
        return "Produto [nome = " + nome + ", preco = " + preco + "]";
    }
}