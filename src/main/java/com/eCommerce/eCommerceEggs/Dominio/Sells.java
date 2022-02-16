package com.eCommerce.eCommerceEggs.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

public class Sells implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSell;

    @Column
    private String num;
    @Column
    private String creation;
    @Column
    private String receive;
    @Column
    private Float total;

    public Sells() {
    }

    public Sells(Long idSell, String num, String creation, String receive, Float total) {
        this.idSell = idSell;
        this.num = num;
        this.creation = creation;
        this.receive = receive;
        this.total = total;
    }

    public Long getIdSell() {
        return this.idSell;
    }

    public void setIdSell(Long idSell) {
        this.idSell = idSell;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCreation() {
        return this.creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getReceive() {
        return this.receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public Float getTotal() {
        return this.total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
            " idSell='" + getIdSell() + "'" +
            ", num='" + getNum() + "'" +
            ", creation='" + getCreation() + "'" +
            ", receive='" + getReceive() + "'" +
            ", total='" + getTotal() + "'" +
            "}";
    }

}