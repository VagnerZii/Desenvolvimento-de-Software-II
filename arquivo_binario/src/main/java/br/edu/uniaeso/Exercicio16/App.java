package br.edu.uniaeso.Exercicio16;

import java.io.*;

public class App 
{
    public static void main(String[] args) 
    {
        int tamanhoLeitura = 100;

        try (FileInputStream fileIn = new FileInputStream("arquivo.bin")) 
        {
            byte[] buffer = new byte[tamanhoLeitura];
            int bytesLidos = fileIn.read(buffer);

            if (bytesLidos != -1) {
                System.out.println("Bytes lidos: ");
                for (int i = 0; i < bytesLidos; i++) 
                {
                    System.out.print((char) buffer[i]);
                }
                System.out.println();
            } 
            else 
            {
                System.out.println("Nenhum byte foi lido do arquivo.");
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

