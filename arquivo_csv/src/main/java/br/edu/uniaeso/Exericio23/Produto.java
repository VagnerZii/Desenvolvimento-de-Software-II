package br.edu.uniaeso.Exericio23;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class Produto 
{
    private String nome;
    private double preco;
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

    public void setPreco(double preco) 
    {
        this.preco = preco;
    }

    public int getQuantidade() 
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade) 
    {
        this.quantidade = quantidade;
    }

    public Produto(String nome, double preco, int quantidade) 
    {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto() {
    }

    public void trocaArquivo() 
    {
        File arquivoOriginal = new File("produtos.csv");
        File arquivoTemporario = new File("temp.csv");
        arquivoOriginal.delete();
        arquivoTemporario.renameTo(arquivoOriginal);
    }

    public void adicionarNovoProduto(Scanner ler) 
    {
        System.out.println("Informe o nome do produto:");
        this.nome = ler.nextLine();

        System.out.println("Informe o preço do produto:");
        this.preco = ler.nextDouble();

        System.out.println("Informe a quantidade do produto:");
        this.quantidade = ler.nextInt();

        adicionarProdutoAoCSV(this.nome, this.preco, this.quantidade);

        System.out.println("Produto adicionado com sucesso ao arquivo CSV!");
    }

    public void atualizarProdutoExistente(Scanner ler) {
        System.out.println("Informe o nome do produto que deseja atualizar:");
        this.nome = ler.nextLine();

        Produto produto = buscarProdutoPorNome(this.nome);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Produto encontrado: " + produto);

            System.out.println("Informe o novo preço do produto:");
            this.preco = ler.nextDouble();

            System.out.println("Informe a nova quantidade do produto:");
            this.quantidade = ler.nextInt();

            produto.setPreco(this.preco);
            produto.setQuantidade(this.quantidade);
            produto.salvarAlteracoesNoCSV();

            System.out.println("Produto atualizado com sucesso no arquivo CSV!");
        }
    }

    public void excluirProduto(Scanner ler) 
    {
        System.out.println("Informe o nome do produto que deseja excluir:");
        this.nome = ler.nextLine();

        boolean excluido = excluir(this.nome);

        if (excluido) {
            System.out.println("Produto excluído com sucesso do arquivo CSV!");
        } else {
            System.out.println("Produto não encontrado no arquivo CSV.");
        }
    }

    public static void adicionarProdutoAoCSV(String nome, double preco, int quantidade) 
    {
        try 
        {
            FileWriter outputFile = new FileWriter("produtos.csv", true);
            outputFile.write(nome + "," + preco + "," + quantidade + "\n");
            outputFile.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static Produto buscarProdutoPorNome(String nome) 
    {
        try (Scanner scanner = new Scanner(new FileReader("produtos.csv"))) 
        {
            while (scanner.hasNextLine()) 
            {
                String linha = scanner.nextLine();
                String[] dados = linha.split(",");
                if (dados[0].equalsIgnoreCase(nome)) {
                    double preco = Double.parseDouble(dados[1]);
                    int quantidade = Integer.parseInt(dados[2]);
                    return new Produto(nome, preco, quantidade);
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean excluir(String nome) {
        try (CSVReader reader = new CSVReader(new FileReader("produtos.csv"));
                CSVWriter writer = new CSVWriter(new FileWriter("temp.csv"))) 
                {

            List<String[]> linhas = reader.readAll();
            

            for (String[] linha : linhas) {
                if (linha[0].equalsIgnoreCase(nome)) 
                {
                    continue; 
                }
                writer.writeNext(linha);
            }

        } 
        catch (IOException | CsvException e) 
        {
            e.printStackTrace();
            return false;
        }
        
        this.trocaArquivo();
        return true;
    }
    public void salvarAlteracoesNoCSV() 
    {
        try (Scanner scanner = new Scanner(new FileReader("produtos.csv"));
                FileWriter fileWriter = new FileWriter("temp.csv")) 
                {
            while (scanner.hasNextLine()) 
            {
                String linha = scanner.nextLine();
                String[] dados = linha.split(",");
                if (dados[0].equalsIgnoreCase(this.nome)) 
                {
                    linha = this.nome + "," + this.preco + "," + this.quantidade;
                }
                fileWriter.write(linha + "\n");
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        trocaArquivo();
    }

}
