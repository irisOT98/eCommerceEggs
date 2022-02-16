package com.eCommerce.eCommerceEggs.Service;

import java.util.List;
import java.util.Optional;

import com.eCommerce.eCommerceEggs.Dominio.Users;

public interface IUserService {
    List<Users> findAll();
	Optional<Users> findById(Long id);
	Users save (Users user);
	Optional<Users> findByEmail(String email);
}
