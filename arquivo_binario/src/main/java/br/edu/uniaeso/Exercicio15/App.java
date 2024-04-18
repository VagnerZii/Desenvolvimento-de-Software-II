package br.edu.uniaeso.Exercicio15;

import java.io.*;

public class App 
{

    private static final int TAMANHO_BUFFER = 8192;

    public static void main(String[] args) 
    {
        copiarArquivoBinario("arquivo_grande.bin", "copia_arquivo_grande.bin");
    }

    public static void copiarArquivoBinario(String origem, String destino) 
    {
        try (FileInputStream arquivoOrigem = new FileInputStream(origem);
             FileOutputStream arquivoDestino = new FileOutputStream(destino)) 
             {
            byte[] buffer = new byte[TAMANHO_BUFFER];
            int bytesLidos;
            while ((bytesLidos = arquivoOrigem.read(buffer)) != -1) 
            {
                arquivoDestino.write(buffer, 0, bytesLidos);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}