package com.eCommerce.eCommerceEggs.Service;

import java.util.List;

import com.eCommerce.eCommerceEggs.Dao.EggsDao;
import com.eCommerce.eCommerceEggs.Dominio.Eggs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EggsServiceImpl implements EggsService{

    @Autowired
    private EggsDao eggsDao;

    @Override
    @Transactional(readOnly=true)
    public List<Eggs> listarEggs() {
        return (List<Eggs>) eggsDao.findAll();
    }
}
