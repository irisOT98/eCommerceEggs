package com.eCommerce.eCommerceEggs.Service;

import java.util.List;
import java.util.Optional;

import com.eCommerce.eCommerceEggs.Dao.UserDao;
import com.eCommerce.eCommerceEggs.Dominio.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
	private UserDao userDao;

    @Override
    @Transactional(readOnly=true)
    public List<Users> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Users> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public Users save(Users user) {
        return userDao.save(user);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Users> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}