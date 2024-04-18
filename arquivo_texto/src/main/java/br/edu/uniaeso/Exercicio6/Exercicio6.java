package br.edu.uniaeso.Exercicio6;

import java.io.*;
import java.util.*;

public class Exercicio6
{
    public static void main(String[] args)
    {
        String dadoArquivo = "dados.csv";

        try
        {
            File arquivo = new File(dadoArquivo);
            Scanner scanner = new Scanner(arquivo);

            while(scanner.hasNextLine())
            {
                String linha = scanner.nextLine();
                String[] campos = linha.split(",");

                for(String campo : campos)
                {
                    System.out.print(campo + " ");
                }
                System.out.println();
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
