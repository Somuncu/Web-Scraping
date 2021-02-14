package com.company;

public class Products {
    private String id;
    private String title;
    private String description;
    private String imageUri;
    private String datePublished;
    private String productCategory;
    private String color;
    private Double price;
    private Boolean discount;
    private Double oldprice;


    public Products(String id, String title, String description, String imageUri, String datePublished, String productCategory, String color, Double price, Boolean discount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUri = imageUri;
        this.datePublished = datePublished;
        this.productCategory = productCategory;
        this.color = color;
        this.price = price;
        this.discount = discount;
    }


    public Products() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }

    public Double getOldprice() {
        return oldprice;
    }

    public void setOldprice(Double oldprice) {
        this.oldprice = oldprice;
    }
}
