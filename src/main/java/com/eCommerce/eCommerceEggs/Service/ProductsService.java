package com.eCommerce.eCommerceEggs.Service;

import java.util.List;
import java.util.Optional;

import com.eCommerce.eCommerceEggs.Dominio.Products;

public interface ProductsService {

    public List<Products> readProducts();

    public void saveP(Products product);

    public void deleteP(Long id);

    public Products encontrarProducts(Long id);

    public void update(Products product);

    public Optional<Products> get(Long id);
}
