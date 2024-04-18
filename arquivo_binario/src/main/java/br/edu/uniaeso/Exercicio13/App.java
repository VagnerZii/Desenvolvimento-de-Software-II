package br.edu.uniaeso.Exercicio13;

import java.io.*;
import java.util.*;

public class App 
{
    public static void main(String[] args)
    {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto X", 20.0));
        produtos.add(new Produto("Produto Y", 40.0));
        produtos.add(new Produto("Produto Z", 60.0));

        try(FileOutputStream fileOut = new FileOutputStream("produtos.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(produtos);

            System.out.println("Lista de produtos serializada com sucesso!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        try (FileInputStream fileIn = new FileInputStream("produtos.dat");
        ObjectInputStream in = new ObjectInputStream(fileIn)) 
        {

            @SuppressWarnings("unchecked")
            List<Produto> produtosDeserrializados = (List<Produto>) in.readObject();

            System.out.println("Lista de produtos deserializada com sucesso.");

            for (Produto produto : produtosDeserrializados) 
            {
                System.out.println(produto);
            }
        }       
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
}
