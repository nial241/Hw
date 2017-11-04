package com.example.user.hw;

import java.util.HashMap;

/**
 * Created by User on 04.11.2017.
 */

public class Point1and2 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getAny_map() {
        return any_map;
    }

    public void setAny_map(HashMap<String, Integer> any_map) {
        this.any_map = any_map;
    }

    public String to_string(){
        return name+" "+any_map.toString();
    }
    private HashMap<String,Integer> any_map;

}
