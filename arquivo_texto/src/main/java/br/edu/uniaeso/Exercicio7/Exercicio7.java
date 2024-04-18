package br.edu.uniaeso.Exercicio7;

import java.io.*;
import java.util.*;

public class Exercicio7 
{
    public static void main(String[] args) 
    {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_ordenado.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida))) {

            List<String> linhas = new ArrayList<>();

            String linha;
            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha); 
                
            }

            Collections.sort(linhas);

            for (String linhaOrdenada : linhas) 
            {
                escritor.write(linhaOrdenada);
                escritor.newLine(); 
            }

            System.out.println("Linhas ordenadas e salvas em " + arquivoSaida);

        } 
        catch (IOException e) 
        {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}

