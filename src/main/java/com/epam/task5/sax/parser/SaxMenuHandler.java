package com.epam.task5.sax.parser;

import com.epam.task5.bean.Dish;
import com.epam.task5.bean.MenuTagName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 17.02.2017.
 */
public class SaxMenuHandler extends DefaultHandler {
    private List<Dish> list = new ArrayList<Dish>();
    private Dish dish;
    private StringBuilder text;

    public List<Dish> getDishList(){
        return list;
    }

    public void startDocument() throws SAXException{
        System.out.println("PArsing started.");
    }
    public void endDocument() throws SAXException{
        System.out.print("Parsing finished.");
    }
    public void characters(char[] buffer, int start, int length){
        text.append(buffer, start, length);
    }
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        text=new StringBuilder();
        if(qName.equals("dish")){
            dish = new Dish();
            dish.setId((attributes.getValue("id")));
        }
    }
    public void endElement(String uri, String localName, String qName) throws SAXException{
        MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName){
            case NAME: dish.setName(text.toString()); break;
            case DESCRIPTION: dish.setDescription(text.toString()); break;
            case WEIGHT: dish.setWeight(text.toString()); break;
            case PRICE: dish.setPrice(Integer.parseInt(text.toString())); break;
            case DISH: list.add(dish); dish=null; break;
        }
    }

}
