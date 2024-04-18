package br.edu.uniaeso.Exercicio14;

import java.io.*;

public class App 
{
    public static void Serializable()
    {
        ContaBancaria conta = new ContaBancaria("Vagner", 150.00, 007);

        try(FileOutputStream fileOut = new FileOutputStream("conta.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(conta);

            System.out.println("Objeto serializado com sucesso!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        try(FileInputStream fileIn = new FileInputStream("conta.dat");
        ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            while(true)
            {
                try
                {
                    ContaBancaria Conta = (ContaBancaria) in.readObject();

                    System.out.println("Detalhes da conta: " + Conta);
                }
                catch(IOException | ClassNotFoundException e)
                {
                    break;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
