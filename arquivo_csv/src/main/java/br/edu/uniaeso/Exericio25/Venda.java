package br.edu.uniaeso.Exericio25;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

class Venda 
{
    private String data;
    private double valor;
    private String produto;

    public Venda(String data, double valor, String produto) 
    {
        this.data = data;
        this.valor = valor;
        this.produto = produto;
    }

    public String getData() 
    {
        return data;
    }

    public double getValor() 
    {
        return valor;
    }

    public String getProduto() 
    {
        return produto;
    }
    public static void exportarVendasParaCSV(List<Venda> vendas, String nomeArquivo) 
    {
        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) 
        {
            String[] cabecalho = {"Data", "Valor", "Produto"};
            writer.writeNext(cabecalho);

            for (Venda venda : vendas) 
            {
                String[] linha = {venda.getData(), String.valueOf(venda.getValor()), venda.getProduto()};
                writer.writeNext(linha);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
