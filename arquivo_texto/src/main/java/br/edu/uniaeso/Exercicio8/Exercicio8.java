package br.edu.uniaeso.Exercicio8;

import java.io.*;

public class Exercicio8 
{
    public static void main(String[] args)
    {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_sem_excluir.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida))) 
             {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (!linha.contains("excluir")) {
                    escritor.write(linha);
                    escritor.newLine(); 
                }
            }

            System.out.println("Linhas sem 'excluir' salvas em " + arquivoSaida);

        } catch (IOException e) 
        {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }    
}
