package kr.co.hanbit.product.management.controller;

import kr.co.hanbit.product.management.dto.ProductDto;
import kr.co.hanbit.product.management.entity.Product;
import kr.co.hanbit.product.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService){
        this.productService=productService;
    }

    @RequestMapping(value="/products", method= RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto productDto){

        ProductDto savedProduct=productService.add(productDto);

        return savedProduct;
    }
}
