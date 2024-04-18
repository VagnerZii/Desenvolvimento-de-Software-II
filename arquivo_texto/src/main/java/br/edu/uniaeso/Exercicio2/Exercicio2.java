package br.edu.uniaeso.Exercicio2;

import java.io.*;

public class Exercicio2
{
    public static void main(String[] args) 
    {
        String nomeArquivo = "meuarquivo.txt";

        System.out.print("Conteúdo do Arquivo: ");
        
        try 
        {
            FileReader arquivoLeitura = new FileReader(nomeArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            String linha;
            while ((linha = lerArquivo.readLine()) != null)
            {
                System.out.println(linha);
            }
            
            lerArquivo.close();
        }
        catch (IOException e)
        {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
    
}
