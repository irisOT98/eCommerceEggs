package com.eCommerce.eCommerceEggs.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="eggs")
public class Eggs implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEgg;

    @Column
    private String eggType;
    @Column
    private Long stock;
    @Column
    private Float price;

    @OneToMany
    @JoinColumn(name = "egg_id")
    private List<Eggs> eggs;

    public Eggs() {
    }

    public Long getIdEgg() {
        return this.idEgg;
    }

    public void setIdEgg(Long idEgg) {
        this.idEgg = idEgg;
    }

    public String getEggType() {
        return this.eggType;
    }

    public void setEggType(String eggType) {
        this.eggType = eggType;
    }

    public Long getStock() {
        return this.stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }  

    public List<Eggs> getEggs() {
        return this.eggs;
    }

    public void setEggs(List<Eggs> eggs) {
        this.eggs = eggs;
    }
}
