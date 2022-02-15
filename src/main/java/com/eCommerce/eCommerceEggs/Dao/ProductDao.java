package com.eCommerce.eCommerceEggs.Dao;

import com.eCommerce.eCommerceEggs.Dominio.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Products,Long> {
    
}
