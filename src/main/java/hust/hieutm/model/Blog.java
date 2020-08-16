package hust.hieutm.model;

import java.io.Serializable;
import java.sql.Date;

public class Blog{

    private int id;
    private String name;
    private String title;
    private String author;
    private String type;
    private String description;
    private String content;
    private Date date;

    public Blog(){}

    public Blog(String name, String title, String author, String type, String description, String content, Date date) {
        this.name = name;
        this.title = title;
        this.author = author;
        this.type = type;
        this.description = description;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
