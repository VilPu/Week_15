package com.example.week15;

import java.util.ArrayList;

public class ItemStorage {

    private ArrayList<Item> items = new ArrayList<>();

    private static  ItemStorage itemStorage = null;



    public static ItemStorage getInstance() {
        if (itemStorage == null) {
            itemStorage = new ItemStorage();
        }
        return itemStorage;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void deleteItemByIndex(int index) {
        items.remove(index);
    }
    public Item getItemByIndex(int index) {
        return items.get(index);
    }
}
