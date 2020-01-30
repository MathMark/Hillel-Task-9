package com.hillel.mvc.springboot.model;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
    MALE, FEMALE;

    private static Map<String, Gender> map = new HashMap<>();

    static {
        for(Gender gender : Gender.values()){
            map.put(gender.toString().toLowerCase(), gender);
        }
    }
    public static Gender fromString(String name){
        return map.get(name);
    }
}
