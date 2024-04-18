package br.edu.uniaeso.Exercicio4;

import java.io.*;

public class Exercicio4
{
    public static void main(String[] args)
    {
        String nomeArquivo = "meuarquivo.txt";

        try
        {
            FileReader arquivoLeitura = new FileReader(nomeArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            int contadorLinhas = 0;
            while (lerArquivo.readLine() != null)
            {
                contadorLinhas++;
            }
            lerArquivo.close();
            
            System.out.println("Número de linhas no arquivo: " + contadorLinhas);
        }
        catch(IOException e)
        {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}