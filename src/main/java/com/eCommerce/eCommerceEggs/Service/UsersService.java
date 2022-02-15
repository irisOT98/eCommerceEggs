package com.eCommerce.eCommerceEggs.Service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.eCommerce.eCommerceEggs.Dao.UserDao;
import com.eCommerce.eCommerceEggs.Dominio.Roles;
import com.eCommerce.eCommerceEggs.Dominio.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UsersService implements UserDetailsService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDao.findByUsername(username);
    
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        for(Roles rol: user.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return new User(user.getUsername(),user.getPassword(),roles);
    }
}