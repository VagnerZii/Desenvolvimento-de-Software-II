package br.edu.uniaeso.Exercicio11;

import java.io.*;

public class App 
{
    public static void main(String[] args)
    {
        Pessoa pessoa = new Pessoa("Vagner", 19);

        try(FileOutputStream fileOut = new FileOutputStream("pessoa.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(pessoa);

            System.out.println("Objeto serializado com sucesso!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
