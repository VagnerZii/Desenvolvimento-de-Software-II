package br.edu.uniaeso.Exericio24;

import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class FiltroFuncionarios 
{
    private CSVReader reader;

    public FiltroFuncionarios(CSVReader reader) 
    {
        this.reader = reader;
    }

    public void filtrarPorCargo(String cargo)
    {
        List<String[]> linhas;
        boolean encontrado = false;
        try 
        {
            linhas = reader.readAll();
            for (String[] linha : linhas) {
                if (linha[1].equalsIgnoreCase(cargo)) 
                {
                    encontrado = true;
                    System.out.println("Nome: " + linha[0] + ", Cargo: " + linha[1] + ", Salário: " + linha[2]);
                }
            }
        } 
        catch (IOException | CsvException e) 
        {
            e.printStackTrace();
        }


        if (!encontrado) 
        {
            System.out.println("Nenhum funcionário encontrado com o cargo informado.");
        }
    }

    public void filtrarPorSalario(double salarioMinimo)
    {
        List<String[]> linhas;
        boolean encontrado = false;
        try {
            linhas = reader.readAll();
            for (String[] linha : linhas) 
            {
                double salario = Double.parseDouble(linha[2]);
                if (salario >= salarioMinimo) 
                {
                    encontrado = true;
                    System.out.println("Nome: " + linha[0] + ", Cargo: " + linha[1] + ", Salário: " + linha[2]);
                }
            }
        } 
        catch (IOException | CsvException e) 
        {
            e.printStackTrace();
        }

        if (!encontrado) 
        {
            System.out.println("Nenhum funcionário encontrado com o salário mínimo informado.");
        }
    }
}

