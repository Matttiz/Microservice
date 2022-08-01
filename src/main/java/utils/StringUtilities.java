package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtilities {


    public static List<List<String>> createListOfLists(String content){
        List<List<String>> listOfLists =  new ArrayList<>();
        List<String> list = Arrays.stream(content.split("\n")).toList();
        List<String> row = new ArrayList<>();
        for(String line : list){
            System.out.println(line);
            if(!line.isEmpty()){
                row.add(line);
            }else{
                listOfLists.add(row);
                row = new ArrayList<>();
            }
        }
        return listOfLists;
    }
}
