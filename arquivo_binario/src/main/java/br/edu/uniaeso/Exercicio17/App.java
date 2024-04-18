package br.edu.uniaeso.Exercicio17;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ArquivoVendas.adicionarVenda(new Venda(1, "Arroz", 10, 20.00));
        ArquivoVendas.adicionarVenda(new Venda(2, "Feijão", 5, 15.00));
        ArquivoVendas.adicionarVenda(new Venda(3, "Açúcar", 8, 12.00));

        ArquivoVendas.atualizarVenda(new Venda(1, "Arroz", 10, 22.00));

        ArquivoVendas.excluirVenda(3, ler);
        ArquivoVendas.excluirVenda(2, ler);

        List<Venda> vendas = ArquivoVendas.lerTodasVendas();
        System.out.println("Vendas restantes:");
        for (Venda venda : vendas) {
            System.out.println(venda);
        }
        ler.close();
    }
}
