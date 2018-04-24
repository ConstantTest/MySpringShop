package com.alex.spring.dao.model;

import java.math.BigDecimal;

/**
 * Created by Alex on 24.04.2018.
 */
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private Size size;
    private Color color;
    private Gender gender;

    public Product(Long id, String name, BigDecimal price, Size size, Color color, Gender gender) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.gender = gender;
    }

    public enum Size {S, M, L, XL, XXL}
    public enum Color {WHITE, RED, GREEN, GREY, PINK, BLUE, BLACK}
    public enum Gender {FEMALE, MALE, UNISEX}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", color=" + color +
                ", gender=" + gender +
                '}';
    }
}
