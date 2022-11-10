package com.example.shoppingproject.repository;

import com.example.shoppingproject.entity.CartProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    @Query("select cp from CartProduct cp where cp.cart.cartId = :cartId AND cp.productId = :productId")
    List<CartProduct> findByCartAndCartProductId(@Param("cartId") long cartId, @Param("productId") long productId);
}
