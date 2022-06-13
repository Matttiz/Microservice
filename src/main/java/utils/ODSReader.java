package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class ODSReader {
    public void readODS(File file)
    {
        SpreadSheet spreadsheet;
        try {
            //Getting the 0th sheet for manipulation| pass sheet name as string

            spreadsheet = SpreadSheet.createFromFile(file);

            //Get row count and column count
            int nColCount = spreadsheet.getSheet(0).getColumnCount();
            int nRowCount = spreadsheet.getSheet(0).getRowCount();

            System.out.println("Rows :"+nRowCount);
            System.out.println("Cols :"+nColCount);
            //Iterating through each row of the selected sheet
            MutableCell cell = null;
            for(int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++)
            {
                //Iterating through each column
                for(int nColIndex = 0; nColIndex < nColCount; nColIndex++)
                {
                    cell = spreadsheet.getSheet(0).getCellAt(nColIndex, nRowIndex);
                    System.out.print(cell.getValue()+ " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //Creating File object of .ods file
        String path = System.getProperty("user.dir") + "/src/main/resources/line/Example_13.ods";
        File file = new File(path);
        ODSReader objODSReader = new ODSReader();
        objODSReader.readODS(file);

    }
}