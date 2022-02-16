package com.eCommerce.eCommerceEggs.Dao;

import com.eCommerce.eCommerceEggs.Dominio.Eggs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EggsDao extends JpaRepository<Eggs, Long> {

}
