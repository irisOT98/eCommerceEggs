package com.eCommerce.eCommerceEggs.Dominio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column
    private String nameProduct;
    @Column
    private String description;
    @Column
    private Integer quantity;
    @Column
    private Float price;
    @Column
    private String cartonSize;
    @Column
    private Integer cartonCapacity;
    @Column
    private String image;

    
    public Products() {
    }

    public Products(Long idProduct, String nameProduct, String description, Integer quantity, Float price, String cartonSize, Integer cartonCapacity, String image) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.cartonSize = cartonSize;
        this.cartonCapacity = cartonCapacity;
        this.image = image;
    }


    public Long getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCartonSize() {
        return this.cartonSize;
    }

    public void setCartonSize(String cartonSize) {
        this.cartonSize = cartonSize;
    }

    public Integer getCartonCapacity() {
        return this.cartonCapacity;
    }

    public void setCartonCapacity(Integer cartonCapacity) {
        this.cartonCapacity = cartonCapacity;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }   
    
}
