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
        FileInputStream inputstream
                = new FileInputStream(
                file);
        ParseContext parsecontent = new ParseContext();
        OpenDocumentParser opendocumentparser
                = new OpenDocumentParser();
        opendocumentparser.parse(inputstream, handler,
                metadata,
                parsecontent);
        return handler.toString();
    }
}
