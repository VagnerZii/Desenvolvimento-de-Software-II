package br.edu.uniaeso.Exericio22;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.exceptions.CsvValidationException;

public class Produto {

    @CsvBindByName(column = "Nome")
    private String nome;

    @CsvBindByName(column = "Preço")
    private double preco;
   
    @CsvBindByName(column = "Quantidade")
    private int quantidade;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto(String nome2, double preco2, int quantidade2) {
        this.nome = nome2;
        this.preco = preco2;
        this.quantidade = quantidade2;
    }

    public Produto() {
    }
    public static void adicionarProdutoAoCSV(String nome, double preco, int quantidade) {
        try {
            FileWriter outputFile = new FileWriter("produtos.csv", true);
            CSVWriter writer = new CSVWriter(outputFile);

            String[] produto = { nome, Double.toString(preco), Integer.toString(quantidade) };
            writer.writeNext(produto);

            writer.close();
            outputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Produto buscarProdutoPorNome(String nome) {
        try (CSVReader reader = new CSVReader(new FileReader("produtos.csv"))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                if (linha[0].equalsIgnoreCase(nome)) {
                    double preco = Double.parseDouble(linha[1]);
                    int quantidade = Integer.parseInt(linha[2]);
                    return new Produto(nome, preco, quantidade);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void salvarAlteracoesNoCSV() {
        try (CSVReader reader = new CSVReader(new FileReader("produtos.csv"));
                CSVWriter writer = new CSVWriter(new FileWriter("temp.csv"))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                if (linha[0].equalsIgnoreCase(this.nome)) {
                    linha[1] = Double.toString(this.preco);
                    linha[2] = Integer.toString(this.quantidade);
                }
                writer.writeNext(linha);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        
        File arquivoOriginal = new File("produtos.csv");
        File arquivoTemporario = new File("temp.csv");
        arquivoOriginal.delete();
        arquivoTemporario.renameTo(arquivoOriginal);
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + "]";
    }
}
