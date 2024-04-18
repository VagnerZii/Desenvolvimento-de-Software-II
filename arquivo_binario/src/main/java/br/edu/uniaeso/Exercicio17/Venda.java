package br.edu.uniaeso.Exercicio17;

import java.io.*;

public class Venda 
{
    
    private int id;
    private String produto;
    private int quantidade;
    private double valorTotal;

    public Venda(int id, String produto, int quantidade, double valorTotal) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public int getId() 
    {
        return id;
    }

    public String getProduto() 
    {
        return produto;
    }

    public int getQuantidade() 
    {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void save(DataOutputStream out) throws IOException 
    {
        out.writeInt(id);
        out.writeUTF(produto);
        out.writeInt(quantidade);
        out.writeDouble(valorTotal);
    }

     public static Venda load(DataInputStream in) throws IOException 
     {
        int id = in.readInt();
        String produto = in.readUTF();
        int quantidade = in.readInt();
        double valorTotal = in.readDouble();
        return new Venda(id, produto, quantidade, valorTotal);
    }

    @Override
    public String toString() 
    {
        return "ID: " + id + ", Produto: " + produto + ", Quantidade: " + quantidade + ", Valor Total: " + valorTotal;
    }
}

