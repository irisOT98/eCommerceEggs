package com.eCommerce.eCommerceEggs.Dao;

import com.eCommerce.eCommerceEggs.Dominio.Eggs;

import org.springframework.data.repository.CrudRepository;

public interface EggsDao extends CrudRepository<Eggs, Long> {
    
}
