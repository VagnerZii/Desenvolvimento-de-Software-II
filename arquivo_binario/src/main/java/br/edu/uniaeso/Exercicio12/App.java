package br.edu.uniaeso.Exercicio12;

import java.io.*;

public class App 
{
    public static void main(String[] args) 
    {
        
        Pessoa pessoa = new Pessoa("Vagner", 18);
        serializarObjeto(pessoa);

        Pessoa pessoaDeserializada = deserializarObjeto();
        if (pessoaDeserializada != null) 
        {
            System.out.println("Detalhes da Pessoa:");
            System.out.println("Nome: " + pessoaDeserializada.getNome());
            System.out.println("Idade: " + pessoaDeserializada.getIdade());
        } 
        else 
        {
            System.out.println("Erro: Não foi possível deserializar o objeto.");
        }
    }

    private static void serializarObjeto(Pessoa pessoa) 
    {
        try 
        {
            FileOutputStream arquivoSaida = new FileOutputStream("pessoa.dat");
            ObjectOutputStream objetoSaida = new ObjectOutputStream(arquivoSaida);
            objetoSaida.writeObject(pessoa);
            objetoSaida.close();
            arquivoSaida.close();
            System.out.println("Objeto Pessoa serializado com sucesso.");
        } 
        catch (IOException e) {
            System.out.println("Erro ao serializar objeto: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static Pessoa deserializarObjeto() 
    {
        Pessoa pessoaDeserializada = null;
        try 
        {
            FileInputStream arquivoEntrada = new FileInputStream("pessoa.dat");
            ObjectInputStream objetoEntrada = new ObjectInputStream(arquivoEntrada);
            pessoaDeserializada = (Pessoa) objetoEntrada.readObject();
            objetoEntrada.close();
            arquivoEntrada.close();
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            System.out.println("Erro ao deserializar objeto: " + e.getMessage());
            e.printStackTrace();
        }
        return pessoaDeserializada;
    }
}
