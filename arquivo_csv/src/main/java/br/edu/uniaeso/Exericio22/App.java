package br.edu.uniaeso.Exericio22;

import java.util.Scanner;

public class App 
{

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Adicionar novo produto");
        System.out.println("2. Atualizar produto existente");

        int opcao = ler.nextInt();
        ler.nextLine();

        if (opcao == 1) {
            adicionarNovoProduto(ler);
        } else if (opcao == 2) {
            atualizarProdutoExistente(ler);
        } else {
            System.out.println("Opção inválida!");
        }

        ler.close();
    }

    private static void adicionarNovoProduto(Scanner ler) {
        System.out.println("Informe o nome do produto:");
        String nome = ler.nextLine();

        System.out.println("Informe o preço do produto:");
        double preco = ler.nextDouble();

        System.out.println("Informe a quantidade do produto:");
        int quantidade = ler.nextInt();

        Produto.adicionarProdutoAoCSV(nome, preco, quantidade);

        System.out.println("Produto adicionado com sucesso ao arquivo CSV!");
    }

    private static void atualizarProdutoExistente(Scanner ler) {
        System.out.println("Informe o nome do produto que deseja atualizar:");
        String nome = ler.nextLine();

        Produto produto = Produto.buscarProdutoPorNome(nome);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Produto encontrado: " + produto);

            System.out.println("Informe o novo preço do produto:");
            double novoPreco = ler.nextDouble();

            System.out.println("Informe a nova quantidade do produto:");
            int novaQuantidade = ler.nextInt();

            produto.setPreco(novoPreco);
            produto.setQuantidade(novaQuantidade);
            produto.salvarAlteracoesNoCSV();

            System.out.println("Produto atualizado com sucesso no arquivo CSV!");
        }
    }
}

