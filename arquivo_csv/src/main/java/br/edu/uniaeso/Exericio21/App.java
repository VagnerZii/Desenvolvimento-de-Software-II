package br.edu.uniaeso.Exericio21;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) 
    {
        Scanner ler = new Scanner(System.in);

        System.out.println("Informe o nome do produto:");
        String nome = ler.nextLine();

        System.out.println("Informe o preço do produto:");
        double preco = ler.nextDouble();

        System.out.println("Informe a quantidade do produto:");
        int quantidade = ler.nextInt();

        Produto.adicionarProdutoAoCSV(nome, preco, quantidade);

        System.out.println("Produto adicionado com sucesso ao arquivo CSV!");
        ler.close();
    }

}
