package com.eCommerce.eCommerceEggs.Service;

import java.util.List;

import com.eCommerce.eCommerceEggs.Dominio.Products;

public interface ProductsService {

    public List<Products> readProducts();

    public void saveP(Products product);

    public void deleteP(Long id);

    public Products encontrarProducts(Long id);
}
