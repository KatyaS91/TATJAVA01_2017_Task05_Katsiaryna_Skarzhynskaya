package com.epam.task5.dom.parser;

import com.epam.task5.bean.Dish;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 17.02.2017.
 */
public class DomDemoParser {
    private final static String FILE_PATH = "C:\\Users\\User\\IdeaProjects\\Task5\\src\\main\\java\\com\\epam\\task5\\menu.xml";


    public static void main(String[] args){

        DOMParser parser = new DOMParser();
        try {
            parser.parse(FILE_PATH);
        } catch (org.xml.sax.SAXException e) {
            System.out.println("dom error");
        } catch (IOException e){
            System.out.println("dom error");
        }

        Document document = parser.getDocument();
        Element root = document.getDocumentElement();

        ArrayList<Dish> foodList;
        HashMap<String, ArrayList<Dish>> menu = new HashMap<String, ArrayList<Dish>>();
        String type = null;
        Dish dish= null;

        NodeList typeNodes = root.getElementsByTagName("course");

        for (int i = 0; i < typeNodes.getLength(); i++) {

            foodList = new ArrayList<Dish>();
            Element typeElement = (Element) typeNodes.item(i);
            type = typeElement.getAttribute("id");

            NodeList foodNodes = typeElement.getElementsByTagName("dish");
            for (int j = 0; j < foodNodes.getLength(); j++) {

                Element foodElement = (Element) foodNodes.item(j);

                dish = foodCreator(foodElement);

                foodList.add(dish);
            }

            menu.put(type, foodList);
        }

        System.out.println(menu.toString());

    }

    private static Dish foodCreator(Element foodElement) {
        Dish food = new Dish();
        food.setId(foodElement.getAttribute("id"));
        food.setName(getSingleChild(foodElement, "name").getTextContent().trim());
        food.setDescription(getSingleChild(foodElement, "description").getTextContent().trim());
        food.setWeight(getSingleChild(foodElement, "weight").getTextContent().trim());
        if (getSingleChild(foodElement, "price").getTextContent().length() > 0){
            food.setPrice(Integer.parseInt(getSingleChild(foodElement, "price").getTextContent()));
        }
        return food;
    }

    private static Element getSingleChild(Element element, String childName){
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

}
