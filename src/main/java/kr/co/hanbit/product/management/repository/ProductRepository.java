package kr.co.hanbit.product.management.repository;

import kr.co.hanbit.product.management.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ProductRepository {

    private List<Product> productList = new CopyOnWriteArrayList<>();

    public Product add(Product product){
        productList.add(product);
        return product;
    }

}
