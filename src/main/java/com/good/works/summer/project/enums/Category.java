package com.good.works.summer.project.enums;


import java.util.ArrayList;
import java.util.List;

public enum Category {
    SHARING_KNOWLEDGE("Sharing Knowledge"),
    BEAUTIFUL_ENVIRONMENT("Beautiful Environment"),
    GIVING_BACK_TO_SOCIETY("Giving Back To Society"),
    HELPING_ANIMALS("Helping Animals");

    private String typeOfCategory;

    Category(String typeOfCategory) {
        this.typeOfCategory = typeOfCategory;
    }

    public String type() {
        return typeOfCategory;
    }

    public static List<String> categories() {
        List<String> cats = new ArrayList<>();
        for (Category cat : Category.values()) {
            cats.add(cat.type());
        }
        return cats;
    }
}
