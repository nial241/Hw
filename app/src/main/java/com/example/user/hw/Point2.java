package com.example.user.hw;

import java.util.HashMap;

/**
 * Created by User on 07.11.2017.
 */

public class Point2 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getAny_map() {
        return any_map;
    }

    public void setAny_map(HashMap<String, String> any_map) {
        this.any_map = any_map;
    }

    public String to_string(){
        return "name: "+name+" any_map: "+any_map.toString();
    }

    private HashMap<String,String> any_map;


}
