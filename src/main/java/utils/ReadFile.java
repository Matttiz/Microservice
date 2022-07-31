package utils;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile {


    @SneakyThrows
    public static String read(File file){
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String content = new String();
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
            content += line;
        }
        return content;
    };
}
