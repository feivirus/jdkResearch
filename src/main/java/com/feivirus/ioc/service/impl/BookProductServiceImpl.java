package com.feivirus.ioc.service.impl;

import com.feivirus.ioc.domain.Product;

public class BookProductServiceImpl extends BaseProductServiceImpl{

    @Override
    public Product getNewProduct() {
        
        product.setName("book");
        product.setNo("1");
        return product;
    }   
}
