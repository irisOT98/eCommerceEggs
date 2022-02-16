package com.eCommerce.eCommerceEggs.Dao;

import java.util.Optional;

import com.eCommerce.eCommerceEggs.Dominio.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users,Long> {

    Users findByUsername(String username);

    Optional<Users> findByEmail(String email);
}
