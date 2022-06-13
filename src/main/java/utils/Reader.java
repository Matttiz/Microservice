package utils;

import lombok.SneakyThrows;
import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Range;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    @SneakyThrows
    public  List<ArrayWithHeader> readODS(File file){
        SpreadSheet  spreadsheet = SpreadSheet.createFromFile(file);
        List<ArrayWithHeader> list = new ArrayList<>();
        for(int i=0; i<spreadsheet.getSheetCount(); i++){
            Sheet sheet = spreadsheet.getSheet(i);
            ArrayWithHeader arrayWithHeader = new ArrayWithHeader(getData(sheet));
            list.add(arrayWithHeader);
        }
        return  list;
    }

    private List<List<String>> getData(Sheet sheet){
        Range range= sheet.getUsedRange();
        int nColCount = range.getEndPoint().x;
//        int nRowCount = sheet.getRowCount();
        int nRowCount = range.getEndPoint().x;
        MutableCell cell = null;
        List<String> rowContent = null;
        List<List<String>> content = new ArrayList<>();
        for(int row = 0; row < nRowCount; row++) {
            rowContent = new ArrayList<>();
            for(int col = 0; col < nColCount; col++){
                cell = sheet.getCellAt(col, row);
                rowContent.add(cell.getTextValue());
            }
            content.add(rowContent);
        }
        return content;
    }


}
