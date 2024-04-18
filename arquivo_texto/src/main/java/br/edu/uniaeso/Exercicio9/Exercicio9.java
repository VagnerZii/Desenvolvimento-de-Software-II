package br.edu.uniaeso.Exercicio9;

import java.io.*;

public class Exercicio9 
{
    public static void main(String[] args)
    {
        String arquivo = "meuarquivo.txt";
        String palavraAlvo = "Java";
        int contador = 0;

        try(BufferedReader leitor = new BufferedReader(new FileReader(arquivo)))
        {
            String linha;
            while((linha = leitor.readLine()) != null)
            {
                String[] palavras = linha.split("\\s+");

                for(String palavra : palavras)
                {
                    palavra = palavra.replaceAll("[^a-zA-Z]","");
                    if(palavra.equalsIgnoreCase(palavraAlvo))
                    {
                        contador++;
                    }
                }
            }
            System.out.println("A palavra " + palavraAlvo + " aparece " + contador + " vezes no arquivo.");
        }
        catch(IOException e)
        {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
