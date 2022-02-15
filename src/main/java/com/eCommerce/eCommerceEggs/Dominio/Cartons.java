package com.eCommerce.eCommerceEggs.Dominio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "cartons")
public class Cartons implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarton;

    @Column
    private String cartonSize;
    @Column
    private Long cartonCapacity;

    @ManyToOne
    @JoinColumn(name = "egg_id")
    private Eggs egg;

    public Cartons() {
    }

    public Cartons(Long idCarton, String cartonSize, Long cartonCapacity, Eggs egg) {
        this.idCarton = idCarton;
        this.cartonSize = cartonSize;
        this.cartonCapacity = cartonCapacity;
        this.egg = egg;
    }

    public Long getIdCarton() {
        return this.idCarton;
    }

    public void setIdCarton(Long idCarton) {
        this.idCarton = idCarton;
    }

    public String getCartonSize() {
        return this.cartonSize;
    }

    public void setCartonSize(String cartonSize) {
        this.cartonSize = cartonSize;
    }

    public Long getCartonCapacity() {
        return this.cartonCapacity;
    }

    public void setCartonCapacity(Long cartonCapacity) {
        this.cartonCapacity = cartonCapacity;
    }

    public Eggs getEgg() {
        return this.egg;
    }

    public void setEgg(Eggs egg) {
        this.egg = egg;
    }
}
