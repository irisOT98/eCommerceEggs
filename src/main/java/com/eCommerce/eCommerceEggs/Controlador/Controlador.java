package com.eCommerce.eCommerceEggs.Controlador;

import java.util.List;

import com.eCommerce.eCommerceEggs.Dominio.Products;
import com.eCommerce.eCommerceEggs.Service.ProductsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrator")
public class Controlador {

    @Autowired
    private ProductsServiceImpl productService;

    // http://localhost:8080
    @GetMapping("")
    public String home(Model model) {
        List<Products> products = productService.readProducts();
        model.addAttribute("products", products);
        return "administrator/home";
    }
}
