package com.eCommerce.eCommerceEggs.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="sells")
public class Sells implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSell;

    @Column
    private Float cartonsQuantity;
    @Column
    private Float total;
    @Column
    private String sellDate;

    @OneToMany
    @JoinColumn(name = "egg_id")
    private List<Eggs> eggs;

    public Sells() {
    }

    public Long getIdSell() {
        return this.idSell;
    }

    public void setIdSell(Long idSell) {
        this.idSell = idSell;
    }

    public Float getCartonsQuantity() {
        return this.cartonsQuantity;
    }

    public void setCartonsQuantity(Float cartonsQuantity) {
        this.cartonsQuantity = cartonsQuantity;
    }

    public Float getTotal() {
        return this.total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getSellDate() {
        return this.sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public List<Eggs> getEggs() {
        return this.eggs;
    }

    public void setEggs(List<Eggs> eggs) {
        this.eggs = eggs;
    }
}
