package com.epam.task5.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 17.02.2017.
 */
public class Menu {
    List<Dish> list = new ArrayList<Dish>();

    public List<Dish> getList() {
        return list;
    }

    public void setList(List<Dish> list) {
        this.list = list;
    }

    public void add(Dish dish) {
        list.add(dish);
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Menu{" +
                "list=" + list +
                '}';
    }
}
