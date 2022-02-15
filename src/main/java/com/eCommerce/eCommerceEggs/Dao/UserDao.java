package com.eCommerce.eCommerceEggs.Dao;

import com.eCommerce.eCommerceEggs.Dominio.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users,Long> {

    Users findByUsername(String username);
}
