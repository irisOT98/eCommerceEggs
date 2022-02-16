package com.eCommerce.eCommerceEggs.Service;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.eCommerce.eCommerceEggs.Dao.UserDao;
import com.eCommerce.eCommerceEggs.Dominio.Roles;
import com.eCommerce.eCommerceEggs.Dominio.Users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {

/*     @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Autowired
    HttpSession session;

    private Logger log = LoggerFactory.getLogger(UsersService.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Este es el username");
        Optional<Users> optUser = userService.findByEmail(username);
        if(optUser.isPresent()) {
            log.info("Este es el id del user: {}", optUser.get().getIdUsuario());
            session.setAttribute("iduser", optUser.get().getIdUsuario());
            Users user = optUser.get();
            return User.builder().username(user.getUsername()).password(bCrypt.encode(user.getPassword())).roles(user.getType()).build();
        }
        else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    } */
    
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