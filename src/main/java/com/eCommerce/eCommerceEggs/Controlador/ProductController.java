package com.eCommerce.eCommerceEggs.Controlador;

import java.util.ArrayList;

import com.eCommerce.eCommerceEggs.Dominio.Products;
import com.eCommerce.eCommerceEggs.Service.ProductsServiceImpl;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductsServiceImpl productService;

    @GetMapping("")
    public String show(Model model){
        ArrayList<Products> products = (ArrayList<Products>) productService.readProducts();
        model.addAttribute("products", products);
        return "products/show";
    }

    @GetMapping("/create")
    public String create(Products products){
        return "products/create";
    }

    @PostMapping("/save")
	public String save(Products product) {
		//LOGGER.info("Este es el objeto producto {}",product);	
        productService.saveP(product);
        return "redirect:/products";
	}

    @PostMapping("/update")
	public String update(Products product) {
		productService.update(product);		
		return "redirect:/products";
	}

    @GetMapping("/edit/{idProduct}")
    public String edit(@PathVariable Long idProduct, Model model){
        Products product = productService.encontrarProducts(idProduct);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @GetMapping("/delete/{idProduct}")
    public String delete(@PathVariable Long idProduct){        
        productService.deleteP(idProduct);
        return "redirect:/products";
    }
}