/*
package com.epam.task5.stax.parser;


import com.epam.task5.bean.Dish;
import com.epam.task5.bean.MenuTagName;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxDemoParser {
    private final static String FILE_PATH = "C:\\Users\\User\\IdeaProjects\\Task5\\src\\main\\java\\com\\epam\\task5\\menu.xml";

    public static void main(String[] args) throws FileNotFoundException{
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream(FILE_PATH);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

            List<Dish> menu = process(reader);
            for (Dish dish : menu){
                System.out.println(dish.getName());
                System.out.println(dish.getDescription());
            }
        } catch (XMLStreamException e){
            System.out.println("error stax");
        }

    }

*/
/*
    elementName = MenuTagName.valueOf(reader.getLocalName().toUpperCase());
*//*


    private static List<Dish> process(XMLStreamReader reader) throws XMLStreamException{
        List<Dish> menu = new ArrayList<Dish>();
        Dish dish = null;
        MenuTagName elementName=null;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT: elementName=MenuTagName.valueOf(reader.getLocalName().toUpperCase());
                switch (elementName){
                    case COURSE: menu = new ArrayList<Dish>();
                    type = reader.getAttributeValue(null,"id");
                    case DISH:dish=new Dish();
                    Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                    dish.setId(id.toString());
                    break;
                }
            break;
                case XMLStreamConstants.CHARACTERS:
                    String text  = reader.getText().trim();
                    if (text.isEmpty()){
                        break;
                    }
                    switch (elementName){
                        case NAME: dish.setName(text); break;
                        case DESCRIPTION: dish.setDescription(text); break;
                        case PRICE:
                            Integer price = Integer.parseInt(text);
                            dish.setPrice(price); break;
                        case WEIGHT: dish.setWeight(text); break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT: elementName = MenuTagName.valueOf(reader.getLocalName().toUpperCase());
                switch (elementName){
                    case DISH: menu.add(dish);
                }
            }
        }
        return menu;
    }

}
*/
