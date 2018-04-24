package com.alex.spring.services.dto;

/**
 * Created by Alex on 24.04.2018.
 */
public class ProductDto {
    private String name;
    private String price;
    private String size;
    private String color;
    private String gender;

    public ProductDto(String name, String price, String size, String color, String gender) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
