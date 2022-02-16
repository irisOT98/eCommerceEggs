package com.eCommerce.eCommerceEggs.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.eCommerce.eCommerceEggs.Dominio.Products;
import com.eCommerce.eCommerceEggs.Dominio.Sells;
import com.eCommerce.eCommerceEggs.Dominio.SellsDetails;
import com.eCommerce.eCommerceEggs.Service.ProductsServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {


    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductsServiceImpl productService;

    // Almacenar los detalles de la venta 
    List<SellsDetails> details = new ArrayList<SellsDetails>();

    // Datos de la venta
    Sells sell = new Sells();

    @GetMapping("")
    public String home(Model model){
        ArrayList<Products> products = (ArrayList<Products>) productService.readProducts();
        model.addAttribute("products", products);
        return "user/home";
    }

    @GetMapping("productHome/{idProduct}")
    public String productHome(@PathVariable Long idProduct, Model model){
        Products product = productService.encontrarProducts(idProduct);
        model.addAttribute("product", product);
        return "user/productoHome";
    }

    @PostMapping("/cart")
    public String addCart(@RequestParam Long idProduct, @RequestParam Float quantity, Model model){
        SellsDetails sellDetails = new SellsDetails();
        Products products = new Products();
        float sumTot = 0;

        Optional<Products> optionalProducto = productService.get(idProduct);
		log.info("Producto añadido: {}", optionalProducto.get());
		log.info("Cantidad: {}", quantity);
		products = optionalProducto.get();

        sellDetails.setQuantity(quantity);
        sellDetails.setPrice(products.getPrice());
        sellDetails.setName(products.getNameProduct());
		sellDetails.setTotal(products.getPrice() * quantity);
		sellDetails.setProducts(products);

        details.add(sellDetails);

        sumTot = (float) details.stream().mapToDouble(dt -> dt.getTotal()).sum();

        sell.setTotal(sumTot);
		model.addAttribute("cart", details);
		model.addAttribute("sell", sell);

        return "user/carrito";
    }
}
