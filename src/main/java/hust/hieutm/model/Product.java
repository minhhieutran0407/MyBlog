package hust.hieutm.model;

import java.sql.Date;

public class Product {
    private int id;
    private String name;
    private String productType;
    private Date releaseDate;
    private String image;

    public Product() {
    }

    public Product(String name, String productType, Date releaseDate, String image) {
        this.name = name;
        this.productType = productType;
        this.releaseDate = releaseDate;
        this.image = image;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
