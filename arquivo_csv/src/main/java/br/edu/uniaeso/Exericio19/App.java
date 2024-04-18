package br.edu.uniaeso.Exericio19;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class App 
{
    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);

        try 
        {
            FileWriter fileWriter = new FileWriter("funcionarios.csv");

            CSVWriter csvWriter = new CSVWriter(fileWriter);

            while (true) {
                System.out.println("Digite o nome do funcionário (ou 'sair' para parar):");
                String nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("sair")) 
                {
                    break;
                }

                System.out.println("Digite o cargo do funcionário:");
                String cargo = scanner.nextLine();

                System.out.println("Digite o salário do funcionário:");
                String salario = scanner.nextLine();

                String[] linha = {nome, cargo, salario};
                csvWriter.writeNext(linha);
            }

            csvWriter.close();

            System.out.println("Os detalhes dos funcionários foram escritos no arquivo 'funcionarios.csv'");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            scanner.close();
        }
    }
}
