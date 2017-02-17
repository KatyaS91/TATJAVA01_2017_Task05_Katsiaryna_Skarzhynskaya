package com.epam.task5.sax.parser;

import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Created by User on 17.02.2017.
 */
public class DemoSaxParser {

   private final static String FILE_PATH = "C:\\Users\\User\\IdeaProjects\\Task5\\src\\main\\java\\com\\epam\\task5\\menu.xml";

    public static void main(String[] args) {

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SaxMenuHandler handler = new SaxMenuHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(FILE_PATH));
            System.out.println(handler.getDishList());
        } catch (SAXException e){
            System.out.println("Main error");
        } catch (IOException e){
            System.out.println("Main error");
        }
    }

}
