package com.feivirus.ioc;

import javax.inject.Inject;

import com.feivirus.ioc.domain.annotation.Book;
import com.feivirus.ioc.service.ProductService;

public class IocController {
    @Inject
    @Book
    private ProductService bookProductService;
    
    @Inject
    @Book
    private ProductService telephonProductService;
    
    public static void main(String[] args) {
        System.out.println();
    }
}
