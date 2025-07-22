package kr.co.hanbit.product.management.repository;

import kr.co.hanbit.product.management.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private List<Product> productList = new CopyOnWriteArrayList<>();
    private AtomicLong sequence = new AtomicLong(1L);

    public Product add(Product product){
        product.setId(sequence.getAndAdd(1L));

        productList.add(product);
        return product;
    }

}
