package com.librarysystem.librarysystem.domain;

import javax.persistence.*;

@Entity
@Table(name = "issues")
public class IssueDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "issue_id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "date")
    private String date;

    @Column(name = "book_id")
    private Integer bookId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
