package com.eCommerce.eCommerceEggs.Controlador;

import java.util.ArrayList;

import com.eCommerce.eCommerceEggs.Dominio.Eggs;
import com.eCommerce.eCommerceEggs.Service.EggsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

    @Autowired
    private EggsServiceImpl eggsService;

    // http://localhost:8080
    @GetMapping("/")
    public String eggsS(Model model) {
        ArrayList<Eggs> eggs = (ArrayList<Eggs>) eggsService.listarEggs();
        model.addAttribute("eggs", eggs);
        return "administrator/home";
    }
}
