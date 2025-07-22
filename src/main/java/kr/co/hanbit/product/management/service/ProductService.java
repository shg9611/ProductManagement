package kr.co.hanbit.product.management.service;

import kr.co.hanbit.product.management.dto.ProductDto;
import kr.co.hanbit.product.management.entity.Product;
import kr.co.hanbit.product.management.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    ProductService(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository=productRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto){
        Product product = modelMapper.map(productDto,Product.class);

        Product savedProduct= productRepository.add(product);

        return modelMapper.map(savedProduct,ProductDto.class);
    }
}
