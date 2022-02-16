package com.eCommerce.eCommerceEggs.Controlador;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.eCommerce.eCommerceEggs.Dominio.Users;
import com.eCommerce.eCommerceEggs.Service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {
    
    private final Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImpl userService;

/*     @Autowired
	private BCryptPasswordEncoder pswdEncode = new BCryptPasswordEncoder(); */

    // /user/registro
	@GetMapping("/register")
	public String create() {
		return "user/registro";
    }

    @PostMapping("/save")
    public String save(Users user) {
        logger.info("Usuario registro: {}", user);
        user.setType("USER");
/*         user.setPassword(pswdEncode.encode(user.getPassword())); */
        userService.save(user);
		return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/singUp")
    public String singUp(Users user, HttpSession session) {
        logger.info("Accesos: {}", user);

        Optional<Users> us = userService.findByEmail(user.getEmail());
        //logger.info("Usuario de DB: {}", us.get());

        if(us.isPresent()) {
            session.setAttribute("iduser", us.get().getIdUsuario());
            if(us.get().getType().equals("ADMIN")){
                return "redirect:/administrator";
            }
            else {
                return "redirect:/"; 
            }
        }
        else {
            logger.info("Usuario no existe");
        }
        return "redirect:/";
    }

    @GetMapping("/end")
    public String endSession(HttpSession session){
        session.removeAttribute("iduser");
        return "redirect:/";
    }
}
