package utils;

import lombok.SneakyThrows;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.odf.OpenDocumentParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;

public class ODSReader {

    @SneakyThrows
    public static String read(File file){
        BodyContentHandler handler
                = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputStream
                = new FileInputStream(
                file);
        ParseContext parseContent = new ParseContext();
        OpenDocumentParser opendocumentparser
                = new OpenDocumentParser();
        opendocumentparser.parse(inputStream, handler,
                metadata,
                parseContent);
        String content = handler.toString();
        return leftOnlyRelevantData(content);
    }

    private static String leftOnlyRelevantData(String content){
        content = content.replaceAll("[?]{3}\nStrona \n", "");
        String startHeaderLine = "\tline";
        String endHeaderLine = "service\n";
        String header = content.substring(
                content.indexOf(startHeaderLine),
                content.indexOf(endHeaderLine) + endHeaderLine.length()
        );
        content = content.replaceAll(header, "");
        content = content.replaceAll("\t","");
        content = content.trim();
        content = content.substring(0, content.indexOf("\nline\n"));
        return content;
    }
}
