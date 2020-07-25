package com.example.libraryfrontend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
//
//    @JsonProperty("id")
//    public Integer id;
//
//    @JsonProperty("name")
//    public String name;
//
//    @JsonProperty("stock")
//    public Integer stock;

    public Book( String name, String author, int stock) {
//        this.id = id;
        this.name = name;
        this.author = author;
        this.stock = stock;
    }

//    private Integer id;
    private String name;
    private String author;
    private Integer stock;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}