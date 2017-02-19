package com.epam.task5.bean;

/**
 * Created by User on 17.02.2017.
 */
public class Dish {

    private String name;
    private String description;
    private String weight;
    private String id;
    private int price;

    public Dish() {
    }

    public Dish(String name, String description, String weight, String id, int price) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (price != dish.price) return false;
        if (!name.equals(dish.name)) return false;
        if (!description.equals(dish.description)) return false;
        if (weight != null ? !weight.equals(dish.weight) : dish.weight != null) return false;
        return id.equals(dish.id);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + id.hashCode();
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weight='" + weight + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
