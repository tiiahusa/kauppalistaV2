package com.example.kauppalistav2;

import android.os.Build;

import java.time.LocalDateTime;

public class Grocery {

    private String grocery;
    private String rem;
    private String id;
    private boolean star;

    public Grocery(String grocery, String rem, boolean star) {
        this.grocery = grocery;
        this.rem = rem;
        this.star = star;
        id = "NCC-" + (int)(Math.random() * 90000 + 1000);
    }

    public String getGrocery() {
        return grocery;
    }

    public String getRem() {
        return rem;
    }

    public boolean getStar() {
        return star;
    }
    public String getId() {
        return id;
    }

}
