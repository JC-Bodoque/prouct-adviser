package com.company.myapplication;

import java.io.Serializable;

public class Product implements Serializable {
    String productId;
    String productName;
    String description;
    double price;

    /**
     * Constructor de la clase <code>Product</code>
     *
     * @param description descipcion del producto
     * @param productId   identificador del producto
     * @param productName nombre del producto
     * @param price       precio del producto
     */
    public Product(String productId, String productName, String description, double price) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    /**
     * @return identificador del producto
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId identificador por establecer
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return nombre del producto
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName nombre del producto por establecer
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return descripcion del producto
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}