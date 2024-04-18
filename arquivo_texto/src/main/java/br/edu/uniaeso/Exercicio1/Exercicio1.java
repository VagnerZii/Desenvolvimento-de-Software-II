package br.edu.uniaeso.Exercicio1;

import java.io.*;

public class Exercicio1
{
    public static void main(String[] args) 
    {
        String nomeArquivo = "meuarquivo.txt";
        String mensagem = "Ola, Mundo!";

        try 
        {
            FileWriter arquivoEscrita = new FileWriter(nomeArquivo);
            PrintWriter gravarArquivo = new PrintWriter(arquivoEscrita);
            gravarArquivo.println(mensagem);
            gravarArquivo.close();
            System.out.println("Mensagem escrita com sucesso no arquivo.");
        } 
        catch (IOException e) 
        {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}

