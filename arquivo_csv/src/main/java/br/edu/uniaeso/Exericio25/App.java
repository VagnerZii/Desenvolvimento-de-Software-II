package br.edu.uniaeso.Exericio25;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main(String[] args) 
    {

        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda("2024-04-17", 150.0, "Produto A"));
        vendas.add(new Venda("2024-04-30", 300.0, "Produto B"));
        vendas.add(new Venda("2024-10-21", 600.0, "Produto C"));

        Venda.exportarVendasParaCSV(vendas, "vendas.csv");

        System.out.println("Vendas exportadas para vendas.csv com sucesso!");
    }

}

