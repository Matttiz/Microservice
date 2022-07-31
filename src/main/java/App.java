import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.odf.OpenDocumentParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;

    public class App {
        public static void main(String[] args)
        {

            try {
                BodyContentHandler handler
                        = new BodyContentHandler();

                Metadata metadata = new Metadata();

                String path = System.getProperty("user.dir") + "/src/main/resources/line/Example_A.ods";
//                String path = System.getProperty("user.dir") + "/src/main/resources/line/Example.ods";
                File file = new File(path);

                // Here .odt is open document text format.
                FileInputStream inputstream
                        = new FileInputStream(
                        file);
                ParseContext parsecontent = new ParseContext();

                // Parsing the open document.
                OpenDocumentParser opendocumentparser
                        = new OpenDocumentParser();

                // Passing the InputStream , ContentHandler,
                // Metadata , ParseContext to the parse method.
                opendocumentparser.parse(inputstream, handler,
                        metadata,
                        parsecontent);
                System.out.println("Content in the document :"
                        + handler.toString());

                // Displaying the metadata of the odf file.
                System.out.println("Metadata of the document:");
                String[] metaName = metadata.names();
                int l = metaName.length;
                for (int i = 0; i < l; i++) {
                    System.out.println(
                            metaName[i]
                                    + " : =  " + metadata.get(metaName[i]));
                }
            }
            catch (Exception e) {

                System.out.println(
                        "failed to extract content due to " + e);
            }
        }
    }
