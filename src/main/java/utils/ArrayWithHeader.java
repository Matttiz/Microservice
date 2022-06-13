package utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ArrayWithHeader {
    @Getter
    @Setter
    public List<String> header = new ArrayList<>();

    @Getter
    @Setter
    public List<List<String>> contents = new ArrayList<>();

    public ArrayWithHeader(List<List<String>> list) {
        header = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            contents.add(list.get(i));
        }
    }
}
