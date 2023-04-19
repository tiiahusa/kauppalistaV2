package com.example.kauppalistav2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class GroceryList {

    private static GroceryList list = null; // GroceryList singleton setting
    private ArrayList<Grocery> groceries = new ArrayList<>();
    private ArrayList<Grocery> importants = new ArrayList<>();
    private GroceryList() { // builder must be private for singleton grocery list

    }

    public static GroceryList getInstance() { // Do list if we haven't it yet
        if (list == null) {
            list = new GroceryList();
        }
        return list;
    }

    public void addGroceryToList (Grocery grocery) {
        groceries.add(grocery);
    }

    public void deleteGroceryFromList (String id) {
        int i = 0;
        for (Grocery gro: groceries) {
            if(gro.getId().equals(id)) {
                break;
            }
            i++;
        }
        groceries.remove(i);
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public ArrayList<Grocery> getImportants() {
        importants.clear(); // Tyhjää lista
        for (Grocery gro: groceries) { // Jos tärkeä, lisää listaan
            if(gro.getStar()) {
                importants.add(gro);
            }
        } return importants;
    }

    public Grocery getGroceryById (int id) {
        return groceries.get(id);
    }

}