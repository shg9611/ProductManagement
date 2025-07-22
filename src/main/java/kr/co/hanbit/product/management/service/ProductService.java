package kr.co.hanbit.product.management.service;

import kr.co.hanbit.product.management.entity.Product;
import kr.co.hanbit.product.management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public Product add(Product product){
        return productRepository.add(product);
    }
}
