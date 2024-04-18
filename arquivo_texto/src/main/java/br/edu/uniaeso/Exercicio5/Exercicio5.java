package br.edu.uniaeso.Exercicio5;

import java.io.*;

public class Exercicio5
{
    public static void main(String[] args)
    {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_python.txt";

        try(BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
        BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida)))
        {
            String linha;
            while((linha = leitor.readLine()) != null)
            {
                linha = linha.replaceAll("java", "python");
                escritor.write(linha);
                escritor.newLine();
            }

            System.out.println("Substituição concluída. Verifique o arquivo: " + arquivoSaida);
        }
        catch(IOException e)
        {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
