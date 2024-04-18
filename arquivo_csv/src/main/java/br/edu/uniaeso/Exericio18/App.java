package br.edu.uniaeso.Exericio18;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class App 
{

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("alunos.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CsvToBean<CsvAluno> csvToBean = new CsvToBeanBuilder(reader).withType(CsvAluno.class).build();
        List<CsvAluno> pessoas = csvToBean.parse();

        for (CsvAluno pessoa : pessoas) 
        {
            System.out.println(pessoa);
        }
    }
}
