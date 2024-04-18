package br.edu.uniaeso.Exercicio17;

import java.io.*;
import java.util.*;


public class ArquivoVendas 
{
    private static final String NOME_ARQUIVO = "vendas.bin";

    public static void adicionarVenda(Venda venda) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(NOME_ARQUIVO, true))) 
        {
            venda.save(out);
            System.out.println("Venda adicionada com sucesso.");
        } 
        catch (IOException e) 
        {
            System.err.println("Erro ao adicionar venda: " + e.getMessage());
        }
    }

    public static void atualizarVenda(Venda venda) 
    {
        List<Venda> vendas = lerTodasVendas();

        boolean atualizado = false;
        for (int i = 0; i < vendas.size(); i++) 
        {
            if (vendas.get(i).getId() == venda.getId()) 
            {
                vendas.set(i, venda);
                atualizado = true;
                break;
            }
        }

        if (atualizado) 
        {
            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(NOME_ARQUIVO))) 
            {
                for (Venda v : vendas)
                {
                    v.save(out);
                }
                System.out.println("Venda atualizada com sucesso.");
            } 
            catch (IOException e) 
            {
                System.err.println("Erro ao atualizar venda: " + e.getMessage());
            }
        } 
        else 
        {
            System.out.println("Venda com ID " + venda.getId() + " não encontrada.");
        }
    }

    public static void excluirVenda(int id, Scanner scanner) 
    {

        System.out.println("Deseja realmente excluir a venda com ID " + id + "?");
        System.out.println("Digite [0] para sim ou [1] para não:");

        int escolha = scanner.nextInt();

        switch (escolha) 
        {
            case 0:
                List<Venda> vendas = lerTodasVendas();
                boolean excluido = false;
                Iterator<Venda> iterator = vendas.iterator();

                while (iterator.hasNext()) 
                {
                    Venda venda = iterator.next();
                    if (venda.getId() == id) 
                    {
                        iterator.remove();
                        excluido = true;
                        break;
                    }
                }

                if (excluido) 
                {
                    try (DataOutputStream out = new DataOutputStream(new FileOutputStream(NOME_ARQUIVO))) 
                    {
                        for (Venda v : vendas) 
                        {
                            v.save(out);
                        }
                        System.out.println("Venda excluída com sucesso.");
                    } 
                    catch (IOException e) 
                    {
                        System.err.println("Erro ao excluir venda: " + e.getMessage());
                    }
                } 
                else 
                {
                    System.out.println("Venda com ID " + id + " não encontrada.");
                }
                break;
            case 1:
                System.out.println("Exclusão cancelada.");
                break;
            default:
                System.out.println("Entrada inválida. Por favor, digite [0] para sim ou [1] para não.");
                excluirVenda(id, scanner);
                break;
        }
    }

    public static List<Venda> lerTodasVendas() 
    {
        List<Venda> vendas = new ArrayList<>();

        try (DataInputStream in = new DataInputStream(new FileInputStream(NOME_ARQUIVO))) 
        {
            while (in.available() > 0) 
            {
                Venda venda = Venda.load(in);
                vendas.add(venda);
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Erro ao ler vendas: " + e.getMessage());
        }

        return vendas;
    }
}
