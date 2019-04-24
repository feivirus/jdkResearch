package com.feivirus.ioc.service.impl;

import javax.inject.Inject;

import com.feivirus.ioc.domain.Product;
import com.feivirus.ioc.service.ProductService;

public abstract class BaseProductServiceImpl  implements ProductService{
    @Inject
    protected Product product;

    public abstract Product getNewProduct();
}
