package kr.co.hanbit.product.management.infrastructure.repository;

import kr.co.hanbit.product.management.domain.EntityNotFoundException;
import kr.co.hanbit.product.management.domain.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Repository
public class ProductRepository {

    private List<Product> productList = new CopyOnWriteArrayList<>();
    private AtomicLong sequence = new AtomicLong(1L);

    public Product add(Product product){
        product.setId(sequence.getAndAdd(1L));

        productList.add(product);
        return product;
    }

    public Product findById(Long id){

        return productList.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow(()->new EntityNotFoundException("Product를 찾지 못하였습니다."));
    }

    public List<Product> findAll(){

        return productList;
    }

    public List<Product> findByName(String name){

        return productList.stream()
                .filter(product -> product.containName(name))
                .toList();
    }

    public Product update(Product product) {

        Integer indexToModify = productList.indexOf(product);
        productList.set(indexToModify,product);

        return product;
    }

    public void delete(Long id){

        Product target= this.findById(id);
        productList.remove(target);
    }
}
