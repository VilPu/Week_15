package com.example.week15;

import java.util.Comparator;
import java.util.Date;

public class Item {
    private String name;
    private String info;
    private Date timeOfCreation;

    public Item(String name, String info, Date timeOfCreation) {
        this.name = name;
        this.info = info;
        this.timeOfCreation = timeOfCreation;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public Date getTimeOfCreation() {
        return timeOfCreation;
    }

    public String getInfo() {
        return info;
    }

    public static Comparator<Item> itemTimeComparator = new Comparator<Item>() {
        @Override
        public int compare(Item item1, Item item2) {
            Date timeFromItem1 = item1.getTimeOfCreation();
            Date timeFromItem2 = item2.getTimeOfCreation();
            return timeFromItem1.compareTo(timeFromItem2);
        }
    };

    public static Comparator<Item> itemAlphabetComparator = new Comparator<Item>() {
        @Override
        public int compare(Item item1, Item item2) {
            String nameOfItem1 = item1.getName().toUpperCase();
            String nameOfItem2 = item2.getName().toUpperCase();
            return nameOfItem1.compareTo(nameOfItem2);
        }
    };
}
