package br.edu.uniaeso.Exericio18;

public class CsvAluno 
{

    String nome;
    float nota;
    int idade;

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public float getNota() 
    {
        return nota;
    }

    public void setNota(float nota) 
    {
        this.nota = nota;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) 
    {
        this.idade = idade;
    }

    @Override
    public String toString() 
    {
        return "Aluno [nome = " + nome + ", nota = " + nota + ", idade = " + idade + "]";
    }

}
