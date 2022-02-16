package com.eCommerce.eCommerceEggs.Service;

import java.util.List;
import java.util.Optional;

import com.eCommerce.eCommerceEggs.Dao.ProductDao;
import com.eCommerce.eCommerceEggs.Dominio.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductsServiceImpl  implements ProductsService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(readOnly=true)
    public List<Products> readProducts() {
        return (List<Products>) productDao.findAll();
    }

    @Override
    @Transactional
    public void saveP(Products product) {
        productDao.save(product);
    }

    @Override
    @Transactional
    public void deleteP(Long id) {
        productDao.deleteById(id);        
    }

    @Override
    @Transactional(readOnly=true)
    public Products encontrarProducts(Long id) {
        return productDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
	public void update(Products product) {
		productDao.save(product);		
	}

    @Override
    @Transactional(readOnly=true)
    public Optional<Products> get(Long id) {
        return productDao.findById(id);
    }
}
