package kr.co.hanbit.product.management.service;

import kr.co.hanbit.product.management.dto.ProductDto;
import kr.co.hanbit.product.management.entity.Product;
import kr.co.hanbit.product.management.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public ProductDto findById(Long id){
        Product product = productRepository.findById(id);

        return modelMapper.map(product,ProductDto.class);

    }

    public List<ProductDto> findAll(){
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = productList.stream()
                .map(product->modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());

        return productDtoList;

    }

    public List<ProductDto> findByName(String name){
        List<Product> productList = productRepository.findByName(name);

        return productList.stream()
                .map(product->modelMapper.map(product,ProductDto.class))
                .toList();
    }

    public ProductDto updateProduct(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        Product updated = productRepository.update(product);

        return modelMapper.map(updated,ProductDto.class);
    }

    public void deleteProduct(Long id){

        productRepository.delete(id);
    }
}
