package br.edu.uniaeso.Exercicio3;

import java.io.*;

public class Exercicio3
{
    public static void main(String[] args)
    {
        String nomeArquivo = "meuarquivo.txt";
        String mensagemAdicional = "Java";
        try 
        {
            FileWriter arquivoEscrita = new FileWriter(nomeArquivo, true);
            PrintWriter gravarArquivo = new PrintWriter(arquivoEscrita);
            gravarArquivo.println(mensagemAdicional);
            gravarArquivo.close();
            
            System.out.println("Mensagem adicionada com sucesso ao arquivo.");
        } 
        catch (IOException e) 
        {
            System.out.println("Ocorreu um erro ao adicionar ao arquivo: " + e.getMessage());
        }
    }
}