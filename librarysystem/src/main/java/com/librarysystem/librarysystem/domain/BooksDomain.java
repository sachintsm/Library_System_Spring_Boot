package com.librarysystem.librarysystem.domain;

import javax.persistence.*;

@Entity
@Table(name="books")
public class BooksDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "book_name")
    private String name;

    @Column(name="book_stock")
    private Integer stock;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {return name;    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
