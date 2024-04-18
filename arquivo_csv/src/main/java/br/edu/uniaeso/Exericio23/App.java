package br.edu.uniaeso.Exericio23;

import java.util.Scanner;

public class App 
{

    public static void main(String[] args) 
    {
        Scanner ler = new Scanner(System.in);
        Produto produto = new Produto();

        System.out.println("Escolha uma opção:");
        System.out.println("1. Adicionar novo produto");
        System.out.println("2. Atualizar produto existente");
        System.out.println("3. Excluir produto");

        int opcao = ler.nextInt();
        ler.nextLine();
        switch (opcao) {
            case 1:
                produto.adicionarNovoProduto(ler);
                break;
            case 2:
                produto.atualizarProdutoExistente(ler);
                break;
            case 3:
                produto.excluirProduto(ler);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        
        ler.close();
    }
}
