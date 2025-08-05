package kr.co.hanbit.product.management.controller;

import jakarta.validation.Valid;
import kr.co.hanbit.product.management.dto.ProductDto;
import kr.co.hanbit.product.management.entity.Product;
import kr.co.hanbit.product.management.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService){
        this.productService=productService;
    }

    @RequestMapping(value="/products", method= RequestMethod.POST)
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto){

        ProductDto savedProduct=productService.add(productDto);

        return savedProduct;
    }

    @RequestMapping(value = "/products/{id}", method=RequestMethod.GET)
    public ProductDto findById(@PathVariable Long id){
        ProductDto targetProduct = productService.findById(id);
        return targetProduct;
    }

    @RequestMapping(value= "/products", method=RequestMethod.GET)
    public List<ProductDto> findProduct(
            @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return productService.findAll();
        }
        return productService.findByName(name);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
    public ProductDto updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto productDto
            ){

        productDto.setId(id);
        ProductDto updated = productService.updateProduct(productDto);

        return updated;

    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
