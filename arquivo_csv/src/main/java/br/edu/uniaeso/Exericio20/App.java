package br.edu.uniaeso.Exericio20;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class App 
{

    public static void main(String[] args) {
        try (Reader reader = Files.newBufferedReader(Paths.get("produtos.csv"))) 
        {
            CsvToBean<Produto> csvToBean = new CsvToBeanBuilder<Produto>(reader)
                .withType(Produto.class)
                .build();
            List<Produto> produtos = csvToBean.parse();

            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
