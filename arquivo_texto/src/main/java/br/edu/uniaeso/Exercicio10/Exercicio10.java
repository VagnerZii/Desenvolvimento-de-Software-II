package br.edu.uniaeso.Exercicio10;

import java.io.*;

public class Exercicio10 
{
    public static void main(String[] args)
    {
        String arquivo1 = "arquivo1.txt";
        String arquivo2 = "arquivo2.txt";
        String arquivoConcatenado = "arquivo_concatenado.txt";

        String conteudoArquivo1 = "Olá";
        String conteudoArquivo2 = "Mundo";

        escreverArquivo(arquivo1, conteudoArquivo1);
        escreverArquivo(arquivo2, conteudoArquivo2);

        concatenarArquivos(arquivo1, arquivo2, arquivoConcatenado);

        System.out.println("Arquivos concatenados com sucesso.");
    }

    private static void escreverArquivo(String nomeArquivo, String conteudo) 
    {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) 
        {
            escritor.write(conteudo);
        } 
        catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    private static void concatenarArquivos(String arquivo1, String arquivo2, String arquivoConcatenado) 
    {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoConcatenado));
             BufferedReader leitor1 = new BufferedReader(new FileReader(arquivo1));
             BufferedReader leitor2 = new BufferedReader(new FileReader(arquivo2))) 
             {

            String linha;
            while ((linha = leitor1.readLine()) != null) 
            {
                escritor.write(linha);
                escritor.newLine();
            }

            while ((linha = leitor2.readLine()) != null) 
            {
                escritor.write(linha);
                escritor.newLine();
            }
        } 
        catch (IOException e) {
            System.err.println("Erro ao concatenar arquivos: " + e.getMessage());
        }
    }    
}
