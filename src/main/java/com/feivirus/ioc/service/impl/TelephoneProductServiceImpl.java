package com.feivirus.ioc.service.impl;

import com.feivirus.ioc.domain.Product;

public class TelephoneProductServiceImpl extends BaseProductServiceImpl{

    @Override
    public Product getNewProduct() {
        product.setName("telephone");
        product.setNo("2");
        return product;
    }
    
}
