package kr.co.hanbit.product.management.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import kr.co.hanbit.product.management.dto.ProductDto;

import java.util.Objects;


public class Product {

    private Long id;

    @Size(min=1, max=100)
    private String name;

    @Max(1_000_000)
    @Min(0)
    private Integer price;

    @Max(9_999)
    @Min(0)
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public boolean sameId(Long id) {
        return this.id.equals(id);
    }

    public boolean containName(String name){
        return this.name.contains(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    /*
    public void update(ProductDto productDto) {

        if (productDto.getName()!=null){
            this.name= productDto.getName();
        }
        if (productDto.getPrice()!=null){
            this.price= productDto.getPrice();
        }
        if (productDto.getAmount()!=null){
            this.amount= productDto.getAmount();
        }

    }*/
}

