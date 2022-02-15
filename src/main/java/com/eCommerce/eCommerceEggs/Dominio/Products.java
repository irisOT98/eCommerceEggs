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
    private Long quantity;
    @Column
    private Float price;

    @ManyToOne
    @JoinColumn(name = "carton_id")
    private Cartons carton;

    public Products() {
    }

    public Products(Long idProduct, String nameProduct, String description, Long quantity, Float price, Cartons carton) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.carton = carton;
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

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Cartons getCarton() {
        return this.carton;
    }

    public void setCarton(Cartons carton) {
        this.carton = carton;
    }
}
