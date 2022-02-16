package com.eCommerce.eCommerceEggs.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="sellsdtls")
public class SellsDetails implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSellDtls;

    @Column
    private String name;
    @Column
    private Float quantity;
    @Column
    private Float price;
    @Column
    private Float total;
    
    @ManyToOne
	private Products products;

    public SellsDetails() {
    }

    public SellsDetails(Long idSellDtls, String name, Float quantity, Float price, Float total, Products products) {
        this.idSellDtls = idSellDtls;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.products = products;
    }

    public Long getIdSellDtls() {
        return this.idSellDtls;
    }

    public void setIdSellDtls(Long idSellDtls) {
        this.idSellDtls = idSellDtls;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotal() {
        return this.total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Products getProducts() {
        return this.products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
